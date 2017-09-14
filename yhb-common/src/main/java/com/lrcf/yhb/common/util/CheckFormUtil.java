/**
 * 
 */
package com.lrcf.yhb.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: CheckPhone.java
 * @Description: 格式校验工具类
 * 
 * 
 *               移动号段： 139 138 137 136 135 134 147 150 151 152 157 158 159 178
 *               182 183 184 187 188
 * 
 *               联通号段： 130 131 132 155 156 185 186 145 176
 * 
 *               电信号段： 133 153 177 173 180 181 189
 * 
 *               虚拟运营商号段： 170 171
 * @author:Krx
 * @date: 2017年5月4日 下午4:30:20
 */
public class CheckFormUtil {

	/**
	 * 正则表达式校验手机号码（通用）
	 * 
	 * @param telNum  待匹配的手机号码
	 * @return 匹配成功返回true 否则返回false;
	 */
	public static boolean isMobiPhoneNum(String telNum) {
		String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(telNum);
		return m.matches();
	}

	/**
	 * 正则表达式校验手机号码（严格）
	 * 
	 * @param telNum 待匹配的手机号码
	 * @return 匹配成功返回true 否则返回false;
	 */
	public static boolean isMobileNum(String telNum) {
		Pattern p = Pattern.compile("^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$");
		Matcher m = p.matcher(telNum);
		return m.matches();
	}

	/**
	 * 正则表达式校验密码
	 * 
	 * @param password 待匹配的密码
	 * @return 匹配成功返回true 否则返回false;
	 */
	public static boolean isPassword(String password) {
		Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$");
		Matcher m = p.matcher(password);
		return m.matches();
	}

	/**
	 * 正则表达式校验邮箱
	 * 
	 * @param_email 待匹配的邮箱
	 * @return 匹配成功返回true 否则返回false;(^\\d{18}$)|(^\\d{15}$)
	 */
	public static boolean isEmail(String email) {
		Pattern p = Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * 正则表达式校验身份证
	 * 
	 * @param cardId 待匹配的身份证
	 * @return 匹配成功返回true 否则返回false;  ^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$
	 */
	public static boolean isCardId(String cardId) {
		Pattern p = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
		Matcher m = p.matcher(cardId);
		return m.matches();
	}
	
	/**
	 * 正则表达式校验金额  判断小数点后两位的数字为true
	 * 
	 * @param_cardId 待匹配的身份证
	 * @return 匹配成功返回true 否则返回false;  
	 */
	public static boolean isMoney(String money) {
		Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
		Matcher m = p.matcher(money);
		return m.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isMoney("0.01"));
	}

}
