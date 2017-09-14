package com.lrcf.yhb.product.api;

import com.lrcf.yhb.pojo.DailyRevenue;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: DailyRevenueService.java
 * @Description:活期宝利率
 * @author:Krx
 * @date: 2017年5月9日 下午1:40:05
 */
public interface DailyRevenueService {


    /**
     *
     * @Description: 获取平台上活期宝的利率
     *
     * @param:param
     * @return：返回 DailyRevenue
     * @author: Krx
     * @date: 2017年5月12日 下午1:17:57
     */
    DailyRevenue getDailyRevenue();

}
