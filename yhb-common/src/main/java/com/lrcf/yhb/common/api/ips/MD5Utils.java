package com.lrcf.yhb.common.api.ips;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MD5Utils {
	private final static Log log = LogFactory.getLog(MD5Utils.class);

	static MessageDigest md = null;

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ne) {
			log.error("NoSuchAlgorithmException: md5", ne);
		}
	}
	
	public static void main(String[] args) {
		MD5Utils mds = new MD5Utils();
		String ss=mds.stringToMD5("ff81144");
		System.out.println(ss);
	}

	/**
	 * 对一个文件求他的md5值
	 * 
	 * @param f
	 *            要求md5值的文件
	 * @return md5串
	 */
	public static String md5(File f) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			byte[] buffer = new byte[8192];
			int length;
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}

			return new String(Hex.encodeHex(md.digest()));
		} catch (FileNotFoundException e) {
			log.error("md5 file " + f.getAbsolutePath() + " failed:"
					+ e.getMessage());
			return null;
		} catch (IOException e) {
			log.error("md5 file " + f.getAbsolutePath() + " failed:"
					+ e.getMessage());
			return null;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 求一个字符串的md5值
	 * 
	 * @param target
	 *            字符串
	 * @return md5 value
	 */
	public static String md5(String target) {
		return DigestUtils.md5Hex(target);
	}

	/***
	 * 根据字符串生成 32位的 MD5 码
	 * @author tmc.sun 2012-11-05
	 * @param str 待生成 MD5码的字符串
	 * @return 根据字符串生成的 MD5码
	 */
	public static String stringToMD5(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}

		MessageDigest md5 = null;
		StringBuffer value = new StringBuffer();

		try {
			md5 = MessageDigest.getInstance("MD5");

			byte[] md5Bytes = md5.digest(str.getBytes(IpsConstants.UTF8));

			for (int i = 0; i < md5Bytes.length; i++) {
				int val = (md5Bytes[i]) & 0xff;
				if (val < 16) {
					value.append("0");
				}
				value.append(Integer.toHexString(val));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		return value.toString();

	}
	
	
	
	  /**
     * sign 环迅加密
     *
     * @param text
     * @return
     */
    public static String sign(String text) {
        return DigestUtils.md5Hex(text);
    }

    /**
     * sign 环迅加密
     *
     * @param text
     * @param charset
     * @return
     */
    public static String sign(String text, String charset) {
        return DigestUtils.md5Hex(StringUtil.getBytes(text, charset));
    }


    /**
     * verify 验签 环迅
     *
     * @param text
     * @param sign
     * @return
     */
    public static boolean verify(String text, String sign) {
        String mySign = DigestUtils.md5Hex(text);
        if (mySign.equals(sign)) {
            return true;
        }
        return false;
    }

    /**
     * verify 验签 环迅
     *
     * @param text 获取到的sign密文
     * @param sign 请求sign
     * @param charset
     * @return
     */
    public static boolean verify(String text, String sign, String charset) {
        String mySign;
		try {
			mySign = DigestUtils.md5Hex(text.getBytes(charset));
			if (mySign.equals(sign)) {
	            return true;
	        }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return false;
    }
	

}
