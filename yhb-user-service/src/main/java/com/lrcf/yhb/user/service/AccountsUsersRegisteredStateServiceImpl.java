package com.lrcf.yhb.user.service;

import com.lrcf.yhb.dao.mapper.AccountsUsersRegisteredStateDao;
import com.lrcf.yhb.pojo.AccountsUsersRegisteredState;
import com.lrcf.yhb.user.api.AccountsUsersRegisteredStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("accountsUsersRegisteredStateService")
public class AccountsUsersRegisteredStateServiceImpl implements AccountsUsersRegisteredStateService {
	@Autowired
	private AccountsUsersRegisteredStateDao accountsUsersRegisteredStateDao;

	@Override
	public boolean addAccountsUsersRegisteredState(AccountsUsersRegisteredState accountsUsersRegisteredState) {
		int insert = this.accountsUsersRegisteredStateDao.insert(accountsUsersRegisteredState);
		return insert == 1?true:false;
	}

}
