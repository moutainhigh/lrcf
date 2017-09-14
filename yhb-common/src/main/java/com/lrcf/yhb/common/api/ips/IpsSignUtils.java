package com.lrcf.yhb.common.api.ips;

import java.io.Serializable;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 环迅数据加密
 * @author KRX
 *
 */
public class IpsSignUtils  implements Serializable{
	static Logger log = LoggerFactory.getLogger(IpsSignUtils.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 8430930425387011877L;
	//写死
	private static final String key = "r0uScmDuH5FLO37AJV2FN72J";
	private static final String md5Key = "Ys6z7H93z9h3kQll7tv02SUsjWDcVsatanaPuE4NMbfGLLDOoaAhN7hN9eUxzx45wGT3Ch8De1XwPvRNF0n7GqrnbWRmnlVbxZEs7n6og5229XUveYq9sENyEP5CEsLr";

    /** MD5签名类型 **/
	public static final String SIGN_TYPE_MD5 = "M";

	/** 商户客户号 **/
	public static String RECV_MER_ID = null;

	/** 商户公钥文件地址 **/
	public static String MER_PUB_KEY_PATH = null;

	/** 商户私钥文件地址 **/
	public static String MER_PRI_KEY_PATH = null;

	@SuppressWarnings("rawtypes")
	public static String buildSignStr(Map params, String type) {
		//拼接signKey
		String operType=params.get(IpsConstants.operationType).toString();
		String[] signKeys = IpsConstants.SignOrgMap.get(type
				+ operType);
		if (signKeys == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (String key : signKeys) {
			try {
				sb.append(StringUtils.trimToEmpty(StringUtil.toString(params
						.get(key))));
			} catch (Exception e) {
				log.error("buildSignStr error:key=" + key, e);
			}
		}
		return sb.toString();
	}
    /**
     * 回来的时候验签
     * @param params
     * @param params
     * @return
     */
	public static String buildSignBack(Map params){
		StringBuffer sb = new StringBuffer();
		String merchantID = params.get("merchantID").toString();
		String resultCode = params.get("resultCode").toString();
		String resultMsg = params.get("resultMsg").toString();
		String response = params.get("response").toString();
		String md5Key = params.get(IpsConstants.Md5Key).toString();
		sb.append(StringUtils.trimToEmpty(merchantID+resultCode+resultMsg+response+md5Key));
		return sb.toString();
	}
	/**
	 * 3DES方式加签
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String encryptByRSA(Map<String, String> params) {
		String signStr = buildSignStr(params, IpsConstants.SEND);
		System.out.println("============报文明文Str=============="+signStr);
		String signString=null;
		if (signStr == null) { // 不需要加密
			return null;
		}
		try {
			signString =EncryptUtils.Encrypt3DES(signStr, key);
			System.out.println("============报文密文Str=============="+signString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signString;
	}

	/**
	 * MD5方式验签sign mo
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyByMD5(Map<String,String> params) throws Exception {
		try {
			boolean isOk=false;
			System.out.println("验签的参数"+ params);
			params.put(IpsConstants.Md5Key, md5Key);
			System.out.println("加密的params"+params);
			String sign=buildSignBack(params);
               
	        //验签(加密报文体+md5证书)
			isOk=MD5Utils.verify(sign,params.get(IpsConstants.sign),"UTF-8");
			return isOk;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	static {
//		RECV_MER_ID = PropertiesUtil.get("DEPOSIT.Huifu.RECV_MER_ID");
//
//		if (HuifuConstants.IS_MAIN_TEST) {
//			MER_PUB_KEY_PATH = "D:\\workspace\\zuoYue\\src\\main\\key\\key\\huifuPubTest.key";
//			MER_PRI_KEY_PATH = "D:\\workspace\\zuoYue\\src\\main\\key\\key\\huifuPriTest.key";
//		} else {
//			MER_PUB_KEY_PATH = ContextLoader.getCurrentWebApplicationContext()
//					.getServletContext()
//					.getRealPath(PropertiesUtil.get("DEPOSIT.Huifu.key.pub"));
//
//			MER_PRI_KEY_PATH = ContextLoader.getCurrentWebApplicationContext()
//					.getServletContext()
//					.getRealPath(PropertiesUtil.get("DEPOSIT.Huifu.key.pri"));
//		}
//
//	}
	
	/**
	 * sign MD5加密
	 * 
	 * @param_custId
	 * @param_forEncryptionStr
	 * @param_charset
	 * @return
	 * @throws Exception
	 */
	public static String encryptByMD5(Map<String, String> params) {
		String signStr = buildSignStr(params, IpsConstants.SEND_SIGN);
		log.info("拼接sign的参数:" + signStr);
		String signString=null;
		if (signStr == null) { // 不需要加密
			return null;
		}
		try {
			signString =MD5Utils.sign(signStr,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signString;
	}
	
	
	public static void main(String[] args) throws Exception {
		String a="";
		String b=EncryptUtils.Decrypt3DES(a, key);
		System.out.println("=====================bbb================"+b);
	}

	/**
	 * 判断字符串是否是乱码
	 * @param c
	 * @return
	 */
	public static  boolean isChinese(char c) {    
	    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);    
	    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS    
	        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS    
	        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A    
	        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION    
	        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION    
	        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {    
	      return true;    
	    }    
	    return false;    
	  }    
	    
	  public static  boolean isMessyCode(String strName) {    
	    Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");    
	    Matcher m = p.matcher(strName);    
	    String after = m.replaceAll("");    
	    String temp = after.replaceAll("\\p{P}", "");    
	    char[] ch = temp.trim().toCharArray();    
	    float chLength = ch.length;    
	    float count = 0;    
	    for (int i = 0; i < ch.length; i++) {    
	      char c = ch[i];    
	      if (!Character.isLetterOrDigit(c)) {    
	    
	        if (!isChinese(c)) {    
	          count = count + 1;    
	          System.out.print(c);    
	        }    
	      }    
	    }    
	    float result = count / chLength;    
	    if (result > 0.4) {    
	      return true;    
	    } else {    
	      return false;    
	    }    
	    
	  }
	
}
