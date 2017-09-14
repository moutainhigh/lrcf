/**
 * 
 */
package com.lrcf.yhb.product.api;


import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.pojo.FinanceproductsAdmin;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: FinanceproductsAdminService.java
 * @Description:后台产品
 * @author:Krx
 * @date: 2017年5月8日 下午3:42:37
 */
public interface FinanceproductsAdminService{

	/**
	 * 
	 * @Description: 主推或者是秒杀产品
	 *
	 * @param:type=1  首页产品  /我要理财
	 * @return：Map<String, Object>
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:53:53
	 */
	YhbResult getMainParo();
	
	/**
	 * 
	 * @Description: 产品
	 *
	 * @param:type=1  首页产品  /我要理财
	 * @return：List<Map<String,Object>>
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:53:53
	 */
	List<Map<String,Object>> getProList();


	/**
	 *
	 * @Description: 产品
	 *
	 * @param:type=1  根据产品Id查询产品信息
	 * @return：FinanceproductsAdmin
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:53:53
	 */
	FinanceproductsAdmin selectProById(Integer id);


	/**
	 *
	 * @Description: 产品
	 *
	 * @param:type=1  根据产品Id查询产品信息
	 * @return：FinanceproductsAdmin
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:53:53
	 */
	Map<String,Object>  getProDeatil(Integer id);


	/**
	 *
	 * @Description: 显示首页配置的产品
	 *
	 * @param:type=1
	 * @return：FinanceproductsAdmin
	 * @author: Krx
	 * @date: 2017年5月8日 下午3:53:53
	 */
	List<Map<String, Object>> getIndexPro();
}
