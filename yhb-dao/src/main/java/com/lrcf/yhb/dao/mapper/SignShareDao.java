package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.SignShare;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignShareDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SignShare record);

    int insertSelective(SignShare record);

    SignShare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SignShare record);

    int updateByPrimaryKey(SignShare record);
}