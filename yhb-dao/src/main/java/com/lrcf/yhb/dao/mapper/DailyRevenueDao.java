package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.DailyRevenue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyRevenueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyRevenue record);

    int insertSelective(DailyRevenue record);

    DailyRevenue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyRevenue record);

    int updateByPrimaryKey(DailyRevenue record);

}