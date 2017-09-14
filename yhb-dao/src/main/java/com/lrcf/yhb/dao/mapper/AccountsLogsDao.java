package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountsLogs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountsLogsDao {

    int deleteByPrimaryKey(Integer logid);

    boolean insert(AccountsLogs record);

    boolean insertSelective(AccountsLogs record);

    AccountsLogs selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(AccountsLogs record);

    int updateByPrimaryKey(AccountsLogs record);
}