package com.lrcf.yhb.tps.service;

import com.lrcf.yhb.common.api.ips.JsonUtils;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.pojo.AccountsUsersBalances;
import com.lrcf.yhb.pojo.HxOrderInfo;
import com.lrcf.yhb.tps.api.HuanXunOrderInfoService;
import com.lrcf.yhb.tps.api.IpsHuanXunRecvService;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.lrcf.yhb.user.api.AccountsUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 环迅回调
 * Created by Krx on 2017/7/28 0028.
 */
@Service("ipsHuanXunRecvService")
public class IpsHuanXunRecvServiceImpl implements IpsHuanXunRecvService{
    private static Logger log = LoggerFactory.getLogger(HuanXunOrderInfoServiceImpl.class);

    @Autowired
    HuanXunOrderInfoService hxOrderInfoService;
    @Autowired
    AccountsUsersService accountsUsersService;
    @Autowired
    AccountsUsersBalancesService usersBalancesService;
//    @Autowired
//    NotifyMessageService notifyMessageService;


    /**
     * 注册
     *
     * @param params
     */
    @Override
    public YhbResult userRegister(Map<String, String> params) {
        log.info("返回到rec里面的参数:" + params);
        try {
            HxOrderInfo orderInfo = hxOrderInfoService.selectByMerBill(params.get("merBillNo"));
            //请求信息转为map
            Map<String, Object> map = (Map<String, Object>)JsonUtils.parseMapToJSON(orderInfo.getReqInfo());
            log.info("userId:" + map.get("userId"));
            AccountsUsers user = accountsUsersService.selectUserByPrimaryKey(map.get("userId").toString());

            if (user == null) {
                log.error("查无此账户-->" + params);
                return YhbResult.build(104, "数据异常,用户插入环迅Id失败,更新失败");

            } else if (user != null) {
                if (user.getIpsId() != null && user.getIpsUsrcustid() != null) {
                    log.error("user has register in Huifu-->" + params);
                    return new YhbResult(200, "您已成功完成注册，请牢记您的账号和密码。");
                } else {
                    System.out.println("存入数据的参数" + params);
                    user.setIpsId(params.get("ipsBillNo"));// 订单号
                    user.setIpsUsrcustid(params.get("ipsAcctNo"));// 虚拟账号
                    boolean flag = accountsUsersService.updateUserInfo(user);

                    if(flag) {
                        return new YhbResult(200, "您已成功完成注册，请牢记您的账号和密码。");
                    }
//                    else{
//                        //进入消息轮询状态
//                        //设置唯一id
//                        params.put("messageId", StringUtil.getUUId());
//                        String messageBody = JSONObject.toJSONString(params);
//
//                        RpcTransactionalMessage  message =  new RpcTransactionalMessage(params.get("messageId"), messageBody, NotifyTypeEnum.HX_CREATEUSER.name());
//                        int saveSendMessage = notifyMessageService.saveMessageWaitingConfirm(message); //保存消息
//                        if (saveSendMessage > 0) {
//
//                        }
//                    }

                }
            }
            log.error("no found user-->" + params);
            return new YhbResult(-100, "程序异常，注册失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 充值
     *
     * @param params
     * @return
     */
    @Override
    public YhbResult tradeDeposit(Map<String, String> params) {
        try {
            log.info("充值回调参数内容:" + params);
            HxOrderInfo orderInfo = hxOrderInfoService.selectByMerBill(params.get("merBillNo"));
            //请求信息转为map
            Map<String, Object> map = (Map<String, Object>)JsonUtils.parseMapToJSON(orderInfo.getReqInfo());
            log.info("userId:" + map.get("userId"));
            AccountsUsers user = accountsUsersService.selectUserByPrimaryKey(map.get("userId").toString());
            if (user == null) {
                log.error("查无此账户-->" + params);
                return YhbResult.build(104, "数据异常,用户插入环迅Id失败,更新失败");
            }

            if(user != null){
                AccountsUsersBalances usersBalances = usersBalancesService.selectByUserId(user.getUserid());
                if (usersBalances != null) {
                    BigDecimal ipsTrdAmt = new BigDecimal(params.get("ipsTrdAmt").toString());
                    usersBalances.setUserbalance(usersBalances.getUserbalance().add(ipsTrdAmt));
                    boolean flag = usersBalancesService.updateUserBalance(usersBalances);
                    if (flag) {
                        return new YhbResult(200, "充值成功");
                    }
                }
            }

            log.error("no found user-->" + params);
            return new YhbResult(-100, "程序异常，充值失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 提现
     *
     * @param params
     * @return
     */
    @Override
    public YhbResult tradeWithdraw(Map<String, String> params) {
            try {
                log.info("提现回调参数内容:" + params);
                HxOrderInfo orderInfo = hxOrderInfoService.selectByMerBill(params.get("merBillNo"));
                //请求信息转为map
                Map<String, Object> map = (Map<String, Object>)JsonUtils.parseMapToJSON(orderInfo.getReqInfo());
                log.info("userId:" + map.get("userId"));
                AccountsUsers user = accountsUsersService.selectUserByPrimaryKey(map.get("userId").toString());
                if (user == null) {
                    log.error("查无此账户-->" + params);
                    return YhbResult.build(104, "数据异常,用户插入环迅Id失败,更新失败");
                }

                if(user != null){
                    AccountsUsersBalances usersBalances = usersBalancesService.selectByUserId(user.getUserid());
                    if (usersBalances != null) {
                        BigDecimal ipsTrdAmt = new BigDecimal(params.get("ipsTrdAmt").toString());
                        usersBalances.setUserbalance(usersBalances.getUserbalance().subtract(ipsTrdAmt).subtract(new BigDecimal(3)));
                        boolean flag = usersBalancesService.updateUserBalance(usersBalances);
                        if (flag) {
                            return new YhbResult(200, "提现成功");
                        }
                    }
                }

                log.error("no found user-->" + params);
                return new YhbResult(-100, "程序异常，提现失败");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
    }

    /**
     * 项目登记
     *
     * @param params
     * @return
     */
    @Override
    public YhbResult projectRegProject(Map<String, String> params) {
        try {
            log.info("登记项目回调参数内容:" + params);
            HxOrderInfo orderInfo = hxOrderInfoService.selectByMerBill(params.get("merBillNo"));
            //请求信息转为map
            Map<String, Object> map = (Map<String, Object>)JsonUtils.parseMapToJSON(orderInfo.getReqInfo());

            log.info("登记项目参数解密后参数内容:" + map);
            return new YhbResult(200, "登记成功");
            //log.error("no found user-->" + map);
            //return new YhbResult(-100, "程序异常，提现失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    /**
     * 项目追加登记
     *
     * @param params
     * @return
     */
    @Override
    public YhbResult projectAssureProject(Map<String, String> params) {
        try {
            log.info("追加登记项目回调参数内容:" + params);
            HxOrderInfo orderInfo = hxOrderInfoService.selectByMerBill(params.get("merBillNo"));
            //请求信息转为map
            Map<String, Object> map = (Map<String, Object>)JsonUtils.parseMapToJSON(orderInfo.getReqInfo());

            log.info("追加登记项目参数解密后参数内容:" + map);
            return new YhbResult(200, "追加登记成功");
            //log.error("no found user-->" + map);
            //return new YhbResult(-100, "程序异常，提现失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 冻结接口
     *
     * @param params
     * @return
     */
    @Override
    public YhbResult tradeFreeze(Map<String, String> params) {
        try {
            log.info("冻结接口返回的参数:" + params);
            HxOrderInfo orderInfo = hxOrderInfoService.selectByMerBill(params.get("merBillNo"));
            //请求信息转为map
            Map<String, Object> map = (Map<String, Object>)JsonUtils.parseMapToJSON(orderInfo.getReqInfo());

            log.info("冻结接口返回的参数内容:" + map);
            return new YhbResult(200, "冻结成功");
            //log.error("no found user-->" + map);
            //return new YhbResult(-100, "程序异常，提现失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
