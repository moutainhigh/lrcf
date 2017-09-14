package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.HxCallback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HxCallbackDao {
    int deleteByPrimaryKey(Integer id);

    int insert(HxCallback record);

    int insertSelective(HxCallback record);

    HxCallback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HxCallback record);

    int updateByPrimaryKeyWithBLOBs(HxCallback record);

    int updateByPrimaryKey(HxCallback record);
}