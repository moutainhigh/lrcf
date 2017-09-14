package com.lrcf.yhb.common.util;

import com.lrcf.yhb.common.config.BaseConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * des加密解密
 * 
 * @author 孔荣勋
 * 
 */
public class DesEncrypt {

	Logger log = LoggerFactory.getLogger(this.getClass());
	Key key;

	private static final Map<String, String> replaceStr = new HashMap<String, String>();

	static {
		replaceStr.put("\\+", "\\[j]");
		replaceStr.put("/", "\\[x]");
		replaceStr.put("=", "\\[d]");
	}

	public DesEncrypt() {
		setKey(BaseConstants.DES_PRIVATE_ENCRYPT_KEY);
	}

	public DesEncrypt(String str) {
		setKey(str);// 生成密匙
	}

	/**
	 * 替换密文中的特殊字符
	 * 
	 * @param str
	 * @return
	 */
	public String replaceKeyByValue(String str) {
		Iterator<Entry<String, String>> entrys = replaceStr.entrySet().iterator();
		while (entrys.hasNext()) {
			Entry<String, String> entry = entrys.next();
			str = str.replaceAll(entry.getKey(), entry.getValue());
		}
		return str;
	}

	/**
	 * 还原密文中的特殊字符
	 * 
	 * @param str
	 * @return
	 */
	public String replaceValueByKey(String str) {
		Iterator<Entry<String, String>> entrys = replaceStr.entrySet().iterator();
		while (entrys.hasNext()) {
			Entry<String, String> entry = entrys.next();
			str = str.replaceAll(entry.getValue(), entry.getKey());
		}
		return str;
	}

	/**
	 * 根据参数生成KEY
	 */
	public void setKey(String strKey) {
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			this.key = keyFactory.generateSecret(new DESKeySpec(strKey.getBytes("UTF8")));
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		}
	}

	/**
	 * 加密list中的某个值，加密后的值key=e+原来的key
	 * 
	 * @param list
	 * @param keys
	 */
	@SuppressWarnings("unchecked")
	public void encryptInList(List<Map> list, Object[] keys) {
		for (Map m : list) {
			for (Object key : keys) {
				if (m.containsKey(key)) {
					Object val = m.get(key);
					String param = "";
					if (val instanceof String) {
						param = (String) val;
					} else if (val instanceof Integer) {
						param = String.valueOf((Integer) val);
					} else if (val instanceof Long) {
						param = String.valueOf((Long) val);
					}
					String encKey = "e" + key;
					m.put(encKey, encrypt(param));
					// System.out.println("加密前：" + key + "=[" + param + "],加密后："
					// + encKey + "=[" + m.get(encKey) + "]");
				}
			}
		}
	}

	/**
	 * 加密String明文输入,String密文输出
	 */
	public String encrypt(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes(BaseConstants.UTF8);
			byteMi = this.getEncCode(byteMing);
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("encrypt error:" + strMing, e);
			return null;
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return replaceKeyByValue(strMi);
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String decrypt(String strMi) {
		strMi = replaceValueByKey(strMi);
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);
			byteMing = this.getDesCode(byteMi);
			strMing = new String(byteMing, BaseConstants.UTF8);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("decrypt error:" + strMi, e);
			return null;
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, SecureRandom.getInstance("SHA1PRNG"));
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, SecureRandom.getInstance("SHA1PRNG"));
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 
	 * @Description: 检验输入密码和数据库密码是否正确
	 *
	 * @param:dbPassword 数据库密码
	 *                       paramPassword 参数密码
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月5日 上午9:08:26
	 */
	public static boolean checkPassword(String dbPassword, String paramPassword) {
		DesEncrypt desEncrpt = new DesEncrypt(BaseConstants.DES_PUBLIC_ENCRYPT_KEY);
		DesEncrypt aesEncrypt = new DesEncrypt(BaseConstants.DES_PRIVATE_ENCRYPT_KEY);

		boolean flag = false;

		if (StringUtil.isNull(dbPassword) || StringUtil.isNull(paramPassword)) {
			return flag;
		}

		flag = StringUtils.trimToEmpty(dbPassword).toLowerCase()
				.equals(MD5Utils.stringToMD5(aesEncrypt.encrypt(desEncrpt
						.decrypt(StringUtils.trimToEmpty(desEncrpt.encrypt(StringUtils.trimToEmpty(paramPassword)))))));

		return flag;
	}

	/**
	 * 
	 * @Description: 获得加密后的密码
	 *
	 * @param:paramPassword
	 * @return：String
	 * @author: Krx
	 * @date: 2017年5月8日 上午10:18:02
	 */
	public static String getMd5Password(String paramPassword) {
		DesEncrypt desEncrpt = new DesEncrypt(BaseConstants.DES_PUBLIC_ENCRYPT_KEY);
		DesEncrypt aesEncrypt = new DesEncrypt(BaseConstants.DES_PRIVATE_ENCRYPT_KEY);

		if (StringUtil.isNull(paramPassword)) {
			return null;
		}
		String md5Password = null;

		md5Password = MD5Utils.stringToMD5(aesEncrypt.encrypt(
				desEncrpt.decrypt(StringUtils.trimToEmpty(desEncrpt.encrypt(StringUtils.trimToEmpty(paramPassword))))));

		return md5Password;
	}

	public static void main(String args[]) {
		DesEncrypt des = new DesEncrypt(BaseConstants.DES_PUBLIC_ENCRYPT_KEY);

		String str1 = "123456";
		// DES加密
		String str2 = des.encrypt(str1);
		System.out.println(str2);
		DesEncrypt des1 = new DesEncrypt(BaseConstants.DES_PUBLIC_ENCRYPT_KEY);
		String deStr = des1.decrypt(str2);
		System.out.println("密文:" + str2);
		// DES解密
		System.out.println("明文:" + deStr);
		DesEncrypt des2 = new DesEncrypt(BaseConstants.DES_PRIVATE_ENCRYPT_KEY);

		String b = des2.encrypt(str1);
		System.out.println(b);
		String replaced = new DesEncrypt().replaceKeyByValue(b);
		System.out.println(replaced);
		System.out.println(new DesEncrypt().replaceKeyByValue("Z8/eB+qfBLQ="));
		System.out.println(new DesEncrypt().replaceValueByKey(new DesEncrypt().replaceKeyByValue("Z8/eB+qfBLQ=")));
		System.out.println(MD5Utils.stringToMD5(des2.encrypt(str1)));

	}

}
