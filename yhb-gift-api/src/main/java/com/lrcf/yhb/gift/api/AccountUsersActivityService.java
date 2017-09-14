/**
 *
 */
package com.lrcf.yhb.gift.api;


import com.lrcf.yhb.pojo.AccountUsersActivity;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: AccountUsersActivityService.java
 * @Description: 用户红包
 * @author:Krx
 * @date: 2017年5月16日 上午11:02:29
 */
public interface AccountUsersActivityService {


    /**
     *
     * @Description: 根据UserId,type,productId获取红包
     *
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    List<AccountUsersActivity> getUserRed(String userId, Integer id, String... type);

    /***
     * 获取红包的总数
     * @param param
     * @return
     */
    int getUserRedCount(Map<String, Object> param);

    /***
     * 获取红包的列表
     * @param param
     * @return
     */
    List<AccountUsersActivity> getUserRedList(Map<String, Object> param);
}
