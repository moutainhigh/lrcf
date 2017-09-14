package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.FinanceproductsUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FinanceproductsUsersDao {

    int deleteByPrimaryKey(Integer fpuid);

    int insert(FinanceproductsUsers record);

    int insertSelective(FinanceproductsUsers record);
    
    int getCountUserByFPid(Integer FPid);

    //获取用户持有中或已结束数据总数
    int getProductCountByParam(Map<String, Object> param);
    //获取用户持有中或已结束列表
   // List<UserBuyProductList> getUserBuyProductList(Map param);
    FinanceproductsUsers selectByPrimaryKey(Integer fpuid);

    List<FinanceproductsUsers> getUserInvestmentRecords(Integer id);

    int updateByPrimaryKeySelective(FinanceproductsUsers record);

    int updateByPrimaryKeyWithBLOBs(FinanceproductsUsers record);

    int updateByPrimaryKey(FinanceproductsUsers record);
}