package com.lrcf.yhb.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 随机数类
 * 
 * @author Krx
 *
 */
public class GenerateNo {

	private static int indx = 10;

	public static synchronized int nextIndx() {
		if (indx > 999)
			indx = 10;
		return indx++;
	}

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String userUUID = uuid.toString();
		return userUUID;
	}
	
	/**
	 * 生成Token
	 * @param
	 * @return
	 */
	public static String getToken() {
		UUID uuid = UUID.randomUUID();
		String token = uuid.toString().replace("-", "");
		return token;
	}

	/**
	 * 生成充值流水号，是D开始+ 用户ID+当前的年月日时分秒+6位不重复的随机数
	 * 
	 * @return
	 */
	public static String payRecordNo(String userName) {
		try {
			String pre = "D";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 2);
			System.out.println(pre + dateString + userName + randomString);
			return pre + dateString + userName + randomString;
		} catch (Exception e) {
			System.out.println("生成充值流水号出错====" + e.toString());
		}
		return "";
	}

	/**
	 * 生成充值流水号，是C开始+ 用户ID+当前的年月日时分秒+6位不重复的随机数
	 * 
	 * @return
	 */
	public static String payRecordNoC(String userName) {
		try {
			String pre = "C";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 6);
			return pre + dateString + randomString;
		} catch (Exception e) {
			System.out.println("生成充值流水号出错====" + e.toString());
		}
		return "";
	}

	/**
	 * 生成充值流水号，是C开始+ 用户ID+当前的年月日时分秒+6位不重复的随机数
	 * 
	 * @return
	 */
	public static String payRecordNo(Integer userId) {
		try {
			String pre = "yhb";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 5);
			System.out.println(pre + userId + dateString + randomString);
			return pre + userId + dateString + randomString;
		} catch (Exception e) {
			System.out.println("生成充值流水号出错====" + e.toString());
		}
		return "";
	}

	/**
	 * 获取纯数字唯一订单号
	 * 
	 * @return
	 */
	public static String nextOrdId() {
		long time = new Date().getTime();
		int end = (int) (Math.random() * 10);
		System.out.println(String.valueOf(nextIndx()).concat(String.valueOf(time)).concat(String.valueOf(end)));
		return String.valueOf(nextIndx()).concat(String.valueOf(time)).concat(String.valueOf(end));
	}

	/**
	 * codeNo
	 * 
	 * @return
	 */
	public static String getcodeNo() {
		try {
			String pre = "yhb";
			int end = (int) (Math.random() * 10);
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 5);
			System.out.println(pre + end + randomString);
			return pre + end + randomString;
		} catch (Exception e) {
			System.out.println("生成充值流水号出错====" + e.toString());
		}
		return "";
	}

	/**
	 * codeNo
	 * 
	 * @return
	 */
	public static String getAgentcodeNo() {
		try {
			// String pre = "yhb";
			int end = (int) (Math.random() * 10);
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 5);
			return end + randomString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 生成纯数字订单
	 * 
	 * @param-args
	 * @throws Exception
	 */
	public static String numOrdId() {
		String num = "5";
		int number = (int) (Math.random() * 10);
		String randomString = String.valueOf(Math.random()).substring(2).substring(0, 5);
		return String.valueOf(num + number + randomString);

	}

	/**
	 * 生成yg开头的订单号
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static String uuidOrdId() {
		UUID uuid = UUID.randomUUID();
		String pre = "yg";
		String num = uuid.toString().substring(24, 36);

		return pre + num;

	}

   //商户账号
	private static String merchatID ="1184980025";

	/**
	 * 生成注册时的流水号 商户号+5位随机数字不重复的+当前时间的年月
	 * 
	 * @return
	 */
	public static String getRecordNo() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String merChantString = merchatID;
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 5);
			System.out.println(merChantString + randomString + dateString);
			return merChantString + randomString + dateString;
		} catch (Exception e) {
			System.out.println("生成充值流水号出错====" + e.toString());
		}
		return "";
	}

	/**
	 * 生成充值流水号16位，是当前的年月日时分秒+2位不重复的随机数
	 * 
	 * @return
	 */
	public static String payRecordNo() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 6);
			return dateString + randomString;
		} catch (Exception e) {
			System.out.println("生成充值流水号出错====" + e.toString());
		}
		return "";
	}

	/**
	 * 生成充值流水号16位，是当前的年月日时分秒毫秒+2位不重复的随机数
	 * 
	 * @return
	 */
	public static String product() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = sdf.format(new Date());
		String randomString = String.valueOf(Math.random()).substring(2).substring(0, 4);
		System.out.println(dateString + randomString);
		return dateString + randomString;
	}

	public static void main(String[] args) throws Exception {
		// UUID uuid = UUID.randomUUID();
		// String num=uuid.toString().substring(24, 36);
		// System.out.println(num);

		GenerateNo p = new GenerateNo();
		p.getAgentcodeNo();

	}

	/**
	 * 生成VipCard，是VIP开始+ 用户ID+当前的年月日时分秒+6位不重复的随机数
	 * 
	 * @return
	 */
	public static String vipCard(Integer userId) {
		try {
			String pre = "VIP";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 6);
			return pre + userId + dateString + randomString;
		} catch (Exception e) {
			System.out.println("生成VIPCard出错====" + e.toString());
		}
		return "";
	}

	/**
	 * 生成标编号 生成规则，标种编号+发标人ID+年月日时分少+6位随机数 2014-1-9 cjx
	 */
	public static String getBorrowNo(String borrowTypeNo, Integer userId) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateString = sdf.format(new Date());
			String randomString = String.valueOf(Math.random()).substring(2).substring(0, 6);

			return borrowTypeNo + userId + dateString + randomString;
		} catch (Exception e) {
			System.out.println("生成标编号出错====" + e.toString());
		}
		return "";
	}
}
