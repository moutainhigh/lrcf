package com.lrcf.yhb.common.api.ips;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;



/**
 * 字符串操作类
 * @author KRX
 * @date  2016/12/7
 */
public class StringUtil {

	public static List<String[]> splitToList(String orgStr, String splitStr1,
			String splitStr2) {
		List<String[]> list = new ArrayList<String[]>();

		String[] newStr = removeLastStr(orgStr, splitStr1).split(splitStr1);
		for (String tmpStr : newStr) {
			list.add(removeLastStr(tmpStr, splitStr2).split(splitStr2));
		}
		return list;
	}

	public static String[] splitToArray(String orgStr, String splitStr) {
		return removeLastStr(orgStr, splitStr).split(splitStr);
	}
	public static void replaceQuotes(Map<String,String> m){
		Iterator<Entry<String, String>> entrys = m.entrySet().iterator();
		while(entrys.hasNext()){
			Entry<String, String> entry = entrys.next();
			String value = entry.getValue();
			if(!StringUtils.isEmpty(value)){
				m.put(entry.getKey(), value
						.replaceAll("\"", IpsConstants.HTML_Quotes_Double)
						.replaceAll("'", IpsConstants.HTML_Quotes_Single));
			}
			
		}
	}
	
	public static void replaceToHtmlTag(Map<String, String> m)
	{
		Iterator<Entry<String, String>> entrys = m.entrySet().iterator();
		while (entrys.hasNext())
		{
			Entry<String, String> entry = entrys.next();
			String value = entry.getValue();
			if (!StringUtils.isEmpty(value))
			{
				m.put(entry.getKey(),
						value.replaceAll(IpsConstants.HTML_Quotes_Double, "\"")
								.replaceAll(IpsConstants.HTML_Quotes_Single, "'"));
			}

		}
	}
	
	public static String replaceToHtml(String str){
		return str.replaceAll(IpsConstants.HTML_Quotes_Double, "\"")
				.replaceAll(IpsConstants.HTML_Quotes_Single, "'")
				.replaceAll("&lt;","<")
				.replaceAll("&gt;",">")
				.replaceAll("&nbsp;", " ")
				.replaceAll("&amp;", "&");
	}

	public static String removeLastStr(String orgStr, String lastStr) {
		if (orgStr.endsWith(lastStr)) {
			orgStr = orgStr.substring(0, orgStr.lastIndexOf(lastStr));
		}
		return orgStr;
	}

	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * 替换字符串
	 * 
	 * @param str
	 * @param map
	 * @param tag
	 * @return
	 */
	public static String replaceString(String str,
			final Map<String, Object> map, final String tag) {
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			Object value = entry.getValue();

			String replaceStr = tag + key + tag;
			if (str.contains(replaceStr)) {
				str = str.replaceAll(replaceStr, toString(value));
			}
		}
		return str;
	}

	/**
	 * 替换字符串
	 * 
	 * @param str
	 * @param map
	 * @return
	 */
	public static String replaceString(String str, final Map<String, Object> map) {
		return replaceString(str, map, "%");
	}


	public static final String EMPTY = "";

	public static boolean isNotNULL(String str)
	{
		return str != null;
	}

	public static boolean isNULL(String str)
	{
		return str == null;
	}

	public static boolean isEmpty(String str)
	{
		return (str == null) || (str.length() == 0);
	}

	public static boolean isNotEmpty(String str)
	{
		return !isEmpty(str);
	}

	public static boolean isBlank(String str)
	{
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return true;

		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(String str)
	{
		return !isBlank(str);
	}

	public static String trim(String str)
	{
		return str == null ? null : str.trim();
	}

	public static String trimToNull(String str)
	{
		String ts = trim(str);
		return isEmpty(ts) ? null : ts;
	}

	public static String trimToEmpty(String str)
	{
		return str == null ? "" : str.trim();
	}

	public static byte[] getBytes(String content, String charset)
	{
		if (isNULL(content)) {
			content = "";
		}
		if (isBlank(charset))
			throw new IllegalArgumentException("charset can not null");
		try
		{
			return content.getBytes(charset); } catch (UnsupportedEncodingException e) {
		}
		throw new RuntimeException("charset is not valid,charset is:" + charset);
	}

	public static byte[] getBytes(String content)
	{
		if (isNULL(content)) {
			content = "";
		}
		return content.getBytes();
	}

	public static String getString(byte[] binaryData, String charset) {
		try {
			return new String(binaryData, charset); } catch (UnsupportedEncodingException e) {
		}
		throw new RuntimeException("charset is not valid,charset is:" + charset);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = URLDecoder.decode("%E5%95%86%E6%88%B7%E6%B2%A1%E6%9C%89%E5%BC%80%E9%80%9A%E6%9D%83%E9%99%90", "utf-8");
		System.out.println(a); 
	}

}
