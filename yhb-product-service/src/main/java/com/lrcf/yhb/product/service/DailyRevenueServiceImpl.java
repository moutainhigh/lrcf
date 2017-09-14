package com.lrcf.yhb.product.service;


import com.lrcf.yhb.dao.mapper.DailyRevenueDao;
import com.lrcf.yhb.pojo.DailyRevenue;
import com.lrcf.yhb.product.api.DailyRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: DailyRevenueService.java
 * @Description:活期宝利率实现类
 * @author:Krx
 * @date: 2017年5月9日 下午1:40:05
 */
@Service("dailyRevenueService")
public class DailyRevenueServiceImpl  implements DailyRevenueService {


    @Autowired
    DailyRevenueDao dailyRevenueDao;


    /**
     * Copyright: Copyright (c) 2017 LanRu-Caifu
     *
     * @ClassName: DailyRevenueService.java
     * @Description:获取活期宝利率
     * @author:Krx
     * @date: 2017年5月9日 下午1:40:05
     */
    @Override
    public DailyRevenue getDailyRevenue() {
        return dailyRevenueDao.selectByPrimaryKey(1);
    }
}
