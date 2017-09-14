package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AdminRaiseSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRaiseSendDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminRaiseSend record);

    int insertSelective(AdminRaiseSend record);

    AdminRaiseSend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminRaiseSend record);

    int updateByPrimaryKey(AdminRaiseSend record);
}