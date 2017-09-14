package com.lrcf.yhb.product.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.remoting.Server;
import com.alibaba.fastjson.JSONObject;
import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.exception.BaseException;
import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.common.vo.UserBuyProductList;
import com.lrcf.yhb.common.vo.UserInvestRecordListVo;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dao.mapper.AccountsUsersBalancesDao;
import com.lrcf.yhb.dao.mapper.FinanceproductsUsersDao;
import com.lrcf.yhb.jms.api.NotifyMessageService;
import com.lrcf.yhb.jms.enums.NotifyTypeEnum;
import com.lrcf.yhb.pojo.AccountsUsersBalances;
import com.lrcf.yhb.pojo.FinanceproductsUsers;
import com.lrcf.yhb.pojo.RpcTransactionalMessage;
import com.lrcf.yhb.product.api.FinanceproductsUsersService;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by 孔荣勋 on 2017/5/15 0015.
 */
@Service("financeproductsUsersService")
public class FinanceproductsUsersServiceImpl implements FinanceproductsUsersService {

    @Autowired
    FinanceproductsUsersDao financeproductsUsersDao;
    @Autowired
    AccountsUsersBalancesService accountsUsersBalancesService;
    @Autowired
    NotifyMessageService notifyMessageService;
    /**
     *
     * @Description: 获取用户资产
     *
     * @return：List<FinanceproductsUsers>
     * @author: Krx
     * @date: 2017年5月8日 下午3:53:53
     */
    @Override
    public List<UserBuyProductList> getFinUserList(Map<String, Object> param) {
        String times = param.get("time").toString();
        String[] strs = times.replace("[","").replace("]","").split(",");
        String startTime = strs[0];
        String endTime = strs[1];

        //获取页数
        Integer page = Integer.parseInt(param.get("current").toString());
        //每页显示多少记录数
        Integer size = Integer.parseInt(param.get("size").toString());
        //重新计算页数
        param.remove("current");

        param.put("current",(page - 1) * size);
        param.put("startTime",startTime);
        param.put("endTime",endTime);

//        List<UserBuyProductList> userBuyProductList = financeproductsUsersDao.getUserBuyProductList(param);
//        if (userBuyProductList.size() > 0 || StringUtil.isNotNull(userBuyProductList)) {
//            return userBuyProductList;
//        }
        return null;
    }

    /**
     *
     * @Description: 获取用户产品资产总数据记录数
     * @param: param
     * @return：返回结果描述
     * @author: Administrator
     * @date: 2017年5月12日 上午9:52:43
     */
    @Override
    public int getProductCount(Map<String, Object> param) {
        String times = param.get("time").toString();
        String[] strs = times.replace("[","").replace("]","").split(",");
        String startTime = strs[0];
        String endTime = strs[1];

        param.put("startTime",startTime);
        param.put("endTime",endTime);

        int count = financeproductsUsersDao.getProductCountByParam(param);

        return count;
    }


    /**
     *
     * @Description: 获取用户投资记录
     *
     * @return：List<FinanceproductsUsers>
     * @author: Krx
     * @date: 2017年5月8日 下午3:53:53
     */
    @Override
    public List<UserInvestRecordListVo> getUserInvestmentRecords(Integer id) {
        //根据产品Id获取当前产品投资用户记录
        List<FinanceproductsUsers> finUserList = financeproductsUsersDao.getUserInvestmentRecords(id);
        List<UserInvestRecordListVo> InvestList = new ArrayList<>();

        if (StringUtil.isNotNull(finUserList)) {

            for (FinanceproductsUsers financeproductsUsers: finUserList) {
                //获取用户信息
                String trueName = financeproductsUsers.getTrueName().replace(financeproductsUsers.getTrueName().substring(1, financeproductsUsers.getTrueName().length()), "**"); //账户姓名
                String userName = financeproductsUsers.getUserName().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"); //账户
                BigDecimal buyMoney = financeproductsUsers.getFproductsbuymoney().setScale(2, BigDecimal.ROUND_HALF_UP);//购买金额
                Date time = financeproductsUsers.getFproductsbuytime();//购买时间

                //创建vo实体传输对象
                UserInvestRecordListVo vo = new UserInvestRecordListVo(trueName, userName, buyMoney, DateUtil.parseToDateTimeStr(time));
                InvestList.add(vo);
            }

        }

        return InvestList;
    }

    /**
     *
     * @Description: 购买产品
     *
     * @return：List<FinanceproductsUsers>
     * @author: Krx
     * @date: 2017年5月8日 下午3:53:53
     */
    @Override
    public Map<String, Object> buyPro(Map<String, String> param) {
        return null;
    }

    /**
     * 根据购买产品的唯一订单Id删除订单账号
     *
     * @param fpuid
     * @return
     */
    @Override
    public boolean deleteProduct(String fpuid) {
        if (financeproductsUsersDao.deleteByPrimaryKey(Integer.parseInt(fpuid)) > 0) {
            return true;
        }

        return false;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public YhbResult test(){
        Map<String , String> notifyMap = new HashMap<String , String >();
        notifyMap.put("money", "1000");
        notifyMap.put("userId", "0ED1BA21-8DD1-40CF-B4A0-E25E3FD22312");
        notifyMap.put("name", "汇丰念法");
        notifyMap.put("fpid", "111");

        String messageId = StringUtil.getUUId();
        notifyMap.put("messageId", messageId);

        String messageBody = JSONObject.toJSONString(notifyMap);

        RpcTransactionalMessage message = new RpcTransactionalMessage(messageId, messageBody, NotifyTypeEnum.BUY_PRODUCT.name());
        int saveSendMessage = notifyMessageService.saveMessageWaitingConfirm(message); //保存消息

        if (saveSendMessage > 0) {
            FinanceproductsUsers financeproductsUsers = new FinanceproductsUsers();
                financeproductsUsers.setFproductsbuymoney(new BigDecimal(notifyMap.get("money")));
            financeproductsUsers.setUserid(notifyMap.get("userId"));
            financeproductsUsers.setFproductsname(notifyMap.get("name"));
            try {
                String fpuid = "";

                if (financeproductsUsersDao.insert(financeproductsUsers) > 0) {
                    fpuid = String.valueOf(financeproductsUsers.getFpuid());
                }
                //获取这一次操作的唯一订单号，更改消息内容重新发送
                notifyMap.put("fpuid", fpuid);
                notifyMessageService.updateSendMessageBody(messageId, JSONObject.toJSONString(notifyMap));
            } catch (Exception s) {
                return YhbResult.build(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getCodeDesc());
            }

            //更新消息状态
            notifyMessageService.confirmAndSendMessage(messageId);
            System.out.println("------------发送消息"+message);


            return YhbResult.success("交易正在处理");
        }
        return YhbResult.build(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getCodeDesc());
    }



}