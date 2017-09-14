package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountChangeinfo;

import java.util.List;
import java.util.Map;

public interface AccountChangeinfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AccountChangeinfo record);

    int insertSelective(AccountChangeinfo record);

    AccountChangeinfo selectByPrimaryKey(Integer id);

    List<AccountChangeinfo> userCurrentRecord(Map param);

    int userCurrentRecordCount(Map param);

    int updateByPrimaryKeySelective(AccountChangeinfo record);

    int updateByPrimaryKey(AccountChangeinfo record);
}