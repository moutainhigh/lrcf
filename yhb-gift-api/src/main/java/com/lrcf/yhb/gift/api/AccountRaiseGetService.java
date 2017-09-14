/**
 * 
 */
package com.lrcf.yhb.gift.api;

import com.lrcf.yhb.pojo.AccountRaiseGet;

import java.util.List;
import java.util.Map;

/**
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: AccountRaiseGetService.java
* @Description: 用户加息劵
* @author:Krx
* @date: 2017年5月16日 上午11:01:06 
*/
public interface AccountRaiseGetService {
    /**
     *
     * @Description: 根据UserId,type,productId获取加息劵
     *
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    List<AccountRaiseGet> getUserRaise(String userId, Integer id, String... type);

    /**
     *
     * @Description: 根据param获取加息劵记录总数
     *
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    int getUserRaiseCount(Map<String, Object> param);

    /**
     *
     * @Description: 根据param获取加息劵列表
     *
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    List<AccountRaiseGet> getUserRaiseList(Map<String, Object> param);
}
