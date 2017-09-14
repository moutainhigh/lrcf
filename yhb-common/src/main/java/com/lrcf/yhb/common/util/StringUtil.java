package com.lrcf.yhb.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: StringUtil.java
 * @Description: String 工具类
 * @author:Krx
 * @date: 2017年4月27日 下午2:31:11
 */
public class StringUtil {

	private static Pattern linePattern = Pattern.compile("_(\\w)");
	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 下划线转驼峰
	 * 
	 * @param str
	 * @return
	 */
	public static String lineToHump(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);

		str = sb.toString();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);

		return str;
	}

	/**
	 * 
	 * @Description: 替换符号
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年5月9日 下午5:06:26
	 */
	public static void replaceQuotes(Map<String, String> m) {
		Iterator<Entry<String, String>> entrys = m.entrySet().iterator();
		while (entrys.hasNext()) {
			Entry<String, String> entry = entrys.next();
			String value = entry.getValue();
			if (!StringUtils.isEmpty(value)) {
				m.put(entry.getKey(), value.replaceAll("\"", "&quot;").replaceAll("'",
						"&apos;"));
			}

		}
	}

	/**
	 * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
	 * 
	 * @param str
	 * @return
	 */
	public static String humpToLine(String str) {
		return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}

	/**
	 * 驼峰转下划线,效率比上面高
	 * 
	 * @param str
	 * @return
	 */
	public static String humpToLine2(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 
	 * @Function: StringUtil.java
	 * @Description: 字符串判断是否为空,不为空：true，空：false
	 *
	 * @param: String
	 * 			@return： boolean 不为空：true，空：false @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 上午9:56:49
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月4日 wangxf v1.0.0 修改原因
	 */
	public static boolean isNotBlank(String str) {
		return (null != str && !"".equals(str));
	}

	/**
	 * 
	 * @Function: StringUtil.java
	 * @Description: 判断字符串是否为空，是：true，否：false
	 *
	 * @param: @return：
	 * 			@throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 下午4:00:06
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月8日 wangxf v1.0.0 修改原因
	 */
	public static boolean isBlank(String str) {
		return (null == str || "".equals(str));
	}

	/**
	 * 
	 * @Function: StringUtil.java
	 * @Description: 判断对象是否为空，是：true，否：false
	 *
	 * @param: @return：
	 * 			@throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月8日 下午4:00:06
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月8日 wangxf v1.0.0 修改原因
	 */
	public static boolean isBlank(Object obj) {
		boolean flag = false;
		if (null == obj || "".equals(obj))
			flag = true;
		return flag;
	}

	/**
	 * 首字母转小写
	 * 
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * 首字母转大写
	 * 
	 * @param s
	 * @return
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * object转String
	 * 
	 * @param object
	 * @return
	 */
	public static String getString(Object object) {
		return getString(object, "");
	}

	public static String getString(Object object, String defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		try {
			return object.toString();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * object转Integer
	 * 
	 * @param object
	 * @return
	 */
	public static int getInt(Object object) {
		return getInt(object, -1);
	}

	public static int getInt(Object object, Integer defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(object.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * object转Boolean
	 * 
	 * @param object
	 * @return
	 */
	public static boolean getBoolean(Object object) {
		return getBoolean(object, false);
	}

	public static boolean getBoolean(Object object, Boolean defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		try {
			return Boolean.parseBoolean(object.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/** 将String 替换操作，将str1替换为str2 * */
	public static String replace(String str, String str1, String str2) {
		int n = -1;
		String subStr = "";
		String re = "";
		if ((n = str.indexOf(str1)) > -1) {
			subStr = str.substring(n + str1.length(), str.length());
			re = str.substring(0, n) + str2 + replace(subStr, str1, str2);
		} else {
			re = str;
		}
		return re;
	}

	/** 将字符串转换成Utf-8编码格式 * */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 用给定的分隔符对字符串进行拆分，并生成数组
	 * 
	 * @param message
	 *            需要拆分的字符串
	 * @param separator
	 *            分隔符
	 * @return 生成的数组
	 */
	public static String[] splitToArray(String message, String separator) {
		List list = new ArrayList();
		int start = 0;
		int index = 0;
		while ((index = message.indexOf(separator, start)) != -1) {
			list.add(message.substring(start, index));
			start = index + separator.length();
		}

		if (start < message.length()) {
			list.add(message.substring(start, message.length()));
		}

		return (String[]) list.toArray(new String[list.size()]);
	}

	/** 将字符串转换为java.sql.date类型,str的格式必须匹配给定的格式formatStr * */
	public static java.sql.Date str2SqlDate(String str, String formatStr) {
		java.sql.Date sqlDate = new java.sql.Date(0);// 默认获得当前时间
		try {
			sqlDate = new java.sql.Date(new SimpleDateFormat(formatStr).parse(str).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	/** 将对象的返回的值不能为空 */
	public static String clear(Object obj) {
		if (null == obj || "null".equals(obj))
			return "";
		return obj.toString();
	}

	/** 将对象的返回的值不能为空，否则返回0 */
	public static String clearToZero(Object obj) {
		if (null == obj)
			return "0";
		return obj.toString();
	}

	/** 若对象为空返回指定的值 */
	public static String clear(Object obj, String value) {
		if (null == obj)
			return value;
		return obj.toString();
	}

	/** 判断对象的值是否为空 */
	public static boolean isNull(Object obj) {
		boolean flag = false;
		if (null == obj || "".equals(obj))
			flag = true;
		return flag;

	}

	/** 判断对象的值是否为空 */
	public static boolean isNotNull(Object obj) {
		boolean flag = true;
		if (null == obj || "".equals(obj))
			flag = false;
		return flag;

	}

	public static boolean isNotNull(List l) {
		if (null != l && l.size() > 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @Description: str不為空
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年4月27日 下午2:39:19
	 */
	public static boolean isNotNull(String str) {
		if (null != str && str.trim().length() > 0)
			return true;
		return false;
	}

	public static boolean isNotNull(String[] str) {
		if (null != str && str.length > 0)
			return true;
		return false;
	}

	public static String replaceStrNullOrNot(String str) {
		if (null != str && str.length() > 0) {
			return str;
		} else {
			return " ";
		}
	}

	public static String replaceStrNullOrNot(Object obj) {
		if (null != obj && !"".equals(obj)) {
			return obj.toString();
		} else {
			return " ";
		}
	}

	/**
	 * 
	 * 方法名称:isNull
	 * <p>
	 * 方法描述:判断是字符串是否为空
	 * <p>
	 * 参数:
	 * 
	 * @param str
	 *            字符串 参数:
	 * @return boolean
	 *         <p>
	 *         <p>
	 * @author HJun
	 *         <p>
	 * @date Sep 2, 2009
	 *       <p>
	 */
	public static boolean isNull(String str) {
		if (null == str || "".equals(str.trim()))
			return true;
		return false;
	}

	/**
	 * 
	 * 方法名称:isNull
	 * <p>
	 * 方法描述: 判断结果集是否为空
	 * <p>
	 * 参数:
	 * 
	 * @param list
	 *            结果集对象 参数:
	 * @return boolean
	 *         <p>
	 *         <p>
	 * @author HJun
	 *         <p>
	 * @date Sep 2, 2009
	 *       <p>
	 */
	public static boolean isNull(List list) {
		if (null == list || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * 方法名称:isNull
	 * <p>
	 * 方法描述: 判断字符串数组是否为空
	 * <p>
	 * 参数:
	 * 
	 * @param str
	 *            String[] 字符串数组 参数:
	 * @return boolean
	 *         <p>
	 *         <p>
	 * @author HJun
	 *         <p>
	 * @date Sep 2, 2009
	 *       <p>
	 */
	public static boolean isNull(String[] str) {
		if (null == str || str.length == 0)
			return true;
		return false;
	}

	public static String translateToChinese(String str) {
		if (str != null && !"".equals(str) && IsNumber(str)) {
			return translateToChinese(Integer.parseInt(str));
		} else {
			return "0";
		}

	}

	/**
	 * @方法名 translate
	 * @功能 简单的数字转中文
	 * @param a
	 *            原始数字
	 * @return 中文字符串
	 */
	public static String translateToChinese(int a) {

		String[] units = { "", "十", "百", "千", "万", "十", "百", "千", "亿" };
		String[] nums = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };

		String result = "";
		if (a < 0) {
			result = "负";
			a = Math.abs(a);
		}
		String t = String.valueOf(a);
		for (int i = t.length() - 1; i >= 0; i--) {
			int r = (int) (a / Math.pow(10, i));
			if (r % 10 != 0) {
				String s = String.valueOf(r);
				String l = s.substring(s.length() - 1, s.length());
				result += nums[Integer.parseInt(l) - 1];
				result += (units[i]);
			} else {
				if (!result.endsWith("零")) {
					result += "零";
				}
			}
		}
		String num = a + "";
		/*
		 * 因为方法对10-20之间的数字支持不好，比如11返回一十一，不能满足需求 所以这里单独判断
		 */
		if (a == 10) {
			return "十";
		} else if (a > 10 && a < 20) {
			return result.substring(1);
		} else if (num.endsWith("0")) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	/**
	 * 
	 * @Description: 0 不等 空 判断 o=str 否则 false
	 *
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年4月27日 下午2:37:40
	 */
	public static boolean eq(String str, Object o) {
		if (null != o && isNotNull(o)) {
			return o.equals(str);
		}
		return false;
	}

	/**
	 * 
	 * @Description: o1为空然后02为空 返回true 否 false 或者 o1 不为空 判断o1等于o2
	 *
	 * @author: Krx
	 * @date: 2017年4月27日 下午2:36:28
	 */
	public static boolean eq(Object o1, Object o2) {
		if (null == o1 || isNull(o1)) {
			if (o2 == null || isNull(o2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return o1.equals(o2);
		}
	}

	/**
	 * @return String
	 * @author Administrator 2009-9-20
	 */
	public static String toString(List list) {
		StringBuffer reStr = new StringBuffer("");
		for (Object o : list) {
			reStr.append(o.toString());
			reStr.append(",");
		}
		return reStr.toString();
	}

	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * 截取字符串
	 * 
	 * @param src
	 *            待截取字符串
	 * @param num
	 *            截取长度
	 * @return 截取后的字符串
	 */
	public static String cutString(String src, int num) {
		if (isNull(src))
			return src;
		return src.substring(0, src.length() > num ? num : src.length());
	}

	public static double mulite(String str, String str2) {
		double d1 = Double.parseDouble(str);
		double d2 = Double.parseDouble(str2);
		return d1 * d2;
	}

	/**
	 * @函数名称：IsNumber
	 * @功能描述：是否数字
	 * @param str：true表示是，false表示否
	 * @return：是或否
	 * @exception: null
	 *                 空指针异常
	 */
	public static boolean IsNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * @函数名称：IsNumber
	 * @功能描述：是数值
	 * @param str：true表示是，false表示否
	 * @return：是或否
	 * @exception: null
	 *                 空指针异常
	 */
	public static boolean IsFloat(String str) {
		Pattern pattern = Pattern.compile("\\d+[.]?\\d*");
		return pattern.matcher(str).matches();
	}

	public static String getRequestStr(HttpServletRequest request, String param) {
		String result = request.getParameter(param);
		if (StringUtil.isNull(result)) {
			result = (String) request.getAttribute(param);
		}
		if (StringUtil.isNull(result)) {
			result = "";
		}
		result = result.trim();
		return result;
	}

	/**
	 * XML字符串中不能用这些字符 < > ' " &
	 * 
	 * @param str
	 *            待转换的字符串
	 * @return String 转换后的字符串
	 * @author zhangg
	 */
	public static String replace4XML(String str) {
		if (str == null)
			return "";
		return str.replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;").replace("&",
				"&amp;");
	}

	/**
	 * 和“WebContent/skins/default/js/sotowerfunction.js”里的方法“tag2code()”是一对，
	 * 需要一起修改
	 * 
	 * @函数名称：HtmlTag2String
	 * @功能描述：转换html符号为字符
	 * @param：String
	 * @return：String
	 */
	public static String HtmlTag2String(String temp) {
		temp = temp == null ? "" : temp;
		return temp.replace("-lt;", "<").replace("-gt;", ">").replace("-amp;", "&");
	}

	/**
	 * 
	 * 方法名称：zero 方法描述：设置小数，前面没有0增加0
	 * 
	 * @param str
	 * @return
	 * @return String
	 * @author HJun
	 * @version 1.0 Dec 17, 2009
	 */
	public static String zero(String str) {
		if (str.startsWith(".")) {
			str = "0".concat(str);
		}
		return str;
	}

	/**
	 * @函数名称：String2HtmlTag
	 * @功能描述：转换“<”、“>”为html符号
	 * @param：String
	 * @return：String
	 */
	public static String String2HtmlTag(String temp) {
		temp = temp == null ? "" : temp;
		return temp.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'",
				"&acute;");
	}

	/**
	 * split("separator",'a') returns {"sep","r","tor"}
	 * 
	 * @函数名称：convertToUTF8
	 * @功能描述：方法描述拆分字符串
	 * @param src
	 * @param char
	 * @return <br>
	 */
	public static String[] split(String src, char separator) {

		if (src == null)
			return null;
		else
			src = src.trim();
		int sprtCount = count(src, separator);
		if (sprtCount == 0) {
			String[] det = new String[1];
			det[0] = src;
			return det;
		}
		String[] det = new String[sprtCount + 1];
		int indexs = 0, indexe = 0;
		for (int i = 0; i <= sprtCount; i++) {
			indexe = src.indexOf(separator, indexs);
			if (indexe == -1)
				det[i] = src.substring(indexs);
			else {
				det[i] = src.substring(indexs, indexe);
				indexs = indexe + 1;
			}
		}
		return det;
	}

	/**
	 * @函数名称：count
	 * @功能描述：方法描述个数
	 * @param pStr
	 *            String
	 * @return String
	 */
	public static int count(String ptr, char c) {
		int coun = 0, pos = 0;
		while ((pos = ptr.indexOf(c, pos)) != -1) {
			coun++;
			pos++;
		}
		return coun;
	}

	/**
	 * @函数名称：count
	 * @功能描述：方法描述个数
	 * @param pStr
	 *            String
	 * @param c
	 *            String
	 * @return String
	 */
	public static int count(String ptr, String c) {
		int coun = 0, pos = 0;
		while ((pos = ptr.indexOf(c, pos)) != -1) {
			coun++;
			pos += c.length();
		}
		return coun;
	}

	/**
	 * @函数名称：getDoubleXDigit
	 * @功能描述：保留X位小数
	 * @param obj
	 *            String
	 * @param x
	 *            double
	 * @return double
	 */
	public static double getDoubleXDigit(String obj, double x) {
		double tmpD = Double.parseDouble(obj);
		double y = 10;
		y = Math.pow(y, x);
		tmpD = tmpD * y;
		tmpD = Math.round(tmpD);
		tmpD = tmpD / y;
		return tmpD;
	}

	public static String getReplaceStr(String str, String regStr) {
		Pattern p = Pattern.compile(regStr);
		Matcher m = p.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	public static String getBackName(String fileName) {
		if (isNull(fileName))
			return "";
		if (fileName.lastIndexOf(".") < 0)
			return "";
		return fileName.substring(fileName.lastIndexOf("."));
	}

	public static String getGBK(String str, String code) {
		try {
			return new String(str.getBytes(), code);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/** 提供字符串到ArrayList的转变 * */
	public static List<String> str2List(String tStr, String sStr) {
		if (isNull(tStr)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(tStr, sStr);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}

	/**
	 * 方法名称： 方法描述：
	 * 
	 * @param context
	 * @version 1.0
	 */
	public static String convertString(String s) {
		if (isNotNull(s)) {
			char[] c = s.toCharArray();
			String str = "";
			int i = 0;
			for (char ch : c) {
				if (Character.isUpperCase(ch) && i > 0) {
					str += "_";
				}
				str += ch;
				i++;
			}
			return str;
		} else {
			return "";
		}
	}

	public static String convertString1(String s) {
		if (isNotNull(s)) {
			String ss = s.toLowerCase();
			char[] carr = ss.toCharArray();
			String str = "";
			char temp = 0;
			for (int i = 0; i < carr.length; i++) {
				if (i > 0)
					temp = carr[i - 1];
				if (Character.isLetter(carr[i]) && temp == '_') {
					str += (carr[i] + "").toUpperCase();
				} else {
					str += carr[i];
				}
			}
			str = str.replace("_", "");
			return str;
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @author zhangling 在模糊查询中过滤容易引发SQL语句执行异常的符号
	 */
	public static String ReplaceSqlLike(String strQuery) {
		String strRet = strQuery;
		strRet = strRet.replace("/", "//");
		strRet = strRet.replace("'", "''");
		strRet = strRet.replace("%", "/%");
		strRet = strRet.replace("[", "/[");
		strRet = "'%" + strRet + "%' escape '/'";
		return strRet;
	}

	/**
	 * 
	 * @return返回时间格式字符串。按年，月
	 */
	public static String getDirName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		Date date = new Date();
		return df.format(date);
	}

	/**
	 * 用特殊的字符连接字符串
	 * 
	 * @param strings
	 *            要连接的字符串数组
	 * @param spilit_sign
	 *            连接字符
	 * @return 连接字符串
	 */
	public static String stringConnect(String[] strings, String spilit_sign) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			str.append(strings[i]);
			str.append(spilit_sign);
		}
		return str.toString();
	}

	/**
	 * 分割字符串
	 * 
	 * @param str
	 *            要分割的字符串
	 * @param spilit_sign
	 *            字符串的分割标志
	 * @return 分割后得到的字符串数组
	 */
	public static String[] stringSpilit(String str, String spilit_sign) {
		String[] spilit_string = str.split(spilit_sign);
		if (spilit_string[0].equals("")) {
			String[] new_string = new String[spilit_string.length - 1];
			for (int i = 1; i < spilit_string.length; i++)
				new_string[i - 1] = spilit_string[i];
			return new_string;
		} else
			return spilit_string;
	}

	/**
	 * 字符串字符集转换
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 转换过的字符串
	 */
	public static String stringTransCharset(String str) {
		String new_str = null;
		try {
			new_str = new String(str.getBytes("iso-8859-1"), "GBK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new_str;
	}

	public static String getUUId(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
