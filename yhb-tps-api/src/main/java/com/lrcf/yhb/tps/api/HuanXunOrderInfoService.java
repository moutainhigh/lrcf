package com.lrcf.yhb.tps.api;

import com.lrcf.yhb.pojo.HxCallback;
import com.lrcf.yhb.pojo.HxOrderInfo;

import java.util.Map;





public interface HuanXunOrderInfoService {
	
	/**
	 * 发送请求到环迅的时候添加数据库
	 * 
	 * @param params
	 */
	void addForRequests(Map<String, String> params);

	/**
	 * 环迅实时返回的时候更新数据库
	 * 
	 * @param -params
	 */
	void updateForReturns(Map<String, String> returnParam);
	
	/**
	 * 环迅异步通知的时候更新数据库
	 * 
	 * @param returnParam
	 */
	void updateForNotifys(Map<String, String> returnParam);

	/**
	 * 查询已经成功环迅请求<br>
	 * 
	 * @param param
	 *            key reqInfo要判断是否成功回调的请求<br>
	 *            returnSuccess 前台成功回调的标记信息<br>
	 *            notifySuccess 后台成功回调的标记
	 * @return
	 */
	int selectSuccessOrder(Map<String, String> param);
	/**
	 * 插入环迅回调信息,用于防止多次回调
	 * 
	 * @param hfCallback
	 * @return
	 */
	void insertHfCallback(HxCallback hfCallback);
	/**
	 * 删除环迅回调信息
	 * 
	 * @param-HxCallback
	 */
	void deleteHfCallback(Map<String, String> param);
	
//	List<HuanXunWithBLOBs> getHuifuOrderInfoList(Map<String, String> param);
	/**
	 * 查询订单号
	 * @param merBillNo
	 * @return
	 */
	HxOrderInfo selectByMerBill(String merBillNo);
	/**
	 * 查询环迅商户流水号
	 * @param param
	 * @return
	 */
	HxOrderInfo selectByipsBillNo(Object param);

	void  appUpdateForNotify(Map<String, String> params);
}
