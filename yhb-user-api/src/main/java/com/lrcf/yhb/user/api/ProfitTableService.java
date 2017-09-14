/**
 * 
 */
package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.ProfitTable;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: ProfitTableService.java
 * @Description: 金额收益静态字段
 * @author:Krx
 * @date: 2017年5月12日 上午9:32:34
 */
public interface ProfitTableService {

	/**
	 * 
	 * @Description: 昨日收益和累计收益（总和）
	 *
	 * @param:userId
	 * @return：Map
	 * @author: Krx
	 * @date: 2017年5月12日 上午9:34:32
	 */
	Map<String, Object> getUserIncomeAnd(String userId);


	/**
	 *
	 * @Description: 根据UserId查询出用户收益
	 *
	 * @param:userId
	 * @return：Map
	 * @author: Krx
	 * @date: 2017年5月12日 上午9:34:32
	 */
	ProfitTable getProfitByUserId(String userId);
}
