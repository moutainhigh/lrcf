package com.lrcf.yhb.dao.mapper;

import com.lrcf.yhb.pojo.BaseBankcard;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseBankcardDao {
    int deleteByPrimaryKey(Integer bankcardid);

    int insert(BaseBankcard record);

    int insertSelective(BaseBankcard record);

    BaseBankcard selectByPrimaryKey(Integer bankcardid);

    int updateByPrimaryKeySelective(BaseBankcard record);

    int updateByPrimaryKeyWithBLOBs(BaseBankcard record);

    int updateByPrimaryKey(BaseBankcard record);

    /**
     *
     * @Function: BaseBankcardDao.java
     * @Description: 根据userId查询银行卡信息:加密
     *
     * @param: userId
     * @return：BaseBankcard
     * @throws：
     *
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月13日 下午2:00:53
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2017年5月13日     wangxf           v1.0.0               修改原因
     */
    BaseBankcard selectForMd5ByUserId(String userId);

    /**
     * 根据userId/bankNumber查询银行卡查询信息
     * @param param
     * @return
     */
    BaseBankcard selectBankByParam(Map param);
}