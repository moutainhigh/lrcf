package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.ExperienceSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExperienceSendDao {
    int deleteByPrimaryKey(Integer experiencesendid);

    int insert(ExperienceSend record);

    int insertSelective(ExperienceSend record);

    List<ExperienceSend> selectExperienceSendList(Map param);

    ExperienceSend selectByPrimaryKey(Integer experiencesendid);

    List<ExperienceSend> getExperience(Map param);

    int countExperienceSend(Map param);

    int updateByPrimaryKeySelective(ExperienceSend record);

    int updateByPrimaryKeyWithBLOBs(ExperienceSend record);

    int updateByPrimaryKey(ExperienceSend record);
}