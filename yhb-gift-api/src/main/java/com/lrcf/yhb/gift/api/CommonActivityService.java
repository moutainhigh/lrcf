package com.lrcf.yhb.gift.api;



import com.lrcf.yhb.common.vo.ActivityListVo;

import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: CommonActivityService.java
 * @Description: 公共的活动礼券类
 * @author:Krx
 * @date: 2017年5月16日 上午11:01:06
 */
public interface CommonActivityService {


    /**
     * @Description: 根据UserId, id获取用户活动礼券
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    Map<String, Object> getUserActivity(String userId, Integer id, String... type);


    /**
     * @Description: 我的礼券根据UserId, id获取用户活动礼券
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    Map<String, Object> getMyCoupon(String userId, Integer state, Integer type);


    /**
     * 获取加息劵，体验金，红包数据总数
     *
     * @param: param
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    int getActivityCount(Map<String, Object> param);


    /**
     * 获取加息劵，体验金，红包数据列表
     *
     * @param: param
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    List<ActivityListVo> activityList(Map<String, Object> param);


}
