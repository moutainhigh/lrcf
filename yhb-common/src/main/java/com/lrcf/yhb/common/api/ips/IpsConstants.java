package com.lrcf.yhb.common.api.ips;

import java.util.HashMap;
import java.util.Map;

public class IpsConstants {


	public static final String HTML_Quotes_Double = "&quot;";// 双引号
	public static final String HTML_Quotes_Single = "&apos;";// 单引号

	//前端回调地址
	public static final String IpsWebUrl = "http://192.168.1.114:8081/Ips/huifu/bgReturn";
	//后端回调地址
	public static final String IpsFrontUrl = "http://192.168.1.114:8081/Ips/huifu/frontReturn";

	/**
	 * 是否本地main方法调用接口测试 提交服务器必须改成false
	 */
	public static final boolean IS_MAIN_TEST = false;
	/** 系统证书MD5 **/
	public static final String Md5Key = "MD5Key";
	/** 注册账户的类型 **/
	public static final String User_Type = "1";
	public static final String Biz_Type = "1";
	/** 查询接口查询类型 **/
	public static final String QueryUser_Type = "01";
	public static final String Trade_Type = "02";
	public static final String Balance_Type = "03";
	/******* user.register *********/
	public static final String merchantID = "merchantID";
	public static final String merBillNo = "merBillNo";
	public static final String merDate = "merDate";
	public static final String userType = "userType";
	public static final String userName = "userName";
	public static final String mobileNo = "mobileNo";
	public static final String identNo = "identNo"; // 自定义字段，用于我们系统传值
	public static final String bizType = "bizType";// 业务类型 1p2p
	public static final String realName = "realName";
	public static final String enterName = "enterName";
	public static final String orgCode = "orgCode";
	public static final String isAssureCom = "isAssureCom";
	public static final String webUrl = "webUrl"; // 提交的地址
	public static final String s2SUrl = "s2SUrl"; // 返回的
	public static final String sign = "sign";// 签名
	public static final String operationType = "operationType";// 操作类型
	public static final String request = "request";// 请求报文
	public static final String response = "response";// 应答报文
	public static final String ipsBillNo = "ipsBillNo";

	/******* trade.deposit *********/
	public static final String depositType = "depositType"; // 充值类型：1、普通充值
															// 2、还款充值
	public static final String channelType = "channelType"; // 充值渠道 1、个人网银
															// 2、企业网银（用户发起且为普通充值时必填）
	public static final String bankCode = "bankCode"; // 银行编号
	public static final String ipsAcctNo = "ipsAcctNo";// IPs 虚拟账户号
	public static final String trdAmt = "trdAmt"; // 充值金额
	public static final String ipsFreeType = "ipsFeeType"; // ips
															// 手续费承担方:1、平台商户2、平台用户
	public static final String merFee = "merFee"; // 平台收取用户的手续费
	public static final String merFeeType = "merFeeType"; // 平台手续费收取方式：1、内扣，2、外扣
	public static final String taker = "taker"; // 提交的地址
	public static final String merFeeTypeOne = "1";// 1、内扣
	/******** query.commonQuery ***********/
	public static final String queryType = "queryType";
	/******** project.regProject ***********/
	public static final String projectNo = "projectNo"; // 项目 ID 号
	public static final String projectName = "projectName"; // 项目名称
	public static final String projectType = "projectType"; // 项目类型 1：P2P 2：众筹
	public static final String projectAmt = "projectAmt"; // 项目金额
	public static final String rateType = "rateType"; // 利率类型 1：固定 2：浮动
	public static final String cycVal = "cycVal"; // 周期值 周期为天 0 表示无限大
	public static final String finaAccType = "finaAccType"; // 融资方账户类型 1：个人 2：企业
	public static final String finaCertNo = "finaCertNo"; // 融资方证件号
	public static final String finaName = "finaName"; // 融资方姓名
	public static final String finaIpsAcctNo = "finaIpsAcctNo"; // 融资方 IPS 账号
	public static final String isExcess = "isExcess"; // 是否超额
	public static final String rateVal = "rateVal"; // 类型为固定时不可为空,百分数表示利率值
													// 0<=利率<=48%，利率值为 0 代表没有利率如
													// 25.25 表示 25.25%
	public static final String rateMinVal = "rateMinVal";
	public static final String rateMaxVal = "rateMaxVal";
	public static final String projectUse = "projectUse";
	/*****************project.AssureProject*************************/
	public static final String assureAmt= "assureAmt"; //担保金额  不能大于担保的项目金额
	public static final String assureIncome= "assureIncome"; //担保收益    最多为担保金额的 10%
	public static final String assureType= "assureType"; //担保方类型   1:个人 2:企业
	public static final String assureIpsAcctNo ="assureIpsAcctNo";  //担保方的 IPS	存管账户号

	/******************trade.transferw************************/
	public static final String batchNo = "batchNo";  //商户转账批次号
	public static final String transferType = "transferType"; //转账类型  1 放款、2 债券转让、3 还款、4 分红、5代偿、6 代偿还款、7 风险准备金、8 结算担保收益、9 红包
	public static final String isAutoRepayment = "isAutoRepayment"; //是否自动还款  当转账类型为还款和代偿还款时，该字段为必选。1 为是、2 为否，转账类型为其它类型的时默认为 3
	public static final String transferMode = "transferMode"; //转账方式  1 为逐笔转账、2 为批量转账
	public static final Map<String,String> transferAccDetail = new HashMap<String,String>(); //转账明细集合
	public static final String freezeId= "freezeId"; //IPS 原冻结订单号
	public static final String outIpsAcctNo= "outIpsAcctNo"; //转出方IPS存管账户号
	public static final String outMerFee= "outMerFee"; //转出方平台手续费
	public static final String inIpsAcctNo= "inIpsAcctNo"; //转入方IPS存管账户号
	public static final String inMerFee= "inMerFee";//转入方平台手续费
	public static final String StransferAccDetail = "transferAccDetail";  //封装明细集合


