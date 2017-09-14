package com.lrcf.yhb.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
* @ClassName: DateUtils.java
* @Description: 日期相关工具类
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月4日 下午4:16:16 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月4日     wangxf           v1.0.0               修改原因
 */
public class DateUtil {

	private static Logger log = LoggerFactory.getLogger(DateUtils.class);
	/**
	 * yyyy-MM-dd
	 */
	public static String DEFAULT_FORMAT = "yyyy-MM-dd";
	/**
	 * yyyy年MM月dd日
	 */
	public static String DEFAULT_FORMAT_INFO = "yyyy年MM月dd日";
	/**
	 * yyyyMMdd
	 */
	public static String FORMAT1 = "yyyyMMdd";
	/**
	 * HH:mm
	 */
	private static String timePattern = "HH:mm";
	/**
	 * yyyyMMddHHmmss
	 */
	private static String timePattern2 = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy 年份
	 */
	private static String dateYear = "yyyy";
	/**
	 * MM 月份
	 */
	private static String dateMonth = "MM";
	/**
	 * dd 日
	 */
	private static String dateDay = "dd";

	/**
	 *
	 * @Function: DateUtils.java
	 * @Description: 获取特定格式当天的时间
	 *
	 * @param: dateType
	 * @return：Date
	 * @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月4日 下午4:16:41
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	public static Date getTodayTime(String dateType){
		String date = getDate(new Date());
		Date today = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateType);
			today = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return today;
	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 根据日期格式，返回日期按 yyyy-MM-dd格式转换后的字符串
	*
	* @param: Date 日期
	* @return： String 格式化后的日期的页面显示字符串
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月4日 下午4:16:41
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(DEFAULT_FORMAT);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 获取 Date 时间格式的年份 yyyy
	*
	* @param: Date
	* @return： String
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月11日 上午8:56:07
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月11日     wangxf           v1.0.0               修改原因
	 */
	public static final String getDateYear(Date aDate){
		SimpleDateFormat df = null;
		String returnValue = "";

		if ( null != aDate ) {
			df = new SimpleDateFormat(dateYear);
			returnValue = df.format(aDate);
		}

		return returnValue;
	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 获取 Date 时间格式的月份 MM
	*
	* @param: Date
	* @return： String
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月11日 上午9:08:54
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月11日     wangxf           v1.0.0               修改原因
	 */
	public static final String getDateMonth(Date aDate){
		SimpleDateFormat df = null;
		String returnValue = "";

		if( null != aDate ){
			df = new SimpleDateFormat(dateMonth);
			returnValue = df.format(aDate);
		}
		return returnValue;
	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 获取 Date 时间格式的日期 dd
	*
	* @param: Date
	* @return： String
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月11日 上午9:08:54
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月11日     wangxf           v1.0.0               修改原因
	 */
	public static final String getDateDay(Date aDate){
		SimpleDateFormat df = null;
		String returnValue = "";

		if( null != aDate ){
			df = new SimpleDateFormat(dateDay);
			returnValue = df.format(aDate);
		}
		return returnValue;
	}


	public static final String parseToDateTimeStr(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(dateTimePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 格式化日期为：yyyyMMddHHmmss
	*
	* @param: Date 日期
	* @return： String 格式化后的日期的页面显示字符串
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月4日 下午4:17:41
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	public static final String dateToStr(Date date) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (date != null) {
			df = new SimpleDateFormat(timePattern2);
			returnValue = df.format(date);
		}

		return (returnValue);
	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 计算两个日期之间相差的天数
	*
	* @param smdate 较小的时间
	* @param bdate 较大的时间
	* @return：int 相差天数
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月4日 下午4:18:39
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis(); // smdate
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis(); // bdate
			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 计算两个日期之间相差的月数
	*
	* @param smdate 较小的时间
	* @param bdate 较大的时间
	* @return： int 相差月数
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月4日 下午4:19:40
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	public static int getMonthSpace(Date smdate, Date bdate) throws ParseException {

		int result = 0;

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(smdate);
		c2.setTime(bdate);

		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}

	public static int getMonth(Date smdate, Date bdate) throws ParseException {

		int result = 0;

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(smdate);
		c2.setTime(bdate);

		result = c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}

	public static final Date getMaxDay(Date date2, int num) throws ParseException {
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		calendar.setTime(date2);
		calendar.add(calendar.DATE, num);
		Date date = calendar.getTime();
		return date;

	}

	/**
	 *
	* @Function: DateUtils.java
	* @Description: 按照日期格式，将字符串解析为日期对象
	*
	* @param aMask 输入字符串的格式
	* @param strDate 一个按aMask格式排列的日期的字符串描述
	* @return：Date 对象
	* @throws：
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月4日 下午4:20:30
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月4日     wangxf           v1.0.0               修改原因
	 */
	public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: yyyy/MM/dd HH:MM
	 * a
	 *
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: yyyy-MM-dd
	 *
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	public static Calendar parseDate8(String dStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT1);
			Date date = sdf.parse(dStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 *
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 *
	 * @see SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * 根据日期格式，返回日期按DEFAULT_FORMAT格式转换后的字符串
	 * 
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(DEFAULT_FORMAT, aDate);
	}

	/**
	 * 按照日期格式，将字符串解析为日期对象
	 * 
	 * @param strDate
	 *            (格式 yyyy-MM-dd)
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate) throws ParseException {
		Date aDate = null;

		try {
			if (log.isDebugEnabled()) {
				log.debug("converting date with pattern: " + DEFAULT_FORMAT);
			}

			aDate = convertStringToDate(DEFAULT_FORMAT, strDate);
		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate + "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}

		return aDate;
	}

	/**
	 * 时间相加
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	public static Date addHour(Date date, int hour) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTime();
	}

	/**
	 * 月相加
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addMonth(Date date, int month) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	public static int getDay(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期对象
	 * @return String 日期字符串
	 */

	/**
	 * 本年的第一天
	 */
	public static String getYearFirst(Integer year) {
		return formatDate(getCurrYearFirst(year));
	}

	/**
	 * 本年的最后一天
	 * 
	 * @author cjx 2013-2-25 DateUtil String
	 * @param year
	 * @return
	 * 
	 * 		getYearLast
	 */
	public static String getYearLast(Integer year) {
		return formatDate(getCurrYearLast(year));
	}

	public static Integer getYear() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		String year = f.format(date);
		return Integer.valueOf(year);

	}

	/**
	 * 
	 * return yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		String sDate = f.format(date);
		return sDate;
	}

	public static String formatDate(String formatPattern, Date date) {
		SimpleDateFormat f = new SimpleDateFormat(formatPattern);
		String sDate = f.format(date);
		return sDate;
	}

	/**
	 * 
	 * return yyyy年MM月dd日
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateForDateInfo(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT_INFO);
		String sDate = f.format(date);
		return sDate;
	}

	/**
	 * 获取某年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getCurrYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取当月的第一天
	 * 
	 * @param
	 * @return
	 */
	public static String getMonthFirst() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MONTH, 0);
		// calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		String first = format.format(calendar.getTime());
		return first;
	}

	/**
	 * 获取当前月份的上N月
	 * 
	 * @param
	 * @return
	 */
	public static String getLastMonthFirst(int num) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MONTH, num);
		// calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		String first = format.format(calendar.getTime());

