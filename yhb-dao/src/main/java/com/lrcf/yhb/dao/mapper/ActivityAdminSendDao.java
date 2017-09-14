package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ActivityAdminSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityAdminSendDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityAdminSend record);

    int insertSelective(ActivityAdminSend record);

    ActivityAdminSend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityAdminSend record);

    int updateByPrimaryKey(ActivityAdminSend record);
}