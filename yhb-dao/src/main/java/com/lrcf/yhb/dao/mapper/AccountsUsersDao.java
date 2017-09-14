package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountsUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountsUsersDao {

	AccountsUsers selectUserByUserName(String userName);
	
    int deleteByPrimaryKey(@Param("userid") String userid);

    int insert(AccountsUsers record);

    int insertSelective(AccountsUsers record);

    AccountsUsers selectByPrimaryKey(@Param("userid") String userid);

    int updateByPrimaryKeySelective(AccountsUsers record);

    int updateByPrimaryKey(AccountsUsers record);

    List<AccountsUsers> selectUserByCardId(String carId);

    AccountsUsers selectIpsAcctNo(String ipsAcctNo);

}