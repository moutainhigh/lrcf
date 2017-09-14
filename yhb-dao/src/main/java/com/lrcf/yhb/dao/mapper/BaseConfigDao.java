package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.BaseConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseConfig record);

    int insertSelective(BaseConfig record);

    BaseConfig selectByParam(String param);
    
    List<BaseConfig> getAllbase();

    BaseConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseConfig record);

    int updateByPrimaryKey(BaseConfig record);
}