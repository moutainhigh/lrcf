package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.StatisticsOrder;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
public interface StatisticsOrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StatisticsOrder record);

    int insertSelective(StatisticsOrder record);

    StatisticsOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatisticsOrder record);

    int updateByPrimaryKey(StatisticsOrder record);

    int deleteFromTable();
    List<StatisticsOrder> selectAll();
    
}
