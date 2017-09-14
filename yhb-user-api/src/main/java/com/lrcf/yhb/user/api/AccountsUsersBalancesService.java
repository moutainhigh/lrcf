/**
 * 
 */
package com.lrcf.yhb.user.api;

import com.lrcf.yhb.pojo.AccountsUsersBalances;

import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 * 
 * @ClassName: AccountsUsersBalancesService.java
 * @Description: 用户余额
 * @author:Krx
 * @date: 2017年5月11日 上午10:04:40
 */
public interface AccountsUsersBalancesService {

	/**
	 * 
	 * @Description: 更新用户余额
	 *
	 * @param: Map集合
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月11日 上午10:05:37
	 */
	boolean updateUserBalance(Map<String, String> param);
	
	
	/**
	 * 
	 * @Description: 更新用户余额
	 *
	 * @param: 余额实体类
	 * @return：boolean
	 * @author: Krx
	 * @date: 2017年5月11日 上午10:05:37
	 */
	boolean updateUserBalance(AccountsUsersBalances userBalance);

	/**
	 * 
	 * @Description: 根据userId查询用户余额
	 *
	 * @param: userId
	 * @return：AccountsUsersBalances
	 * @author: Krx
	 * @date: 2017年5月11日 上午10:05:37
	 */
	AccountsUsersBalances selectByUserId(String userId);
}
