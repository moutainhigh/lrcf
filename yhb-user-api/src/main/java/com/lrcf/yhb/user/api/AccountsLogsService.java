package com.lrcf.yhb.user.api;

import com.lrcf.yhb.pojo.AccountsLogs;

public interface AccountsLogsService {
	/**
	 * 添加日志
	 * @param accountsLogs
	 * @return
	 */
	boolean  saveUserLog(AccountsLogs accountsLogs);

}
