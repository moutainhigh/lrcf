/**
 * 
 */
package com.lrcf.yhb.user.service;


import com.lrcf.yhb.dao.mapper.AccountsUsersBalancesDao;
import com.lrcf.yhb.pojo.AccountsUsersBalances;
import com.lrcf.yhb.user.api.AccountsUsersBalancesService;
import com.lrcf.yhb.user.api.AccountsUsersService;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;

/**   
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: AccountsUsersBalancesServiceImpl.java
* @Description: 用户余额
* @author:Krx
* @date: 2017年5月11日 上午10:06:20 
*/
@Service("accountsUsersBalancesService")
public class AccountsUsersBalancesServiceImpl implements AccountsUsersBalancesService {

	@Autowired
	AccountsUsersService accountsUsersService;
	@Autowired
	AccountsUsersBalancesDao accountsUsersBalancesDao;
	/** 
	* @see AccountsUsersBalancesService#selectByUserId(String)
	* @Function: AccountsUsersBalancesServiceImpl.java
	* @Description: 查询用户余额
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @author: Krx
	* @date: 2017年5月11日 下午2:23:19
	*/
	@Override
	public AccountsUsersBalances selectByUserId(String userId) {
		AccountsUsersBalances usersBalances = accountsUsersBalancesDao.selectByUserId(userId);
		return accountsUsersBalancesDao.selectByUserId(userId);
	}

	/**
	* @see AccountsUsersBalancesService#updateUserBalance(Map)
	* @Function: AccountsUsersBalancesServiceImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述、
	* @return：返回结果描述
	* @author: Krx
	* @date: 2017年5月11日 下午2:28:23
	*/
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateUserBalance(Map<String, String> param) {
		AccountsUsersBalances usersBalances =  selectByUserId(param.get("userId"));
//		AccountsUsersBalances usersBalances =  selectByUserId("0ED1BA21-8DD1-40CF-B4A0-E25E3FD22312");
		if(usersBalances == null){
			return false;
		}

		BigDecimal buyMoney = new BigDecimal(param.get("money"));
		if (usersBalances.getUserbalance().compareTo(buyMoney) < 0) {
			return false;
		}

		usersBalances.setUsercurrent(buyMoney);
		usersBalances.setUserbalance(usersBalances.getUserbalance().subtract(buyMoney));
		accountsUsersBalancesDao.updateByPrimaryKeySelective(usersBalances);
		return true;
	}

	/** 
	* @Function: AccountsUsersBalancesServiceImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @author: Krx
	* @date: 2017年5月11日 下午2:28:23 
	*/
	@Override
	public boolean updateUserBalance(AccountsUsersBalances userBalance) {
		if(accountsUsersBalancesDao.updateByPrimaryKeySelective(userBalance)>0){
			return true;
		}
		return false;
	}

}
