package com.lrcf.yhb.product.service;


import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.util.CheckFormUtil;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.dao.mapper.AccountChangeinfoDao;
import com.lrcf.yhb.pojo.AccountChangeinfo;
import com.lrcf.yhb.pojo.BaseConfig;
import com.lrcf.yhb.product.api.AccountChangeinfoServie;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.lrcf.yhb.user.api.BaseConfigService;
import com.lrcf.yhb.user.api.LogMoneyChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AccountChangeinfoServieImpl.java
 * @Description: 活期宝转入转出明细实现类
 * @author:Krx
 * @date: 2017年5月11日 上午10:04:40
 */
@Service("accountChangeinfoServie")
public class AccountChangeinfoServieImpl implements AccountChangeinfoServie {
    private static Logger logger = LoggerFactory.getLogger(AccountChangeinfoServieImpl.class);

    @Autowired
    AccountChangeinfoDao accountChangeinfoDao;
    @Autowired
    AccountsUsersBalancesService balancesService;
    @Autowired
    LogMoneyChangeService logMoneyChangeService;
    @Autowired
    BaseConfigService baseConfigService;


    static Map param = null;
    /**
     *
     * @Description: 活期活期宝转入转出List
     *
     * @param: param
     * @return： List<AccountChangeinfo>
     * @author: Krx
     * @date: 2017年5月11日 上午10:05:37
     */
    @Override
    public List<AccountChangeinfo> getAccountChangeinfoList(Map<String, Object> params) {
        param = new HashMap();
        //获取页数
        Integer page = Integer.parseInt(param.get("current").toString());
        //每页显示多少条
        Integer size = Integer.parseInt(param.get("size").toString());
        //封装Map参数
        param.put("userId", params.get("userId"));
        param.put("type", params.get("type"));
        param.put("current",(page - 1) * size);
        param.put("total", size);
        param.put("startTime",params.get("startTime"));
        param.put("endTime", params.get("endTime"));
        //根据Type查询List
        List<AccountChangeinfo> accountChangeinfoList = accountChangeinfoDao.userCurrentRecord(param);
        if (accountChangeinfoList != null && accountChangeinfoList.size() > 0) {
            return accountChangeinfoList;
        }

        return null;
    }

    /**
         *
         * @Description:  获取活期宝转入转出条数
         *
         * @param: param
         * @return： int
         * @author: Krx
         * @date: 2017年5月11日 上午10:05:37
         */
        @Override
        public int countAccountChangeInfoTotal(Map<String, Object> params) {
            param = new HashMap();
            param.put("userId", params.get("userId"));
            param.put("type", params.get("type"));
            param.put("startTime",params.get("startTime"));
            param.put("endTime", params.get("endTime"));
            int count = accountChangeinfoDao.userCurrentRecordCount(param);
            return count;
    }

    /**
     * @param param
     * @Description: 活期宝转入转出金额
     * @param:  type 0:转出/1:转入 money 转入/转出金额 payPwd 支付密码
     * @return： int
     * @author: Krx
     * @date: 2017年5月19日 上午10:22:37
     */
    @Override
    public Map<String, Object> changeCurrent(Map<String, Object> param) {
        String type = param.get("type").toString();
        String money = param.get("money").toString();
        String payPwd = param.get("payPwd").toString();
        String token = param.get("token").toString();

        Map<String, Object> returnMap = new HashMap<String, Object>();
        if(StringUtil.isNull(type) || StringUtil.isBlank(type)){
            returnMap.put("code", ResultEnum.TYPE_ISNULL.getCode());
            returnMap.put("msg",ResultEnum.TYPE_ISNULL.getCodeDesc());
        }

        if(!type.equals("0") || !type.equals("1")){
            returnMap.put("code", ResultEnum.TYPE_FORM_ISERRPR.getCode());
            returnMap.put("msg",ResultEnum.TYPE_FORM_ISERRPR.getCodeDesc());
        }

        if (StringUtil.isBlank(money) || StringUtil.isNull(money)) {
            returnMap.put("code", ResultEnum.CURRENT_MONEY_ISNULL.getCode());
            returnMap.put("msg",ResultEnum.CURRENT_MONEY_ISNULL.getCodeDesc());
        }

        if(!CheckFormUtil.isMoney(money)){
            returnMap.put("code", ResultEnum.MONEY_FORM_ISERROR.getCode());
            returnMap.put("msg",ResultEnum.MONEY_FORM_ISERROR.getCodeDesc());
        }

        if (StringUtil.isBlank(payPwd) || StringUtil.isNull(payPwd)) {
            returnMap.put("code", ResultEnum.PAYPWD_ISNULL.getCode());
            returnMap.put("msg",ResultEnum.PAYPWD_ISNULL.getCodeDesc());
        }

        BaseConfig config = baseConfigService.selectByParam("cfg_notbetradedTime");
        if(config != null && config.getData().equals("1")){
            returnMap.put("code", ResultEnum.PAY_TIME_ISERROR.getCode());
            returnMap.put("msg",config.getValuese());
        }

        if(returnMap == null && returnMap.size() == 0){
            returnMap = transactionCurrent(Integer.parseInt(type), new BigDecimal(money), payPwd,token);
        }
        return returnMap;
    }

