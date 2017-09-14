package com.lrcf.yhb.common.config;


import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: BaseConstants.java
 * @Description: 全局常量
 * @author:Krx
 * @date: 2017年4月27日 下午1:52:27
 */
public class BaseConstants {

	/**
	 * 常量
	 *
	 * @author KRx
	 */
	public interface Token {
		public final static String TOKEN_NAME = "token";
	}
	public static final String HTML_Quotes_Double = "&quot;";// 双引号
	public static final String HTML_Quotes_Single = "&apos;";// 单引号

	public static final String ParentIDCom = "00000000-0000-0000-0000-000000000000"; // parentId
	/**
	 * Session定义 按端口定义session
	 */
	public static final String APP_SESSION = "APP_SESSION";  //App端口session定义
	public static final String PC_SESSION = "PC_SESSION";//PC前端,H5端口session定义
	public static final String ADMIN_SESSION = "ADMIN_SESSION";//pc后端端口session定义
	public static final String WECHAT_SESSION = "WECHAT_SESSION";//微信端口session定义
	public static final String AGENT_SESSION = "AGENT_SESSION";//代理商端口session定义



	/**
	 * 图形验证码redis-key 保存时间
	 */
	public static final int RANDOM_EXPIRE_TIME = 2 * 60;
	/**
	 * 图形验证码redis-key
	 */
	public static final String RANDOM_CODE_KEY = "SESSION_PICTURE_CODE";

	/**
	 * 子商户注册限制多少分钟内注册一次
	 */
	public static final String REGISTERMINUTELIMIT = ":registerLimit:minute";
	/**
	 * 子商户注册每天限制添加多少子商户人数
	 */
	public static final String REGISTERDAYLIMIT = ":registerLimit:day";



	/**
	 * PC来源
	 */
	public static final String PC = "web";
	/**
	 * H5来源
	 */
	public static final String H5 = "hw";
	/**
	 * APP来源
	 */
	public static final String APP = "app";
	/**
	 * WEIXIN
	 */
	public static final String WEIXIN = "wechat";
	/**
	 * 代理商
	 */
	public static final String AGENT_ADDUSER = "代理商添加下属子商户";
	/**
	 * 代理商
	 */
	public static final String DISTRIBUTOR_ADDUSER = "经销商添加下属子商户";
	/**
	 * OTHER
	 */
	public static final String OTHER = "其他";

	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	/**
	 * 提示信息
	 */
	public static final String MESSAGE = "message";
	/**
	 * 系统提示
	 */
	public static final String rollOutMsg = "转出信息";
	public static final String depositMsg = "充值信息";
	public static final String tradeWithdrawMsg = "提现信息";
	public static final String DisMsg = "经销商信息";
	public static final String RedMsg = "红包信息";
	public static final String RaiseMsg = "加息劵信息";
	public static final String ExMsg = "体验金信息";
	public static final String SharingMsg = "分享金信息";
	/**
	 * cookie中的JSESSIONID名称
	 */
	public static final String JSESSION_COOKIE = "JSESSIONID";
	/**
	 * url中的jsessionid名称
	 */
	public static final String JSESSION_URL = "jsessionid";
	/**
	 * 附件路径
	 */
	public static final String FILEPATH = "files";
	/**
	 * HTTP POST请求
	 */
	public static final String POST = "POST";
	/**
	 * HTTP GET请求
	 */
	public static final String GET = "GET";

	public static final String DES_PUBLIC_ENCRYPT_KEY = "6Ta4OaHZdpA="; // DES加密key
	// IV
	public static final String DES_PRIVATE_ENCRYPT_KEY = "o0al4OaEWBzA1";
	/** app加密key值 **/
	public static final String DES_PUBLIC_KEY_IOS_ANDROID = "0123456789lbsoft";
	/**
	 * 	 京东万象四要素验证平台appkey
	 */
	public static final String appKey = "f4fd67238099b2b193c254a2ac3dee56"; // String
	/**
	 * 	 京东万象二要素验证平台appkey
	 */
	public static final String appKey2 = "f4fd67238099b2b193c254a2ac3dee56"; // String
	/**
	 * 京东万象平台系统返回码（1000 查询成功）
	 */
	public static final String SYSCODE = "10000";

	/**
	 * 京东万象平台返回码（000 一致）
	 */
	public static final String RES_SUCCESS_CODE = "000";
	/**
	 * 绑卡类型
	 */
	public static final String TIE_BANKCARD_ADD = "0";		// 添加银行卡
	public static final String TIE_BANKCARD_UPDATE = "1";	// 修改银行卡

