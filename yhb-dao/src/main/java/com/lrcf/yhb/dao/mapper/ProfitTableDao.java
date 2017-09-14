package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ProfitTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProfitTableDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfitTable record);

    int insertSelective(ProfitTable record);

    ProfitTable selectByPrimaryKey(Integer id);
    //获取用户昨日和累计收益
    Map<String,Object> selectUserIncome(String userId);

    int updateByPrimaryKeySelective(ProfitTable record);

    int updateByPrimaryKey(ProfitTable record);

    ProfitTable selectByuserId(String userId);
}