/**
 * 
 */
package com.lrcf.yhb.product.api;


import com.lrcf.yhb.common.vo.UserBuyProductList;
import com.lrcf.yhb.common.vo.UserInvestRecordListVo;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.FinanceproductsUsers;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: FinanceproductsUsersService.java
 * @Description: 用户产品信息
 * @author:Krx
 * @date: 2017年5月12日 上午9:51:52
 */
public interface FinanceproductsUsersService {

	/**
	 * 
	 * @Description: 获取用户产品资产
	 *
	 * @param: param
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年5月12日 上午9:52:43
	 */
	List<UserBuyProductList> getFinUserList(Map<String, Object> param);

	/**
	 *
	 * @Description: 获取用户产品资产总数据记录数
	 *
	 * @param: param
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年5月12日 上午9:52:43
	 */
	int getProductCount(Map<String, Object> param);

	/**
	 *
	 * @Description: 获取用户投资记录
	 *
	 * @param: Id
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年5月12日 上午9:52:43
	 */
	List<UserInvestRecordListVo> getUserInvestmentRecords(Integer id);

	/**
	 *
	 * @Description: 购买产品
	 *
	 * @param:
	 * @return：返回结果描述
	 * @author: Administrator
	 * @date: 2017年5月12日 上午9:52:43
	 */
	Map<String,Object> buyPro(Map<String, String> param);


	/**
	 * 根据购买产品的唯一订单Id删除订单账号
	 * @param fpuid
	 * @return
	 */
	boolean deleteProduct(String fpuid);


	YhbResult test();
}
