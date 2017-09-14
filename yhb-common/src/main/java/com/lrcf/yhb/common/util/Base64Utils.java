package com.lrcf.yhb.common.util;

import com.lrcf.yhb.common.config.BaseConstants;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 64位进制转换算法
 * @author KRX
 * 
 *
 */
public class Base64Utils {

	/**
	 * 
	 * 创建日期2016-8-24上午10:12:38 修改日期 作者： KRX 使用Base64加密算法加密字符串 return
	 */
	public static String encodeStr(String plainText) {
		try {
			return new String(Base64.encodeBase64(
					plainText.getBytes(BaseConstants.UTF8), true));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 
	 * 创建日期2016-8-24上午10:15:11 修改日期 作者： KRX 使用Base64加密 return
	 */
	public static String decodeStr(String encodeStr) {
		try {
			return new String(Base64.decodeBase64(encodeStr
					.getBytes(BaseConstants.UTF8)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