    /**
     * 内部方法交易活期宝
     * 该方法加锁，保证一个在执行，别的人在等待
     * @return
     */
    public synchronized Map<String,Object> transactionCurrent(Integer type, BigDecimal money,String payPwd,String token){
        Map<String, Object> returnMap = new HashMap<String, Object>();
//        // 获取用户信息
//        AccountsUsers users = cache.getUserRedis(token, 1, AccountsUsers.class);
//        if(users != null){
//            if(DesEncrypt.checkPassword(users.getCheckpassword(),payPwd)){
//                //获取用户资金
//                AccountsUsersBalances usersBalances = balancesService.selectByUserId(users.getUserid());
//                //最后更改的金额
//                BigDecimal changeMoney = BigDecimal.ZERO;
//                BigDecimal userCurrent = usersBalances.getUsercurrent();
//                //活期宝  0:转出  1:转入
//                String msg = "";
//                String state = "";
//                if(type == 0){
//
//                    changeMoney =  userCurrent.subtract(money);
//                    msg = "活期宝转出";
//                    state = "2";
//
//                }else if (type == 1) {
//
//                    changeMoney = userCurrent.add(money);
//                    msg = "活期宝转入";
//                    state = "1";
//
//                }
//
//                if (StringUtil.isBlank(msg)
//                        && StringUtil.isNull(msg)
//                        && StringUtil.isBlank(state)
//                        && StringUtil.isNull(state)) {
//
//                    //更新活期宝余额
//                    usersBalances.setUsercurrent(changeMoney);
//                    balancesService.updateUserBalance(usersBalances);
//
//                    //插入金额日志
//                    LogMoneyChange logMoney = new LogMoneyChange(users.getUserid(), users.getUsername(),
//                            changeMoney, BigDecimal.ZERO, usersBalances.getUsercurrent(), type == 0 ? "-" : "+", msg,new Date());
//                    logMoneyChangeService.insertLogMoneyChange(logMoney);
//
//                    //插入转出转出记录
//                    AccountChangeinfo changeinfo = new AccountChangeinfo();
//                    changeinfo.setAccounttype(state);
//                    changeinfo.setAccountchange(userCurrent);
//                    changeinfo.setChangedate(new Date());
//                    changeinfo.setChangevalue(money);
//                    changeinfo.setLastbalance(changeMoney);
//                    changeinfo.setRemark(msg);
//                    changeinfo.setUserid(users.getUserid());
//                    //判断出入资金记录插入是否正确
//                    boolean flag = insetAccountChangeInfo(changeinfo);
//                    if (flag) {
//                        returnMap.put("code", ResultEnum.SUCCESS.getCode());
//                        returnMap.put("msg",msg+"成功");
//                    }else{
//                        returnMap.put("code", ResultEnum.ERROR.getCode());
//                        returnMap.put("msg",ResultEnum.ERROR.getCodeDesc());
//                    }
//                }
//            }else{
//                returnMap.put("code", ResultEnum.PAYPWD_ISERROR.getCode());
//                returnMap.put("msg",ResultEnum.PAYPWD_ISERROR.getCodeDesc());
//            }
//        }else{
//            returnMap.put("code", ResultEnum.ERROR.getCode());
//            returnMap.put("msg",ResultEnum.ERROR.getCodeDesc());
//        }

        return returnMap;
    }


    /***
     * 插入转入转出记录
     * @param changeinfo
     * @return
     */
    public boolean insetAccountChangeInfo(AccountChangeinfo changeinfo) {
        boolean flag = false;
        if (accountChangeinfoDao.insertSelective(changeinfo) > 0) {
            flag = true;
        }
        return flag;
    }

}
