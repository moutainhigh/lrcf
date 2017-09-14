package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.BaseInterfaceBank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseInterfaceBankDao {
    int insert(BaseInterfaceBank record);

    int insertSelective(BaseInterfaceBank record);
    
    BaseInterfaceBank selectBankNumByBankCode(String bankCode);

    BaseInterfaceBank selectBankInfoForUserId(String userId);

    List<BaseInterfaceBank> selectAll();
}