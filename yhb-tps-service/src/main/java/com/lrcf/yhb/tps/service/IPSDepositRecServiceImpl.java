package com.lrcf.yhb.tps.service;

import com.lrcf.yhb.common.api.ips.IpsConstants;
import com.lrcf.yhb.common.api.ips.JsonUtils;
import com.lrcf.yhb.common.util.GenerateNo;
import com.lrcf.yhb.common.util.ThreeDesUtils;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.tps.api.IPSDepositRecService;
import com.lrcf.yhb.tps.util.IpsGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
@Service("iPSDepositRecService")
public class IPSDepositRecServiceImpl implements IPSDepositRecService {

    @Value("${IPS.DesKey}")
    private String deskey;
    @Value("${IPS.IV}")
    private String iv;
    @Value("${IPS.loginUrl}")
    private String loginUrl;
    @Value("${IPS.merchantID}")
    private String merchantID;

    private Date merDate = new Date();
    private static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public YhbResult test() {
        String str = "QucQTnhV9D1DEoh9ZZyTQ5ZSaW/YOqOtb2IOIeDufzBlh1R/rL1InujhuDNbxFS7QP1pp77ol6OEsZOo7AdmTuJ4f4ceIn7qaWG5sicOIZsXqkzMltZWTeeUhAQjQJgRxiW+G5esA1HIVmKl0b0F53+mU3zb7h4rNGI++gkk/smNM8oc85oljFUhGm229rt2";
        String responseText = ThreeDesUtils.decrypt3DES(str.replace(" ", "+"), this.deskey, this.iv);

        return YhbResult.success(responseText);
    }

    public static void main(String[] args) {
        String str = "QucQTnhV9D3w1lGxrqojLcJ4CauqaeltO9DqrG8BqlWTZv+6LpJ0pbNWH11TZxVxNH4CpI1wKlcuiRKR7FdugRFNaqmFpvI8bVk1gCZXw8Ksr7QkTc5MLGYW7j+2Eb2z";
        String responseText = ThreeDesUtils.decrypt3DES(str.replace(" ", "+"), "r0uScmDuH5FLO37AJV2FN72J", "1eX24DCe");
        System.out.println(responseText);
    }

    /**
     * 用户注册
     *
     * @param param@return
     * @throws Exception
     */
    @Override
    public Map<String, String> userRegister(Map<String, String> param) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.userRegister);
        //拼接request Json
        Map<String, String> map = new HashMap<String, String>();
        map.put(IpsConstants.operationType, IpsConstants.userRegister);
        map.put(IpsConstants.merBillNo, GenerateNo.getRecordNo());
        map.put(IpsConstants.merDate, sdf.format(merDate));
//        map.put(IpsConstants.userType, param.get("userType").toString());
        map.put(IpsConstants.userType, "1");
//        map.put(IpsConstants.userName, param.get("userName").toString());
        map.put(IpsConstants.userName, param.get("mobileNo").toString());
        map.put(IpsConstants.mobileNo, param.get("mobileNo").toString());
        map.put(IpsConstants.identNo, param.get("identNo").toString());
//        map.put(IpsConstants.bizType, param.get("bizType").toString());
        map.put(IpsConstants.bizType, "1");
        map.put(IpsConstants.realName, param.get("realName").toString());
        map.put(IpsConstants.enterName, param.get("enterName") == null ? null : param.get("enterName").toString());
//        map.put(IpsConstants.enterName, "上海岚儒金融信息服务公司" );
        map.put(IpsConstants.orgCode, param.get("orgCode") == null ? null : param.get("orgCode").toString());
//        map.put(IpsConstants.orgCode, "91310115332629382W");
        map.put(IpsConstants.isAssureCom, param.get("isAssureCom") == null ? null : param.get("isAssureCom").toString());
//        map.put(IpsConstants.isAssureCom, "1");
        map.put(IpsConstants.webUrl, IpsConstants.IpsWebUrl);
        map.put(IpsConstants.s2SUrl, IpsConstants.IpsFrontUrl);

        //删除拼接多余的键
        map.remove(IpsConstants.operationType);
        //加密
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);
        params.put(IpsConstants.merBillNo, map.get(IpsConstants.merBillNo));
        params.put("userId", param.get("userId"));
        return IpsGateway.getHuifuFormParams(params);
    }

    /**
     * 商户直连银行查询
     *
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> queryBankQuery() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.queryBankQuery);

        Map<String, String> map = new HashMap<String, String>();
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);

        return IpsGateway.postHuifuParams(params);
    }

    /**
     * 用户登录
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> userLogin(String username) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("gateWayUrl", loginUrl);
        params.put("userName", username);
        params.put("merchantId", merchantID);
        return params;
    }

    /**
     * 查询接口
     * 查询接口主要为互联网金融平台进行账户和交易查询使用。
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> queryCommonQuery(Map<String, String> param) throws Exception {
        return null;
    }

    /**
     * 用户充值
     *
     * @param p
     */
    @Override
    public Map<String, String> tradeDeposit(Map<String, String> p) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.tradeDeposit);
        // 拼接request json
        Map<String, String> map = new HashMap<String, String>();
        map.put(IpsConstants.operationType, IpsConstants.tradeDeposit);
        map.put(IpsConstants.merBillNo, GenerateNo.getRecordNo());
        map.put(IpsConstants.merDate, sdf.format(merDate));
