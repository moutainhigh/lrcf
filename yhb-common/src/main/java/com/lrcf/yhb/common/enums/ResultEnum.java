/**
 *
 */
package com.lrcf.yhb.common.enums;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: ResultEnum.java
 * @Description: 系统错误常量字典
 * @author:Krx
 * @date: 2017年4月27日 下午3:20:07
 */
public enum ResultEnum {

	USERNAME_ISNULL(-1,"密码为空"),

	PASSWORD_ISERROR(-2,"密码错误"),

	USER_ISNULL(-3,"没有该账号"),

	LOGIN_FORMISFLAG(-4,"登录账号或密码格式错误"),

	PASSWORD_ISNULL(-5,"密码为空"),

	CAPTCHA_ISERROR(-6,"验证码错误"),

	PHONECODE_ISNULL(-7,"手机验证码为空"),

	PICCODE_ISNULL(-8,"图文验证码为空"),

	PHONECODE_ISERROR(-9,"手机验证码错误"),

	PICCODE_ISERROR(-10,"图文验证码错误"),
	// 手机号码已存在
	PHONECODE_ISEXIT(-11,"手机号码已存在"),

	TOKEN_ISNULL(-12,"token为空"),
	// 黑名单用户
	BLACK_USER(-13,"黑名单用户"),

	IMAGE_ISBIG(-14,"上传图片过大"),

	TRADMT_ISNULL(-15,"充值金额为空"),

	TRADMT_FORMIISERROR(-16,"充值金额格式错误,小数点精确到两位"),

	BANKCODE_ISNULL(-17,"所属银行编码为空"),

	EMAIL_FORMISNRROR(-18,"邮箱格式错误"),

	CARD_FORMISNRROR(-19,"身份证格式错误"),

	IMAGE_ISNULL(-20,"图片文件为空"),

	IMAGE_TYPE_ERROR(-21,"图片格式错误"),

	BANNER_QUERY_ERROR(-22,"图片不存在"),

	AGENT_QUERY_ERROR(-23,"获取代理商信息出错"),

	NEWS_QUERY_ERROR(-24,"获取新闻信息出错"),

	NEWS_TRANSFER_ERROR(-25,"新闻信息转换JSON错误"),

	INVEST_QUERY_ERROR(-26,"投资记录查询错误"),

	TRUENAME_ISNULL(-27,"真实姓名为空"),

	IDCARD_ISNULL(-28,"身份证号码为空"),

	PROID_ISNULL(-29,"银行所在省份信息错误"),

	CITYID_ISNULL(-30,"银行所在市区信息错误"),

	BRANCH_ISNULL(-31,"银行所在分行信息为空"),

	SUBBRANCH_ISNULL(-32,"银行所在支行信息为空"),

	CARDID_ISNULL(-33,"银行卡号为空"),

	CARDID_ISEXISTENCE(-34,"身份证已经被注册"),

	STARTTIME_ISNULL(-34,"开始时间为空"),

	ENDTIME_ISNULL(-35,"结束时间为空"),

	CURRENT_ISNULL(-36,"当前页数为空"),

	TIE_CARD_ERROR_MANY(-37,"失败多次，请联系客服进行绑卡!"),

	FOUR_FACTORS_ISNULL(-38,"四要素信息不能为空"),

	TYPE_ISNULL(-39,"活期宝交易类型为空"),

	CURRENT_MONEY_ISNULL(-40,"活期宝交易金额为空"),

	PAYPWD_ISNULL(-41,"交易密码为空"),

	MONEY_FORM_ISERROR(-42,"交易金额不合法,金额不得小于0.01"),

	TYPE_FORM_ISERRPR(-43,"活期宝交易类型不合法"),

	BANKCARD_CHECK_CALLAPI_FAIL(-44,"调用京东万象四要素接口失败"),

	PAY_TIME_ISERROR(-45,"处于系统维护状态，该时间段无法交易"),

