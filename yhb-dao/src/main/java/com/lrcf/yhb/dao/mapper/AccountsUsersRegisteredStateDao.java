package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountsUsersRegisteredState;

public interface AccountsUsersRegisteredStateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountsUsersRegisteredState record);

    int insertSelective(AccountsUsersRegisteredState record);

    AccountsUsersRegisteredState selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountsUsersRegisteredState record);

    int updateByPrimaryKey(AccountsUsersRegisteredState record);
}