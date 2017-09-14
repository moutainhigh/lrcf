package com.lrcf.yhb.gift.service;

import com.lrcf.yhb.gift.api.ActivityService;
import com.lrcf.yhb.dao.mapper.ActivityManagementMapper;
import com.lrcf.yhb.pojo.ActivityManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityManagementMapper activityManagementMapper;

    @Override
    public List<ActivityManagement> getActivityList() {
        return activityManagementMapper.selectAll();
    }
}