		return first;

	}

	/**
	 * 在当前时间上 加N天
	 * 
	 * @param num
	 * @return
	 */
	public static String getLastDayFirst(int num) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		// System.out.println("当前日期： "+format.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, num);
		String first = format.format(calendar.getTime());
		return first;

	}

	public static Date preciseToDay(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getCurrYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}
/*
	public static void main(String[] a) throws ParseException {
		// DateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);
		// System.out.println(daysBetween(df.parse("2016-06-28 00:18:12"),new
		// Date()));
		// System.out.println(parseToDateTimeStr(new Date()));
		// Date date=df.parse("2016-06-28 00:18:12");
		// System.out.println(date.toString());
		// SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println(sdf2.format(sdf1.parse("2013-09-30")));
		// System.out.println("当前月份第一天："+getMonthFirst());
		// System.out.println("当前月份上个月的第一天："+getLastMonthFirst(-3));
		// System.out.println("当前+1天:"+getLastDayFirst(0));
		//
		// System.out.println("当前时间：" +sdf2.format(new Date()));
		// System.out.println(isInTime("00:00:00-02:00:00","01:25"));

		Date d1 = sdf.parse("2017-4-22 23:59:59"); // 活动结束时间
		Date d2 = new Date(); // 当前时间
		Date d3 = sdf.parse("2017-4-21 21:59:59"); // 活动开始时间
		// System.out.println(d2.before(d3));
		// System.out.println(d1.before(d2));
		if (d3.before(d2) && d2.before(d1)) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		if (d2.before(d3) & d1.before(d2)) {
			System.out.println("NO");
		} else {
			System.out.println("OK");
		}

		// System.out.println(isInTime("2:00:00-10:00:00",parseToDateTimeStr(new
		// Date())));

	}*/

	/*
	 * public static Date formatStringToDate(String pattern,String date){
	 * SimpleDateFormat sdf=new SimpleDateFormat(pattern); }
	 */
	/**
	 * 格式化时间为时间
	 * 
	 * @param pattern
	 *            格式
	 * @param date
	 *            时间
	 * @return
	 */
	public static Date formatDateToDate(String pattern, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date afterFormatDate = null;
		try {
			afterFormatDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return afterFormatDate;
	}

	/**
	 * 
	 * @param date
	 * @return yyyyMMdd
	 */
	public static String formatDate8(Date date) {
		return formatDate(FORMAT1, date);
	}

	/**
	 * 判断某一时间是否在一个区间内
	 * 
	 * @param sourceTime
	 *            时间区间,半闭合,如[10:00-20:00)
	 * @param curTime
	 *            需要判断的时间 如10:00
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static boolean isInTime(String sourceTime, String curTime) {
		if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
			throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
		}
		if (curTime == null || !curTime.contains(":")) {
			throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
		}
		String[] args = sourceTime.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			long now = sdf.parse(curTime).getTime();
			long start = sdf.parse(args[0]).getTime();
			long end = sdf.parse(args[1]).getTime();
			if (args[1].equals("00:00")) {
				args[1] = "24:00";
			}
			if (end < start) {
				if (now >= end && now < start) {
					return false;
				} else {
					return true;
				}
			} else {
				if (now >= start && now < end) {
					return true;
				} else {
					return false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
		}
	}

	/**
	 *   获取开始时间和结束时间
	 *   type=1 当天的开始时间和结束时间
	 *   type=2 本周的开始时间和结束时间
	 *   type=3 本月的开始时间和结束时间
	 * @param type
	 * @return map
	 * Author Czy
     */
	public static Map<String, String> getTime(String type){


		Integer type1= type==null || type .equals("") ? 1: Integer.parseInt(type);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		String day ="";
		String day1="";
		if(type1==1){

			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.MILLISECOND, 0);
			day =sdf.format(cal.getTime());

			// 获得当天24点时间

			cal1.set(Calendar.HOUR_OF_DAY, 24);
			cal1.set(Calendar.SECOND, 0);
			cal1.set(Calendar.MINUTE, 0);
			cal1.set(Calendar.MILLISECOND, 0);
			day1=sdf.format(cal1.getTime());
		}else if(type1==2){
			// 获得本周一0点时间
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			day=sdf.format(cal.getTime());

			// 获得本周日24点时间

			cal1.setTime(cal.getTime());
			cal1.add(Calendar.DAY_OF_WEEK, 7);
			day1=sdf.format(cal1.getTime());
		}else if(type1==3){
			// 获得本月第一天0点时间
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			day=sdf.format(cal.getTime());

			// 获得本月最后一天24点时间
			cal1.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal1.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal1.set(Calendar.HOUR_OF_DAY, 24);
			day1=sdf.format(cal1.getTime());
		}
		Map<String, String > map = new HashMap<String, String>();
//		map.put("startTime", day);
//		map.put("endTime", day1);
		map.put("startTime", "2017-01-02");
		map.put("endTime", "2017-02-01");
		return map;
	}
}
