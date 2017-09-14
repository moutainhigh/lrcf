package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.HxOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HxOrderInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(HxOrderInfo record);

    int insertSelective(HxOrderInfo record);

    HxOrderInfo selectByPrimaryKey(Integer id);
    
    HxOrderInfo selectByMerBill(String m);
    
    HxOrderInfo selectByipsBill(Object param);

    int updateByPrimaryKeySelective(HxOrderInfo record);

    int updateByPrimaryKeyWithBLOBs(HxOrderInfo record);

    int updateByPrimaryKey(HxOrderInfo record);
}