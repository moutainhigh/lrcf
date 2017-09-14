package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountUsersActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountUsersActivityDao {
    int deleteByPrimaryKey(Integer redid);

    int insert(AccountUsersActivity record);

    int insertSelective(AccountUsersActivity record);

    List<AccountUsersActivity> selectUserRedList(Map param);

    List<AccountUsersActivity> selectRedByUserIdAndStateAndFpid(Map param);

    int countAccountUsersActivity(Map param);

    AccountUsersActivity selectByPrimaryKey(Integer redid);

    int updateByPrimaryKeySelective(AccountUsersActivity record);

    int updateByPrimaryKey(AccountUsersActivity record);
}