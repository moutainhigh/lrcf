/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.HxCallback;
import com.lrcf.yhb.pojo.HxOrderInfo;

import java.util.Map;


/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: HuanXunOrderInfoService.java
* @Description: 环迅业务层
* @author:Krx
* @date: 2017年5月9日 下午5:14:00 
*/
public interface HuanXunOrderInfoService {
	
	/**
	 * 发送请求到富友的时候添加数据库
	 * 
	 * @param params
	 */
	void addForRequest(Map<String, String> params);
	
	/**
	 * 发送请求到环迅的时候添加数据库
	 * 
	 * @param params
	 */
	void addForRequests(Map<String, String> params);

	/**
	 * 富友实时返回的时候更新数据库
	 * 
	 * @param returnParam
	 */
	void updateForReturn(Map<String, String> returnParam);

	/**
	 * 环迅实时返回的时候更新数据库
	 * 
	 * @param returnParam
	 */
	void updateForReturns(Map<String, String> returnParam);
	/**
	 * 富友异步通知的时候更新数据库
	 * 
	 * @param returnParam
	 */
	void updateForNotify(Map<String, String> returnParam);

	
	/**
	 * 环迅异步通知的时候更新数据库
	 * 
	 * @param returnParam
	 */
	void updateForNotifys(Map<String, String> returnParam);

	/**
	 * 查询已经成功回调的富友请求<br>
	 * 
	 * @param param
	 *            key reqInfo要判断是否成功回调的请求<br>
	 *            returnSuccess 前台成功回调的标记信息<br>
	 *            notifySuccess 后台成功回调的标记
	 * @return
	 */
	int selectSuccessOrder(Map<String, String> param);
	/**
	 * 插入富友回调信息,用于防止多次回调
	 * 
	 * @param hfCallback
	 * @return
	 */
	void insertHfCallback(HxCallback hfCallback);
	/**
	 * 删除富友回调信息
	 * 
	 * @param param
	 */
	void deleteHfCallback(Map<String, String> param);
	
	/**
	 * 查询订单号
	 * @param param
	 * @return
	 */
	HxOrderInfo selectByMerBill(String param);
	/**
	 * 查询富友商户流水号
	 * @param param
	 * @return
	 */
	HxOrderInfo selectByipsBillNo(Object param);

	void  appUpdateForNotify(Map<String, String> params);
	

}