//        map.put(IpsConstants.depositType, p.get("depositType").toString());  //充值类型：1、普通充值 2、还款充值
        map.put(IpsConstants.depositType, "1");
//        map.put(IpsConstants.channelType, p.get("channelType").toString());//充值渠道 1、个人网银 2、企业网银（用户发起且为普通充值时必填）
        map.put(IpsConstants.channelType, "1");
        map.put(IpsConstants.bankCode, p.get("bankCode").toString());
//        map.put(IpsConstants.userType, p.get("userType").toString());//用户类型 1、个人 2、企业
        map.put(IpsConstants.userType, "1");
        map.put(IpsConstants.ipsAcctNo, p.get("ipsAcctNo").toString());
        map.put(IpsConstants.trdAmt, p.get("trdAmt").toString());
//        map.put(IpsConstants.ipsFreeType, p.get("ipsFreeType").toString()); // ips
        // 手续费承担方:1、平台商户2、平台用户
        map.put(IpsConstants.ipsFreeType, "1");
//        map.put(IpsConstants.merFee, p.get("merFee").toString()); // 平台收取用户的手续费
        map.put(IpsConstants.merFee, "0");
//        map.put(IpsConstants.merFeeType, p.get("merFeeType").toString()); // 平台手续费收取方式：1、内扣，2、外扣
        map.put(IpsConstants.merFeeType, "2");
