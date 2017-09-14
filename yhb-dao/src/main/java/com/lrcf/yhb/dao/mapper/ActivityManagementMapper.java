package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ActivityManagement;

import java.util.List;

public interface ActivityManagementMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(ActivityManagement record);


    ActivityManagement selectByPrimaryKey(Integer id);


    List<ActivityManagement> selectAll();


    int updateByPrimaryKey(ActivityManagement record);
}