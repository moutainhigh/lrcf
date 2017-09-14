package com.lrcf.yhb.user.api;

import java.util.Map;


public interface FySendService {
    /**
     * 充值
     * @param param
     * @return
     * @throws Exception
     */
	Map<String, String> smpGate(Map<String, String> param) throws Exception;
	
	/**
	 * 查询
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Map<String, String> smpQueryGate(Map<String, String> param) throws Exception;

	/**
	 * 查询支付结果
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Map<String,String> smpAQueryGate(Map<String, String> param)throws Exception;
	
	
	/******************************app端*************************************/
	/**
	 * 查询银行卡是否支持
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Map<String,String> cardBinQuery(Map<String, String> param) throws Exception;
	
	/**
	 * 限额查询接口
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Map<String,String> lmtQueryAction(Map<String, String> param) throws Exception;
	
	/**
	 * 商户订单结果查询接口
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Map<String,String> queryOrderId(Map<String, String> param) throws Exception;
	
	/**
	 * H5充值界面
	 * @return
	 * @throws Exception
	 */
	Map<String,String> payAction(Map<String, String> param) throws Exception;
	
}
