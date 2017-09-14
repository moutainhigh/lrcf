package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.DealCheck;

import java.util.List;

public interface DealCheckDao {

    int deleteByPrimaryKey(String checkid);

    int insert(DealCheck record);

    int insertSelective(DealCheck record);

    DealCheck selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(DealCheck record);

    int updateByPrimaryKey(DealCheck record);
}