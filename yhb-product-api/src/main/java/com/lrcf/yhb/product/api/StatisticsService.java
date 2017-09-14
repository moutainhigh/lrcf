package com.lrcf.yhb.product.api;

import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dto.S_BuyProductsDto;
import com.lrcf.yhb.pojo.StatisticsOrder;

import java.util.Map;

/**
 * Created by CZY on 2017/7/12.
 */
public interface StatisticsService {

    YhbResult  statistics (S_BuyProductsDto s_buyProductsDto);

    YhbResult buyFinanceProducts(S_BuyProductsDto s_buyProductsDto);

    YhbResult buyFinanceProductsCounts(S_BuyProductsDto s_buyProductsDto);

    YhbResult expireFinanceProducts(S_BuyProductsDto s_buyProductsDto);

    YhbResult expireFinanceProductsCounts(S_BuyProductsDto s_buyProductsDto);

    YhbResult allInMoney(S_BuyProductsDto s_buyProductsDto);

    YhbResult allInMoneyCounts(S_BuyProductsDto s_buyProductsDto);

    YhbResult allWithdraw(S_BuyProductsDto s_buyProductsDto);

    YhbResult allWithdrawCounts(S_BuyProductsDto s_buyProductsDto);

    YhbResult allRegister(S_BuyProductsDto s_buyProductsDto);

    YhbResult allRegisterCounts(S_BuyProductsDto s_buyProductsDto);

    YhbResult insertOrder(StatisticsOrder[]  statisticsOrders);

    YhbResult selectOrder();

}
