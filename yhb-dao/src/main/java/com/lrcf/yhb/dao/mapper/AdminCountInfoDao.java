package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.AdminCountInfo;
import org.omg.CORBA.INTERNAL;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface AdminCountInfoDao {

    BigDecimal getSunInMoney(Map params);
    BigDecimal getSunOutMoney(Map params);
    BigDecimal getSunDongJieMoney(Map params);
    Integer getCountRegister(Map params);
    Integer getCountCard(Map params);

    List<AdminCountInfo> allBuyProducts(Map map);
    List<AdminCountInfo> allExpireProducts(Map map);
    List<AdminCountInfo> allInMoney(Map map);
    List<AdminCountInfo> allWithdraw(Map map);
    List<AdminCountInfo> allRegister(Map map);
}
