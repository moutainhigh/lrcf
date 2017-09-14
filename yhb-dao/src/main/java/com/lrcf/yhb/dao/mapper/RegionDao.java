package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.Region;

import java.util.List;

public interface RegionDao {
    int deleteByPrimaryKey(Double regionId);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Double regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    List<Region> selectByParentId(Double parentId);

    List<Region> selectByLevel(Integer level);
}