	/**
	 * 图片路径
	 */
	@Value("${imgUrl}")
	public static  String imgUrl;
	@Value("${myimgUrl}")
	public static  String myimgUrl;
	@Value("${HTTPADDRESS}")
	public static  String HTTPADDRESS;
	@Value("${myimgComputerUrl}")
	public static  String myimgComputerUrl;
	@Value("${IMAGE_FILE_PATH}")
	public static  String IMAGE_FILE_PATH ;

	// 验证前台参数是否存在于系统字典中 保证前后一致
	public static Map<String, String> VALIDATEKEY_MAP = new HashMap<String, String>();

	// 对应系统字典
	public static Map<String, Integer> VALIDATEVALUEISNULLBYKEY = new HashMap<String, Integer>();

	static {
		VALIDATEKEY_MAP.put("account", "account"); // 账号
		VALIDATEKEY_MAP.put("password", "password"); // 密码
		VALIDATEKEY_MAP.put("phoneCode", "phoneCode"); // 手机验证码
		VALIDATEKEY_MAP.put("picCode", "picCode"); // 图文验证码
		VALIDATEKEY_MAP.put("state", "state"); // 发送短信的类型
		VALIDATEKEY_MAP.put("smsContext", "smsContext"); // 发送的短信信息
		VALIDATEKEY_MAP.put("token", "token"); // token信息
		VALIDATEKEY_MAP.put("trdAmt", "trdAmt"); // 充值金额为空
		VALIDATEKEY_MAP.put("bankCode", "bankCode"); // bankCode银行代码为空
		VALIDATEKEY_MAP.put("img", "img"); // 上传图片
		VALIDATEKEY_MAP.put("startTime", "startTime"); // 开始时间
		VALIDATEKEY_MAP.put("emdTime", "emdTime"); // 结束时间
		VALIDATEKEY_MAP.put("current", "current"); //当前页数

		VALIDATEKEY_MAP.put("trueName", "trueName");	// 真实姓名
		VALIDATEKEY_MAP.put("idCard","idCard");			// 身份证号码
		VALIDATEKEY_MAP.put("bankId","bankId");			// 对应银行id
		VALIDATEKEY_MAP.put("proId","proId");			// 省份id
		VALIDATEKEY_MAP.put("cityId","cityId");			// 市id
		VALIDATEKEY_MAP.put("branch","branch");			// 分行名
		VALIDATEKEY_MAP.put("subbranch","subbranch");	// 支行名
		VALIDATEKEY_MAP.put("cardId","cardId");			// 银行卡号
		VALIDATEKEY_MAP.put("telPhone","telPhone");		// 银行预留手机号码
		VALIDATEKEY_MAP.put("type","type");				// 银行预留手机号码


		VALIDATEVALUEISNULLBYKEY.put("acccount", -1); // 手机号码
		VALIDATEVALUEISNULLBYKEY.put("password", -5); // 密码
		VALIDATEVALUEISNULLBYKEY.put("phoneCode", -7); // 手机验证码
		VALIDATEVALUEISNULLBYKEY.put("picCode", -8); // 图文验证码
		VALIDATEVALUEISNULLBYKEY.put("state", -100); // 发送短信的类型
		VALIDATEVALUEISNULLBYKEY.put("smsContext", -101); // 发送的短信信息
		VALIDATEVALUEISNULLBYKEY.put("token", -11); // token信息验证
		VALIDATEVALUEISNULLBYKEY.put("trdAmt", -15); // 充值金额为空验证
		VALIDATEVALUEISNULLBYKEY.put("bankCode", -17); // bankCode银行代码为空验证
		VALIDATEVALUEISNULLBYKEY.put("img", -20); // 上传图片
		VALIDATEVALUEISNULLBYKEY.put("startTime", -34); // 上传图片
		VALIDATEVALUEISNULLBYKEY.put("emdTime", -35); // 上传图片
		VALIDATEVALUEISNULLBYKEY.put("current", -36); // 上传图片


		VALIDATEVALUEISNULLBYKEY.put("trueName", -27);	// 真实姓名
		VALIDATEVALUEISNULLBYKEY.put("idCard",-28);			// 身份证号码
		VALIDATEVALUEISNULLBYKEY.put("bankId",-17);			// 对应银行id
		VALIDATEVALUEISNULLBYKEY.put("proId",-29);			// 省份id
		VALIDATEVALUEISNULLBYKEY.put("cityId",-30);			// 市id
		VALIDATEVALUEISNULLBYKEY.put("branch",-31);			// 分行名
		VALIDATEVALUEISNULLBYKEY.put("subbranch",-32);	// 分行名
		VALIDATEVALUEISNULLBYKEY.put("cardId",-33);			// 银行卡号
		VALIDATEVALUEISNULLBYKEY.put("telPhone",14);		// 银行预留手机号码
		VALIDATEVALUEISNULLBYKEY.put("type",-48);			// 绑卡类型 0：新增 1：修改
	}

}
