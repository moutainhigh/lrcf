package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountsUsersBalances;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountsUsersBalancesDao {
    int deleteByPrimaryKey(@Param("balanceid") Integer balanceid, @Param("userid") String userid);

    int insert(AccountsUsersBalances record);

    int insertSelective(AccountsUsersBalances record);

    AccountsUsersBalances selectByUserId(String userId);
    
    AccountsUsersBalances selectByPrimaryKey(@Param("balanceid") Integer balanceid, @Param("userid") String userid);

    int updateByPrimaryKeySelective(AccountsUsersBalances record);

    int updateByPrimaryKey(AccountsUsersBalances record);
}