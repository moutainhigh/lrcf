package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.RaiseBuyPro;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RaiseBuyProDao {
    int deleteByPrimaryKey(Integer raisebuyid);

    int insert(RaiseBuyPro record);

    int insertSelective(RaiseBuyPro record);

    RaiseBuyPro selectByPrimaryKey(Integer raisebuyid);

    int updateByPrimaryKeySelective(RaiseBuyPro record);

    int updateByPrimaryKey(RaiseBuyPro record);
}