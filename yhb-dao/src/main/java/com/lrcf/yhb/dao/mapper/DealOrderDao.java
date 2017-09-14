package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.DealOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealOrderDao {
    int deleteByPrimaryKey(String ordernumber);

    int insert(DealOrder record);

    int insertSelective(DealOrder record);

    DealOrder selectByPrimaryKey(String ordernumber);

    int updateByPrimaryKeySelective(DealOrder record);

    int updateByPrimaryKey(DealOrder record);
    
    /**
     * 
    * @Function: DealOrderDao.java
    * @Description: 首页获取投资记录（20条）
    *
    * @param:描述1描述
    * @return：返回结果描述
    * @throws：异常描述
    *
    * @version: v1.0.0
    * @author: wangxf
    * @date: 2017年5月11日 下午1:43:49 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2017年5月11日     wangxf           v1.0.0               修改原因
     */
    List<DealOrder> selectInvestmentRecord();
}