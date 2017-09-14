package com.lrcf.yhb.gift.api;

import com.lrcf.yhb.pojo.ActivityManagement;

import java.util.List;

/**
 * 热门活动
 * Created by Administrator on 2017/6/16.
 */

public interface ActivityService {

    /**
     * 获取所有活动列表
     * @return
     */
    List<ActivityManagement> getActivityList();
}
