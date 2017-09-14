package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.FinanceproductsExtract;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FinanceproductsExtractDao {
    int deleteByPrimaryKey(Integer fpeid);

    int insert(FinanceproductsExtract record);

    int insertSelective(FinanceproductsExtract record);
    //获取转出产品数据数
    int getOutProductCount(Map<String, Object> param);
    //获取转出产品列表
   // List<UserOutProductList> getOutProductList(Map param);

    FinanceproductsExtract selectByPrimaryKey(Integer fpeid);

    int updateByPrimaryKeySelective(FinanceproductsExtract record);

    int updateByPrimaryKey(FinanceproductsExtract record);
}