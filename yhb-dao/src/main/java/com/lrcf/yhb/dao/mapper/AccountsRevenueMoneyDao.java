package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountsRevenueMoney;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountsRevenueMoneyDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AccountsRevenueMoney record);

    int insertSelective(AccountsRevenueMoney record);

    int revenueMoneyCount(Map param);

    List<AccountsRevenueMoney> revenueMoneyList(Map param);

    AccountsRevenueMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountsRevenueMoney record);

    int updateByPrimaryKey(AccountsRevenueMoney record);
}