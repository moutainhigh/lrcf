package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.SystemLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKeyWithBLOBs(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}