package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AccountsCenterMeassage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountsCenterMeassageDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AccountsCenterMeassage record);

    int insertSelective(AccountsCenterMeassage record);

    List<AccountsCenterMeassage> getUserMessageVO(Map param);

    AccountsCenterMeassage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountsCenterMeassage record);

    int updateByPrimaryKey(AccountsCenterMeassage record);

    int selectByUserId(String userId);
}