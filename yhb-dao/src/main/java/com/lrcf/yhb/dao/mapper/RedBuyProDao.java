package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.RedBuyPro;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedBuyProDao {
    int deleteByPrimaryKey(Integer redbuyid);

    int insert(RedBuyPro record);

    int insertSelective(RedBuyPro record);

    RedBuyPro selectByPrimaryKey(Integer redbuyid);

    int updateByPrimaryKeySelective(RedBuyPro record);

    int updateByPrimaryKey(RedBuyPro record);
}