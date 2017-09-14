package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.BlackList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlackListDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BlackList record);

    boolean insertSelective(BlackList record);

    BlackList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlackList record);

    int updateByPrimaryKey(BlackList record);

    List<BlackList> selectByPhone(String phone);

    BlackList selectBlackByUserId(String userId);



}