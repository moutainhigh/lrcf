/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.DealOrder;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: DealOrderService.java
 * @Description:订单
 * @author:Krx
 * @date: 2017年5月9日 下午1:40:05
 */
public interface DealOrderService {

	/**
	 *
	 * @Description: 插入充值订单
	 *
	 * @param:Map
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月9日 下午1:41:22
	 */
	boolean insertDealOrder(Map<String, String> param);

	/**
	 * @Description: 更新充值订单
	 *
	 * @param:dealOrder
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月9日 下午1:41:22
	 */
	boolean updateDealOrder(DealOrder dealOrder);

	/**
	 *
	 * @Description: 根据订单单号查询订单信息
	 *
	 * @param:orderNumber
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月9日 下午1:41:22
	 */
	DealOrder selectOrderByOrderNumber(String orderNumber);

	/**
	 * 
	 * @Function: DealOrderService.java
	 * @Description: 获取投资记录信息
	 *
	 * 				@return： List<DealOrder> @throws：
	 *
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月11日 上午10:12:15
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------*
	 *        2017年5月11日 wangxf v1.0.0 修改原因
	 */
	List<DealOrder> selectInvestmentRecord();
}
