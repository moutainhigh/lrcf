package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.LogMoneyChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMoneyChangeDao {
    int deleteByPrimaryKey(Integer moneychangeid);

    int insert(LogMoneyChange record);

    int insertSelective(LogMoneyChange record);

    LogMoneyChange selectByPrimaryKey(Integer moneychangeid);

    int updateByPrimaryKeySelective(LogMoneyChange record);

    int updateByPrimaryKeyWithBLOBs(LogMoneyChange record);

    int updateByPrimaryKey(LogMoneyChange record);
}