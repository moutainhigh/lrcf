package com.lrcf.yhb.user.service;

import com.lrcf.yhb.dao.mapper.AccountsLogsDao;
import com.lrcf.yhb.pojo.AccountsLogs;
import com.lrcf.yhb.user.api.AccountsLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("accountsLogsService")
public class AccountsLogsServiceImpl implements AccountsLogsService {

	@Autowired
	private AccountsLogsDao accountsLogsDao;

	@Override
	public boolean saveUserLog(AccountsLogs accountsLogs) {

		return this.accountsLogsDao.insertSelective(accountsLogs);
	}

}