	/**********************trade.freeze****************************/
	public static final String regType = "regType"; //登记方式1:手动   2:自动
	public static final String contractNo = "contractNo"; //合同号   登记方式 2 时，业务类型为投标、债权转让、还款、代偿还款需要传自动签约的原商户订单号
	public static final String authNo = "regType"; //授权号 登记方式 2 时，业务类型为投标、债权转让、还款、代偿还款需要传
	public static final String otherIpsAcctNo = "otherIpsAcctNo"; //它方账号  债权转让时为受让方存管账号；代偿还款时为担保人的存管账号；风险准备金时为入金 方商户或用户账号；此三种情况必填
	public static final String freezeMerType ="freezeMerType"; //冻结方类型1：用户  2：商户

	/****************trade.unFreeze*****************************/



	/*****trade.combFreeze*****/
	public static final Map<String,String> redPacket = new HashMap<String,String>(); //红包冻结
	public static final String RedPacket ="redPacket"; //封装红包冻结
	public static final Map<String,String> bid = new HashMap<String,String>(); //其他冻结
	public static final String Bid ="bid"; //封装其他冻结

	/** 调用成功 **/
	public static final String RESP_SUCC = "000000";
	/** 正在处理 **/
	public static final String RESP_HANDLING = "999999";
	/** 交易结果码 */
	public static final String resultCode = "resultCode";
	public static final String resultMsg = "resultMsg";// 交易结果说明

	/** 表单提交 **/
	public static final int TYPE_FORM = 1;
	/** JSON提交 **/
	public static final int TYPE_JSON = 2;
	/** UTF-8编码 **/
	public static final String UTF8 = "UTF-8";

	/******* 定义所有cmdId ****************/
	public static final String userRegister = "user.register"; // 注册
	public static final String queryBankQuery = "query.bankQuery"; // 商户直连查询银行
	public static final String tradeDeposit = "trade.deposit"; // 充值接口
	public static final String tradeWithdraw = "trade.withdraw"; // 提现接口
	public static final String queryCommonQuery = "query.commonQuery"; // 查询接口
	public static final String tradeTransfer = "trade.transfer"; // 转账接口
	public static final String projectRegProject = "project.regProject"; // 项目登记接口
	public static final String projectAssureProject = "project.assureProject"; // 追加项目登记接口
	public static final String userLogin = "user.login";  //用户登录 用来绑卡使用
	public static final String tradeFreeze = "trade.freeze";  //冻结接口
	public static final String tradeUnFreeze ="trade.unFreeze"; //解冻接口
	public static final String tradeCombFreeze ="trade.combFreeze";//红包组合冻结接口
	/**
	 * 用于加密的原文串<br>
	 * key : cmdId<br>
	 * value : 参数Map中的key
	 */
	public static final Map<String, String[]> SignOrgMap = new HashMap<String, String[]>();
	/** 后台异步和同步返回配置 **/
	public static final Map<String, String> webUrlMap = new HashMap<String, String>();// 页面通知地址
	public static final Map<String, String> s2SUrlMap = new HashMap<String, String>();// 后台回调地址

	public static final String SEND = "S";
	public static final String SEND_SIGN = "S_SIGN";
	public static final String RECV = "R";

	static {
		SignOrgMap.put(SEND_SIGN + userRegister, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + userRegister, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + queryBankQuery, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + queryBankQuery, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeDeposit, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeDeposit, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeWithdraw, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeWithdraw, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + queryCommonQuery, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + queryCommonQuery, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeTransfer, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeTransfer, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + projectRegProject, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + projectRegProject, new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + projectAssureProject, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + projectAssureProject,
				new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeFreeze, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeFreeze,
				new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeUnFreeze, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeUnFreeze,
				new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeTransfer, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeTransfer,
				new String[] { merchantID, resultCode, resultMsg, response, Md5Key });

		SignOrgMap.put(SEND_SIGN + tradeCombFreeze, new String[] { operationType, merchantID, request, Md5Key });
		SignOrgMap.put(RECV + tradeCombFreeze,
				new String[] { merchantID, resultCode, resultMsg, response, Md5Key });
		// 后台异步返回配置，
		s2SUrlMap.put(userRegister, "userRegister");
		s2SUrlMap.put(tradeDeposit, "tradeDeposit");
		s2SUrlMap.put(tradeTransfer, "tradeTransfer");
		s2SUrlMap.put(tradeWithdraw, "tradeWithdraw");
		s2SUrlMap.put(projectRegProject, "projectRegProject");
		s2SUrlMap.put(tradeFreeze, "tradeFreeze");
		s2SUrlMap.put(tradeUnFreeze, "tradeUnFreeze");
		s2SUrlMap.put(tradeCombFreeze, "tradeCombFreeze");
		// 页面返回
		webUrlMap.put(userRegister, userRegister);
		webUrlMap.put(tradeDeposit, tradeDeposit);
		webUrlMap.put(tradeWithdraw, tradeWithdraw);
		webUrlMap.put(tradeFreeze, tradeFreeze);
		webUrlMap.put(tradeCombFreeze, tradeCombFreeze);
	}

}
