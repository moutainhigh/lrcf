package com.lrcf.yhb.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lrcf.yhb.common.api.ips.IpsConstants;
import com.lrcf.yhb.common.api.ips.JsonUtils;
import com.lrcf.yhb.common.enums.ResultEnum;
import com.lrcf.yhb.common.util.ThreeDesUtils;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.pojo.HxOrderInfo;
import com.lrcf.yhb.tps.api.HuanXunOrderInfoService;
import com.lrcf.yhb.tps.api.IPSDepositRecService;
import com.lrcf.yhb.user.api.AccountsUsersService;
import com.lrcf.yhb.web.util.HttpRequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * web，pc，app，充值调用接口
 * Created by Krx on 2017/6/15 0015.
 */
@RestController
public class IpsDepositController {

    private final static Logger log = LoggerFactory.getLogger(IpsDepositController.class);

    private Map<String, String> param = new HashMap<>();

    @Autowired
    IPSDepositRecService ipsDepositRecService;
    @Autowired
    HuanXunOrderInfoService huanXunOrderInfoService;
    @Autowired
    AccountsUsersService accountsUsersService;

    /**
    * @Desc 用户开户
    * @param -mobileNo 账号 -identNo 身份证号 -realName 真实姓名
    * @return  加密参数
    * @Author 孔荣勋【Krx】
    * @Date 2017/7/26 0026 14:46
    */
    @PostMapping(value = "/ips/wb/reg")
    public YhbResult userRegister(@RequestBody Map<String,String> params){
        try {
            log.info("参数信息:"+params);
            if(params.size() == 0){
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }

            AccountsUsers users = accountsUsersService.selectUserByUserName(params.get("mobileNo"));
            if (users == null) {
                return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
            }
            params.put("userId", users.getUserid());
            param = ipsDepositRecService.userRegister(params);
        } catch (Exception e) {
            log.info("异常信息:" + e.getMessage());
        }
        log.info("参数:" + param);
        return YhbResult.success(param);
    }

    /**
    * @Desc 用户充值操作
    * @param -trdAmt 充值金额  -bankCode 充值银行号 -ipsAcctNo  IPs商户账号
    * @return
    * @Author 孔荣勋【Krx】
    * @Date 2017/7/27 0027 10:40
    */
    @PostMapping(value = "/ips/wb/trade")
    public YhbResult userDeposit(@RequestBody Map<String,String> params){
        try {
            log.info("参数信息:" + params);
            if (params.size() == 0) {
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }

            AccountsUsers users = accountsUsersService.selectIpsAcctNo(params.get("ipsAcctNo"));
            if (users == null) {
                return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
            }
            params.put("userId", users.getUserid());
            param = ipsDepositRecService.tradeDeposit(params);
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
        }
        return YhbResult.success(param);
    }

    /**
    * @Desc   用户环迅登录
    * @param -userName 账户登录名 -商户号Id
    * @return
    * @Author 孔荣勋【Krx】
    * @Date 2017/7/27 0027 10:48
    */
    @PostMapping(value = "/ips/wb/login")
    public YhbResult userLogin(@RequestBody  Map<String,String> params){
        try {
            log.info("参数信息:" + params);
            String username = params.get("username");
            if (StringUtils.isBlank(username)) {
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }
            param = ipsDepositRecService.userLogin(username);
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
        }
        return YhbResult.success(param);
    }


    /**
     * 查询环迅公共银行卡
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/ips/queryb" ,method = RequestMethod.GET)
    public YhbResult getQueryBank()throws Exception{
        Map<String, String> m = ipsDepositRecService.queryBankQuery();

        if (m == null) {
            return YhbResult.build(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getCodeDesc());
        }
        String responseText = ThreeDesUtils.decrypt3DES(m.get(IpsConstants.response).replace(" ", "+"),
                "r0uScmDuH5FLO37AJV2FN72J","1eX24DCe"); // 把Map转为String
        return YhbResult.success(responseText);
    }



    /**
     * @Desc 用户提现操作
     * @param --trdAmt 提现金额   -ipsAcctNo ips商户账号
     * @return
     * @Author 孔荣勋【Krx】
     * @Date 2017/7/31 0031 14:16
     */
    @PostMapping(value = "/ips/wb/withdraw")
    public YhbResult withdraw(@RequestBody Map<String, String> params) {
        try {
            log.info("参数信息:" + params);
            if (params.size() == 0) {
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }

            AccountsUsers users = accountsUsersService.selectIpsAcctNo(params.get("ipsAcctNo"));
            if (users == null) {
                return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
            }

            params.put("userId", users.getUserid());
            param = ipsDepositRecService.tradeWithdraw(params);
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
        }
        return YhbResult.success(param);
    }


    /**
     * @Desc 项目登记接口
     * @param
     * @return
     * @Author 孔荣勋【Krx】
     * @Date 2017/7/31 0031 14:16
     */
    @PostMapping(value = "/ips/wb/regpro")
    public YhbResult projectRegProject(@RequestBody Map<String, String> params) {
        try {
            log.info("参数信息:" + params);
            if (params.size() == 0) {
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }

            AccountsUsers users = accountsUsersService.selectIpsAcctNo(params.get("finaIpsAcctNo"));
            if (users == null) {
                return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
            }

            param = ipsDepositRecService.projectRegProject(params);
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
        }
        return YhbResult.success(param);
    }




    /**
     * @Desc  项目追加登记接口
     * @param
     * @return
     * @Author 孔荣勋【Krx】
     * @Date 2017/7/31 0031 14:16
     */
    @PostMapping(value = "/ips/wb/regspro")
    public YhbResult projectAssureProject(@RequestBody Map<String, String> params) {
        try {
            log.info("参数信息:" + params);
            if (params.size() == 0) {
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }

            AccountsUsers users = accountsUsersService.selectIpsAcctNo(params.get("assureIpsAcctNo"));
            if (users == null) {
                return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
            }

            param = ipsDepositRecService.projectAssureProject(params);
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
        }
        return YhbResult.success(param);
    }



    /**
     * @Desc  项目冻结接口
     * @param
     * @return
     * @Author 孔荣勋【Krx】
     * @Date 2017/7/31 0031 14:16
     */
    @PostMapping(value = "/ips/wb/freeze")
    public YhbResult tradeFreeze(@RequestBody Map<String, String> params) {
        try {
            log.info("参数信息:" + params);
            if (params.size() == 0) {
                return YhbResult.build(ResultEnum.DATAS_ISNULL.getCode(), ResultEnum.DATAS_ISNULL.getCodeDesc());
            }

            AccountsUsers users = accountsUsersService.selectIpsAcctNo(params.get("ipsAcctNo"));
            if (users == null) {
                return YhbResult.build(ResultEnum.USER_ISNULL.getCode(), ResultEnum.USER_ISNULL.getCodeDesc());
            }

            param = ipsDepositRecService.tradeFreeze(params);
        } catch (Exception e) {
            log.error("异常信息:" + e.getMessage());
        }
        return YhbResult.success(param);
    }



}
