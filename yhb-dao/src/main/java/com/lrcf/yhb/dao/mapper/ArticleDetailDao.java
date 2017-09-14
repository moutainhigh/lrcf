package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ArticleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleDetail record);

    int insertSelective(ArticleDetail record);

    List<ArticleDetail> selectNewsDetail(Map param);

    List<ArticleDetail> getNewsOrNoticeList(Map param);

    ArticleDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleDetail record);

    int updateByPrimaryKeyWithBLOBs(ArticleDetail record);

    int updateByPrimaryKey(ArticleDetail record);

    int getNoticeOrNewsCount(Integer type);

    List<ArticleDetail>  selectNewsByTypeAndOrder(Map param);
}