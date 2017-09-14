package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ExperienceuserBuycp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceuserBuycpDao {
    int deleteByPrimaryKey(Integer experienceusercpid);

    int insert(ExperienceuserBuycp record);

    int insertSelective(ExperienceuserBuycp record);

    ExperienceuserBuycp selectByPrimaryKey(Integer experienceusercpid);

    int updateByPrimaryKeySelective(ExperienceuserBuycp record);

    int updateByPrimaryKeyWithBLOBs(ExperienceuserBuycp record);

    int updateByPrimaryKey(ExperienceuserBuycp record);
}