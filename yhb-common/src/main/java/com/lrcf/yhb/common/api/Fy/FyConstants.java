package com.lrcf.yhb.common.api.Fy;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FyConstants {

	/**
	 * 指定富友是否开通
	 */
	public static final boolean ADMIN_FY_ISOK = true;
	public static final String operationType = "operationType";// 操作类型
	public static final String md5 = "md5";  //将表单提交的各个域加上系统分配的商户密钥，按照文档顺序拼成一个字符串，用“|”分割。对这个字符串做MD5摘要，字符串编码格式必须为“UTF-8”
	
	public static final String success_code ="0000";  //成功！
	
	public static final String order_pay_code = "order_pay_code";  //返回的代码
	public static final String order_pay_error = "order_pay_error";  //错误描述
	
	public static final String post_jm = "1";  //提交的表单是否加密
	public static final String app_trade_type = "10";  //提交的表单的交易类型
	
	public static final String version ="1.0.1";
	public static final String ver ="ver";  //版本目前填1.0.1
	
	public static final String fy_ssn = "fy_ssn";  //返回的充值订单号码
	
	public static final String gateWayUrl = "gateWayUrl"; //post汇付地址
	 
	public static final String order_st = "order_st";  //订单状态
	
	public static final String B2C ="B2C";
	public static final String B2B ="B2B";
	public static final String FYCD ="FYCD";
	public static final String SXF ="SXF";
	
	public static final String back_notify_url ="back_notify_url";  //商户接收支付结果后台通知地址
	public static final String page_notify_url = "page_notify_url";  //商户接收支付结果通知地址
	
	public static final String sign = "sign";  //签名
	public static final String mchnt_key ="mchnt_key";  // 秘钥
	

	
	public static final String TYPE_FROM ="TYPE_FROM";  //from表单提交
	
	public static final String TYPE_XML="TYPE_XML"; //xml提交
	public static final String TYPE_XML1 = "TYPE_XML1";//APPxml提交
	/******************** smpGate.do *****************************/
	public static final String mchnt_cd = "mchnt_cd";    //商户号
	public static final String order_id = "order_id";    //订单Id
	public static final String order_amt = "order_amt";   //订单金额
	public static final String order_pay_type = "order_pay_type";   //充值类型  ‘B2C’ – B2C支付 ‘B2B’ – B2B支付  ‘FYCD’ – 预付卡 ‘SXF’ – 随心富
	public static final String iss_ins_cd = "iss_ins_cd";   //银行编号
	public static final String Fy_ssn = "fy_ssn";  //富有对账订单号
 
	/******************** App cardBinQuery.pay *****************************/
	public static final String Ono = "Ono";    //银行卡号
	public static final String MchntCd = "MchntCd";    //商户号
	public static final String Sign = "Sign";    //签名
	
	/******************** App payAction.pay *****************************/
    public static final String LOGOTP ="LOGOTP";   //是否隐藏支付页面富友的 logo，1隐藏，0 显示
	public static final String MCHNTORDERID = "MCHNTORDERID";   //商户订单流水号商户确保唯一
	public static final String USERID = "USERID";   //用户在商户端的唯一编号，即用户ID
	public static final String AMT = "AMT";   //客户支付订单的总金额，一笔订单一个，以分为单位。不可以为零，不能有小数点，必需符合金额标准
	public static final String BANKCARD ="BANKCARD";  //支付的银行卡卡号
	public static final String BACKURL = "BACKURL";  //商户接收支付结果的后台通知地址
	public static final String HOMEURL = "HOMEURL";  //在富友的支付成功页面跳转到该地址
	public static final String REURL = "REURL";  // 在富友的支付失败页面跳转到该地址进行重新支付
	
	public static final String NAME = "NAME";  //用户姓名
	public static final String IDTYPE = "IDTYPE";  //身份证
	public static final String IDNO = "NAME";  //用户身份证号  
	/**
	 * 支付的银行机构号
	 */
	public static final String INSCD = "INSCD";  
	
	public static final String REM1 = "REM1";  //保留字段 1
	public static final String REM2 = "REM2";  //保留字段 1
	public static final String REM3 = "REM3";  //保留字段 1
	
    public static final String ENCTP ="ENCTP"; //是否对订单信息FM域的内容进行加  密，1 表示加密，0 表示不加密
	public static final String SIGNTP ="SIGNTP"; //签名方式
	public static final String SIGN ="SIGN";  //签名
	
	
	public static final String VERSION ="VERSION"; //app版本信息
	public static final String MCHNTCD ="MCHNTCD";  //富友分配给各合作商户的唯一识别码
	public static final String FM ="FM";  //订单信息
	public static final String APP_version ="2.0"; // app版本
	public static final String TYPE ="TYPE";//交易类型  
	/******* 定义所有cmdId ****************/
	public static final String smpGate = "smpGate.do"; // 快速充值
	public static final String smpQueryGate = "smpQueryGate.do"; // 3.2支付结果查询
	public static final String smpAQueryGate ="smpAQueryGate.do";  //查询支付结果直接返回
	public static final String cardBinQuery ="cardBinQuery.pay";  //查询银行卡
	public static final String payAction ="payAction.pay";   //app支付
	public static final String lmtQueryAction ="lmtQueryAction.pay";   //app限额查询
	
	/**app商户订单结果查询接口**/
	
	/**
	 * 订单号
	 */
	public static final String OrderId = "OrderId";
	/**
	 * 是否是金账户允许的金额<br>
	 * 将传入的字符串转成BigDecimal乘以100，再按照new DecimalFormat("###########.##")格式化
	 * 
	 * @param money
	 * @return 为空则金额非法，否则返回处理过的以分为单位的金额
	 */
	public static String isJzhMoney(String money) {
		String result = "";
		try {
			DecimalFormat df = new DecimalFormat("###########.##");
			BigDecimal bigDecimal = new BigDecimal(money)
					.multiply(new BigDecimal(100));
			money = df.format(bigDecimal);
			if (money.indexOf(".") < 0) {
				result = money;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//订单状态集合
	public static Map<String, String> FY_ORDER_STATE = new HashMap<String, String>();
	
	public static final Map<String, String[]> SignOrgMap = new HashMap<String, String[]>();
	
	static{
		//充值
		SignOrgMap.put(smpGate, new String[] { mchnt_cd, order_id,
				order_amt, order_pay_type, page_notify_url ,iss_ins_cd,ver,mchnt_key});
		
		
		FY_ORDER_STATE.put("00", "订单已生成(初始状态)");
		FY_ORDER_STATE.put("01", "订单已撤消");
		FY_ORDER_STATE.put("02", "订单已合并");
		FY_ORDER_STATE.put("03", "订单已过期");
		FY_ORDER_STATE.put("04", "订单已确认(等待支付)");
		FY_ORDER_STATE.put("05", "订单支付失败");
		FY_ORDER_STATE.put("11", "订单已支付");
		FY_ORDER_STATE.put("18", "已发货");
		FY_ORDER_STATE.put("19", "已确认收货");
		
	}
}
