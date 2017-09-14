package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.BannerManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerManageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BannerManage record);

    int insertSelective(BannerManage record);

    BannerManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BannerManage record);

    int updateByPrimaryKey(BannerManage record);

    List<BannerManage> selectBannerByType(Integer type);
}