//        map.put(IpsConstants.taker, p.get("taker").toString()); // 发起方：1、商户发起，2、用户发起（商户发起时充值类型只能为还款充值）
        map.put(IpsConstants.taker, "2");
        map.put(IpsConstants.webUrl, IpsConstants.IpsWebUrl);
        map.put(IpsConstants.s2SUrl, IpsConstants.IpsFrontUrl);
        map.remove(IpsConstants.operationType);
        // request DES加密
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);
        params.put(IpsConstants.merBillNo, map.get(IpsConstants.merBillNo));
        params.put("userId", p.get("userId"));
        // sign = operationType + 商户订单号 + request + me5Key
        return IpsGateway.getHuifuFormParams(params);
    }

    /**
     * 用户提现接口
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> tradeWithdraw(Map<String, String> p) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.tradeWithdraw);
        // 拼接request json
        Map<String, String> map = new HashMap<String, String>();
        map.put(IpsConstants.operationType, IpsConstants.tradeWithdraw);
        map.put(IpsConstants.merBillNo, GenerateNo.getRecordNo());
        map.put(IpsConstants.merDate, sdf.format(merDate));
//        map.put(IpsConstants.userType, p.get("userType").toString());  //1个人 2 企业
        map.put(IpsConstants.userType, "1");
        map.put(IpsConstants.trdAmt, p.get("trdAmt").toString());
//        map.put(IpsConstants.merFee, p.get("merFee")); //平台手续费
        map.put(IpsConstants.merFee, "0");
//        map.put(IpsConstants.merFeeType, p.get("merFeeType"));//平台手续内外扣类型 内扣 1、外扣 2
        map.put(IpsConstants.merFeeType, "1");
//        map.put(IpsConstants.ipsFreeType, p.get("ipsFreeType").toString());  //1：平台承担，2：用户承担
        map.put(IpsConstants.ipsFreeType, "2");
        map.put(IpsConstants.ipsAcctNo, p.get("ipsAcctNo").toString());
        map.put(IpsConstants.webUrl, IpsConstants.IpsWebUrl);
        map.put(IpsConstants.s2SUrl, IpsConstants.IpsFrontUrl);
        map.remove(IpsConstants.operationType);
        // request DES加密
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);
        params.put(IpsConstants.merBillNo, map.get(IpsConstants.merBillNo));
        params.put("userId", p.get("userId"));
        return IpsGateway.getHuifuFormParams(params);
    }

    /**
     * 用户转账
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> tradeTransfer(Map<String, String> param) throws Exception {
        return null;
    }

    /**
     * 用户冻结接口
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> tradeFreeze(Map<String, String> p) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.tradeWithdraw);
        // 拼接request json
        Map<String, String> map = new HashMap<String, String>();
        map.put(IpsConstants.operationType, IpsConstants.tradeWithdraw);
        map.put(IpsConstants.merBillNo, GenerateNo.getRecordNo());
        map.put(IpsConstants.merDate, sdf.format(merDate));
        map.put(IpsConstants.projectNo, p.get("projectNo"));
        map.put(IpsConstants.bizType, p.get("bizType"));
        map.put(IpsConstants.regType, p.get("regType") );
        map.put(IpsConstants.contractNo, p.get("contractNo"));
        map.put(IpsConstants.authNo, p.get("authNo") == null ? null : p.get("authNo"));
        map.put(IpsConstants.trdAmt, p.get("trdAmt"));
        map.put(IpsConstants.merFee, p.get("merFee") == null ? null : p.get("merFee"));
        map.put(IpsConstants.freezeMerType, p.get("freezeMerType"));
        map.put(IpsConstants.ipsAcctNo, p.get("ipsAcctNo"));
//        map.put(IpsConstants.otherIpsAcctNo,
//                p.get("otherIpsAcctNo") == null ? null : p.get("otherIpsAcctNo").toString());
        map.put(IpsConstants.webUrl,IpsConstants.IpsFrontUrl);
        map.put(IpsConstants.s2SUrl,IpsConstants.IpsWebUrl);
        map.remove(IpsConstants.operationType);
        // request DES加密
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);
        params.put(IpsConstants.merBillNo, map.get(IpsConstants.merBillNo));
        return IpsGateway.getHuifuFormParams(params);
    }

    /**
     * 用户解冻接口
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> tradeUnFreeze(Map<String, String> p) throws Exception {
        return null;
    }

    /**
     * 项目登记接口
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> projectRegProject(Map<String, String> p) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.projectRegProject);
        // 拼接request json
        Map<String, String> map = new HashMap<String, String>();
        map.put(IpsConstants.operationType, IpsConstants.projectRegProject);
        map.put(IpsConstants.merBillNo, GenerateNo.getRecordNo());
        map.put(IpsConstants.merDate, sdf.format(merDate));
        map.put(IpsConstants.projectNo, GenerateNo.numOrdId());
        map.put(IpsConstants.projectName,  p.get("projectName"));
        map.put(IpsConstants.projectType, p.get("projectType"));
        map.put(IpsConstants.projectAmt, p.get("projectAmt"));
        map.put(IpsConstants.rateType, p.get("rateType"));// 1：固定 2：浮动
        map.put(IpsConstants.rateVal, p.get("rateVal")); // 类型为固定时不可为空,百分数表示利率值  0<=利率<=48%，利率值0 代表没有利率如 25.25 表示25.25%
        map.put(IpsConstants.cycVal, p.get("cycVal")); // 周期为天 0表示无限大
        map.put(IpsConstants.projectUse, p.get("projectUse")); // 项目用途
        map.put(IpsConstants.finaAccType,"2");// 融资方账户类型1：个人 2：企业
        map.put(IpsConstants.finaCertNo, p.get("finaCertNo")); // 融资方证件号
        map.put(IpsConstants.finaName, p.get("finaName"));// 融资方姓名
        map.put(IpsConstants.finaIpsAcctNo, p.get("finaIpsAcctNo")); // 融资方IPS账号
        map.put(IpsConstants.isExcess, p.get("isExcess")); // 是否超额
        map.put(IpsConstants.s2SUrl, IpsConstants.IpsWebUrl);
        map.remove(IpsConstants.operationType);
        // request DES加密
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);
        params.put(IpsConstants.merBillNo, map.get(IpsConstants.merBillNo));
        return IpsGateway.getHuifuFormParams(params);
    }

    /**
     * 项目追加登记接口
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> projectAssureProject(Map<String, String> p) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put(IpsConstants.operationType, IpsConstants.projectRegProject);
        // 拼接request json
        Map<String, String> map = new HashMap<String, String>();
        map.put(IpsConstants.operationType, IpsConstants.projectRegProject);
        map.put(IpsConstants.merBillNo, GenerateNo.getRecordNo());
        map.put(IpsConstants.merDate, sdf.format(merDate));
        map.put(IpsConstants.projectNo, p.get("projectNo"));
        map.put(IpsConstants.assureAmt, p.get("assureAmt")); // 担保金额 不能大于担保的项目金额
        map.put(IpsConstants.assureIncome, p.get("assureIncome")); // 担保收益 最多为担保金额的 10%
        map.put(IpsConstants.assureType, p.get("assureType")); // 担保方类型 1:个人 2:企业
        map.put(IpsConstants.assureIpsAcctNo, p.get("assureIpsAcctNo"));// 担保方的 IPS存管账户号
        map.put(IpsConstants.s2SUrl, IpsConstants.IpsWebUrl);
        map.remove(IpsConstants.operationType);
        // request DES加密
        String request = ThreeDesUtils.encrypt3DES(JsonUtils.toParseJson(map), deskey, iv);
        params.put(IpsConstants.request, request);
        params.put(IpsConstants.merBillNo, map.get(IpsConstants.merBillNo));
        return IpsGateway.getHuifuFormParams(params);
    }

    /**
     * 红包组合冻结接口
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> tradeCombFreeze(Map<String, String> p) throws Exception {
        return null;
    }

}

