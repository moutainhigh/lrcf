package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.BaseNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseNewsDao {
    int deleteByPrimaryKey(Integer newsid);

    int insert(BaseNews record);

    int insertSelective(BaseNews record);

    BaseNews getIndexNotice();

    BaseNews selectByPrimaryKey(Integer newsid);

    int updateByPrimaryKeySelective(BaseNews record);

    int updateByPrimaryKeyWithBLOBs(BaseNews record);

    int updateByPrimaryKey(BaseNews record);
}