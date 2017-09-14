package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ExperienceCP;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceCPDao {
    int deleteByPrimaryKey(Integer experiencecpid);

    int insert(ExperienceCP record);

    int insertSelective(ExperienceCP record);

    ExperienceCP selectByPrimaryKey(Integer experiencecpid);

    int updateByPrimaryKeySelective(ExperienceCP record);

    int updateByPrimaryKeyWithBLOBs(ExperienceCP record);

    int updateByPrimaryKey(ExperienceCP record);
}