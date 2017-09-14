/**
 * 
 */
package com.lrcf.yhb.user.service;

import com.lrcf.yhb.dao.mapper.ProfitTableDao;
import com.lrcf.yhb.pojo.ProfitTable;
import com.lrcf.yhb.user.api.ProfitTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: ProfitTableServiceImpl.java
* @Description: 金额静态
* @author:Krx
* @date: 2017年5月12日 上午9:34:59 
*/
@Service("profitTableService")
public class ProfitTableServiceImpl implements ProfitTableService {
	
	@Autowired
	ProfitTableDao profitTableDao;


	/** 
	* @Function: ProfitTableServiceImpl.java
	* @Description: 获取用户的昨日收益和累计收益
	*
	* @param:userId
	* @return：Map
	* @author: Krx
	* @date: 2017年5月12日 上午9:35:07
	*/
	@Override
	public Map<String, Object> getUserIncomeAnd(String userId) {
		Map<String, Object>  userIncomeMap = profitTableDao.selectUserIncome(userId);
		if(userIncomeMap != null && userIncomeMap.size()>0){
		   return userIncomeMap;
		}

		return null;
	}

	/**
	 * @Function: ProfitTableServiceImpl.java
	 * @Description: 根据UserId查询出用户收益
	 *
	 * @param:userId
	 * @return：Map
	 * @author: Krx
	 * @date: 2017年5月12日 上午9:35:07
	 */
	@Override
	public ProfitTable getProfitByUserId(String userId) {
		return profitTableDao.selectByuserId(userId);
	}

}