	PAYPWD_ISERROR(-46,"交易密码错误"),

	BANKCARD_INFO_SAVE_ERROR(-47,"保存银行卡信息出错"),

	ADD_BANK_TYPE(-48,"绑卡的类型错误"),

	ERROR(-500, "系统错误"),

	DICTIONARY_ERROR(-501,"字典错误,传入的参数中有不合法参数"),

	DATAS_ISNULL(-502,"参数集合为空"),

	ERRORCALCMSG(-503, "图形验证码不正确"),

	ERRORISBLANK(-504, "手机号、验证码、密码都不能为空"),

	ERRORMASSAGEMSG(-505, "短信验证码不正确"),

	ERRORNOINVITECODE(-506, "用户邀请码不存在"),

	ERRORNOINVITER(-507, "您的上级用户账户可能存在异常，请您联系客服"),

	ERRORREGIST(-509, "注册出错"),

	ERRORREGISTPHOME(-510, "该手机号已经注册过"),

	ERRORRMSGVALIDATETWO(-511, "姓名和身份证号码不匹配"),

	ERRORRREGISTERUSER(-512, "该手机号已注册"),


	SUCCESS(200,"成功"),

	USER_OPENHX_SUCCESS(201,"开户成功"),

	USER_TRADEMONEY(202,"充值成功"),
	/*
	 * 大汉三通的信息字典——短信发送:wangxf
	 */
	// 大汉三通-发送短信：用户被禁发或禁用(格式，范围等不符合要求)
	PARAM_ERROR(19,"用户被禁发或禁用(格式，范围等不符合要求)"),
	// 大汉三通-发送短信：成功
	SMS_SEND_SUCCESS(0,"短信发送成功"),
	// 大汉三通-发送短信：系统正忙
	SYSTEM_BUSY(98,"系统正忙"),
	// 大汉三通-发送短信：手机号码无效
	PHONE_INVALID(1,"手机号码无效"),
	// 大汉三通-发送短信：手机号码为空
	PHONE_ISNULL(14,"手机号码为空"),
	// 大汉三通-短信发送：ip鉴权失败
	IP_AUTHENT_FAILURE(20,"ip鉴权失败"),

	// 短信发送的状态错误
	SMS_STATE_ERROR(-100,"发送短信类型值错误！"),
	// 短信信息为空
	SMS_CONTEXT_ISNULL(-101,"短信信息为空！"),

	SMS_ERROR(-102,"短信信息发送失败"),


	SYSTEM_PARAMISNULL(1001,"参数为空"),
	SYSTEM_ORIGINISNULL(1002,"来源不明"),
	SYSTEM_TOKENTIMEOUT(1003,"token失效,请重新登录"),
	SYSTEM_EXCEPTION(1004,"系统异常"),
	SYSTEM_SIGN_FAIL(1005,"验证签名失败")
	;


	/**
	 * code值
	 */
	private final int code;

	/**
	 * code对应的描述
	 */
	private final String codeDesc;

	ResultEnum(int code, String codeDesc) {
		this.code = code;
		this.codeDesc = codeDesc;
	}

	/**
	 * 获取code值
	 *
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 获取code值对应的描述
	 *
	 * @return
	 */
	public String getCodeDesc() {
		return codeDesc;
	}

	/**
	 *
	 * @Function: ExceptionEnum.java
	 * @Description: 通过枚举code值获取相应的枚举类型对象
	 *
	 * @param: int code
	 * @return： ResultEnum
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 下午2:15:27
	 *
	 * Modification History:
	 * Date        Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月2日     wangxf           v1.0.0               修改原因
	 */
	public static ResultEnum getResultEnumByCode(int code){

		// 通过values()方法，将枚举里所有类型列出来
		for( ResultEnum resultCode : ResultEnum.values() ){
			if( resultCode.getCode() == code){
				return resultCode;
			}
		}

		return null;
	}

}
