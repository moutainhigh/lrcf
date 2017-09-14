package com.lrcf.yhb.common.enums;

/**
 * 
 * @ClassName: SendSmsStateEnum.java
 * @Description: 发送短信的类型统一配置枚举
 *
 * @version: v1.0.0
 * @author: wangxf
 * @date: 2017年5月5日 下午2:36:37
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2017年5月5日
 *        wangxf v1.0.0 修改原因
 */
public enum SendSmsStateEnum {
	/*
	 * 发送短信类型，用于区分发送哪种短信信息
	 */
	// 注册：发送短信验证码
	SMS_STATE_REGISTER(0, SmsContextEnum.SMS_REGISTER),
	// 找回密码：发送找回密码
	SMS_STATE_FORGET(1, SmsContextEnum.SMS_FORGET),
	// 注册：发送红包验证码
	SMS_STATE_RED(2, SmsContextEnum.SMS_RED),
	// 注册：发送加息劵验证码
	SMS_STATE_RAISE(3, SmsContextEnum.SMS_RAISE),
	// 注册：发送体验金验证码
	SMS_STATE_EXPERIENCE(4, SmsContextEnum.SMS_EXPERIENCE),
	// 绑定银行卡短信
	SMS_STATE_TIE_BANKCARD(5, SmsContextEnum.SMS_TIE_BANKCARD),
	// 更换银行卡
	SMS_UPDATE_BANKCARD(6, SmsContextEnum.SMS_UPDATE_BANKCARD)
	;

	/*
	 * code值
	 */
	private final Integer code;
	/*
	 * code对应的描述
	 */
	private final SmsContextEnum codeDesc;

	SendSmsStateEnum(Integer code, SmsContextEnum codeDesc) {
		this.code = code;
		this.codeDesc = codeDesc;
	}

	public Integer getCode() {
		return code;
	}

	public SmsContextEnum getCodeDesc() {
		return codeDesc;
	}

	/**
	 * 
	 * @Function: SendSmsStateEnum.java
	 * @Description: 根据要发送的短信状态，来获取发送短信的枚举对象
	 *
	 * @param: Integer
	 *             code @return： SendSmsStateEnum @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月5日 下午2:47:46
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月5日 wangxf v1.0.0 修改原因
	 */
	public static SendSmsStateEnum getCodeDescByCode(Integer code) {
		for (SendSmsStateEnum resultEnum : SendSmsStateEnum.values()) {
			if (resultEnum.getCode() == code) {
				return resultEnum;
			}
		}
		return null;
	}

	// --------------------------内部枚举类--------------------------------
	/**
	 * 
	 * @ClassName: SendSmsStateEnum.java
	 * @Description: 配置每种短信的“前缀” + “后缀”的统一枚举
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月5日 下午2:34:09
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月5日 wangxf v1.0.0 修改原因
	 * @ClassName: SendSmsStateEnum.java
	 * @Description: 配置每种短信的“前缀” + “后缀”的统一枚举
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月5日 下午2:34:09
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月5日 wangxf v1.0.0 修改原因
	 */
	public enum SmsContextEnum {

		// 注册：发送注册短信验证码
		SMS_REGISTER("【岚儒财富】尊敬的用户：您的注册验证码为:", ",欢迎您注册为余惠宝的商户。"),
		// 找回密码：发送找回密码验证码
		SMS_FORGET("【岚儒财富】尊敬的用户：您找回密码的验证码为:", ",请及时认证,为确保您的账户安全,请勿将此验证码告知别人,感谢您使用余惠宝。"),
		// 注册：红包
		SMS_RED("【岚儒财富】尊敬的用户：感谢您注册本平台,恭喜您获得", "元红包,感谢您使用余惠宝。"),
		// 注册：加息劵
		SMS_RAISE("【岚儒财富】尊敬的用户：感谢您注册本平台,恭喜您获得", "加息劵,感谢您使用余惠宝。"),
		// 注册：体验金
		SMS_EXPERIENCE("【岚儒财富】尊敬的用户：感谢您注册本平台,恭喜您获得", "元体验金,感谢您使用余惠宝。"),
		// 绑定银行卡短信
		SMS_TIE_BANKCARD("【岚儒财富】尊敬的用户：您绑定银行卡的验证码为", "，感谢您使用余惠宝。"),
		// 更换银行卡
		SMS_UPDATE_BANKCARD("【岚儒财富】尊敬的用户：您更换银行卡的验证码为","，感谢您使用余惠宝。")

		;

		/*
		 * 短信信息前缀
		 */
		private final String smsPrefix;
		/*
		 * 短信信息后拽
		 */
		private final String smsSuffix;

		SmsContextEnum(String smsPrefix, String smsSuffix) {
			this.smsPrefix = smsPrefix;
			this.smsSuffix = smsSuffix;
		}

		public String getSmsPrefix() {
			return smsPrefix;
		}

		public String getSmsSuffix() {
			return smsSuffix;
		}
	}

}
