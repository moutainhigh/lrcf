package com.lrcf.yhb.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUtil {

	/**
	 * 验证绑卡信息
	 * 
	 * @param map
	 * @return
	 */
	public static String validateBindCard(Map<String, String> map) {
		String msg = "";
		if (StringUtils.isBlank(map.get("province"))) {
			return msg = "请输入省份信息";
		}
		if (StringUtils.isBlank(map.get("city"))) {
			return msg = "请输入城市信息";
		}
		if (StringUtils.isBlank(map.get("bankAddress"))) {
			return msg = "请输入开户分行信息";
		}
		if (StringUtils.isBlank(map.get("bankAddress2"))) {
			return msg = "请输入开户支行信息";
		}
		if (StringUtils.isBlank(map.get("bankName"))) {
			return msg = "请输入银行名称";
		}
		return msg;
	}

	public String loginValidate(String userPhone, String phoneCode, String userPassword) {
		String msg = "ok";
		if (StringUtils.isBlank(userPhone)) {
			msg = "用户手机号为空";
		}
		if (StringUtils.isBlank(phoneCode)) {
			msg = "手机验证码为空";
		}
		if (StringUtils.isBlank(userPassword)) {
			msg = "用户密码为空";
		}
		return msg;
	}

	/**
	 * 验证邮箱格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		email = isNull(email);
		Pattern regex = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher matcher = regex.matcher(email);
		boolean isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * 检查phone是否是合法的，返回true表示是，反之为否
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isPhone(String phone) {
		phone = isNull(phone);
		Pattern regex = Pattern.compile("1[3|4|5|7|8|][0-9]{9}");
		Matcher matcher = regex.matcher(phone);
		return matcher.matches();
	}

	/**
	 * 如果str为null，返回“”,否则返回str
	 * 
	 * @param str
	 * @return
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}
	

}
