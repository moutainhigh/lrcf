package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.FinanceproductsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceproductsAdminDao {
    int deleteByPrimaryKey(Integer fpid);

    int insert(FinanceproductsAdmin record);

    int insertSelective(FinanceproductsAdmin record);

    FinanceproductsAdmin selectByPrimaryKey(Integer fpid);
    
    List<FinanceproductsAdmin> getIndexPro();

    int updateByPrimaryKeySelective(FinanceproductsAdmin record);

    int updateByPrimaryKeyWithBLOBs(FinanceproductsAdmin record);

    int updateByPrimaryKey(FinanceproductsAdmin record);
}