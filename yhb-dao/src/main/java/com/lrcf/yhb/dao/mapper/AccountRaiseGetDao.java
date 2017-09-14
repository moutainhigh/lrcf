package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountRaiseGet;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountRaiseGetDao {

    int deleteByPrimaryKey(Integer raiseid);

    int insert(AccountRaiseGet record);

    int insertSelective(AccountRaiseGet record);

    List<AccountRaiseGet> selectRaiseList(Map param);
    List<AccountRaiseGet> selectRaiseByUserIdAndStateAndProId(Map param);

    int countAccountRaiseGet(Map param);

    AccountRaiseGet selectByPrimaryKey(Integer raiseid);

    int updateByPrimaryKeySelective(AccountRaiseGet record);

    int updateByPrimaryKey(AccountRaiseGet record);
}