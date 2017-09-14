package com.lrcf.yhb.user.service;

import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.dao.mapper.UsersBankCardErrorinfoDao;
import com.lrcf.yhb.pojo.UsersBankCardErrorinfo;
import com.lrcf.yhb.user.api.UsersBankCardErrorinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxf on 2017/5/18.
 */
@Service("usersBankCardErrorinfoService")
public class UsersBankCardErrorinfoServiceImpl implements UsersBankCardErrorinfoService {

    @Autowired
    UsersBankCardErrorinfoDao usersBankCardErrorinfoDao;
    /**
     *
     * @Function: UsersBankCardErrorinfoService.java
     * @Description: 获取用户绑卡的错误次数
     *
     * @param:
     * @return：
     * @throws：
     *
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月13日 下午3:33:53
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2017年5月13日     wangxf           v1.0.0               修改原因
     */
    @Override
    public Integer getErrorInfoCount(Map<String,String> paramMap){

        int errorNum = 0;
        if( null != paramMap && paramMap.size() > 0
                && StringUtil.isNotBlank(paramMap.get("userId"))
                && StringUtil.isNotBlank(paramMap.get("today")) ){

            List<UsersBankCardErrorinfo> errorinfoList = usersBankCardErrorinfoDao.selectByUserIdAndToday(paramMap);

            if( null != errorinfoList ){
                errorNum = errorinfoList.size();
            }
        }
        return errorNum;
    }

    /**
     *
     * @Function: UsersBankCardErrorinfoService.java
     * @Description: 保存绑卡时的错误信息
     *
     * @param: bankCardErrorinfo
     * @return： Integer
     * @throws：
     *
     * @version: v1.0.0
     * @author: wangxf
     * @date: 2017年5月13日 下午3:33:53
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2017年5月13日     wangxf           v1.0.0               修改原因
     */
    @Override
    public Integer saveBankErrorInfo(UsersBankCardErrorinfo bankCardErrorinfo){

        Integer i = null;
        if( null != bankCardErrorinfo ){
            i = usersBankCardErrorinfoDao.insert(bankCardErrorinfo);
        }
        return i;
    }
}
