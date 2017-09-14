package com.lrcf.yhb.user.api;


import com.lrcf.yhb.pojo.UsersBankCardErrorinfo;

import java.util.Map;

/**
 * Created by wangxf on 2017/5/18.
 */
public interface UsersBankCardErrorinfoService {

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
    Integer getErrorInfoCount(Map<String, String> paramMap);

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
    Integer saveBankErrorInfo(UsersBankCardErrorinfo bankCardErrorinfo);
}

