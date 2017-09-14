package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.UsersBankCardErrorinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UsersBankCardErrorinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersBankCardErrorinfo record);

    int insertSelective(UsersBankCardErrorinfo record);

    UsersBankCardErrorinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersBankCardErrorinfo record);

    int updateByPrimaryKey(UsersBankCardErrorinfo record);

    List<UsersBankCardErrorinfo> selectByUserIdAndToday(Map<String, String> paramMap);
}