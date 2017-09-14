package com.lrcf.yhb.statistic.controller;

import com.lrcf.yhb.common.util.StringUtil;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dto.S_BuyProductsDto;
import com.lrcf.yhb.pojo.StatisticsOrder;
import com.lrcf.yhb.product.api.StatisticsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@RestController
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;


    /**
     * 总入金,注册量,冻结金额,提现金额,绑卡数量
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/count",method = RequestMethod.POST)
    public YhbResult statistics (@RequestBody S_BuyProductsDto s_buyProductsDto){
        return statisticsService.statistics(s_buyProductsDto);
    }

    /**
     * 单位时间内新购产品列表  以及数量
     * @param
     * @param
     * @param
     * @return YhbResult
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/buyProducts", method = RequestMethod.POST)
    public  YhbResult buyFinanceProducts(@RequestBody S_BuyProductsDto s_buyProductsDto){
       return  statisticsService.buyFinanceProducts(s_buyProductsDto);
    }

    @RequestMapping(value = "/statistics/buyProductsCounts",method=RequestMethod.POST)
    public  YhbResult buyFinanceProductsCounts(@RequestBody S_BuyProductsDto s_buyProductsDto){
        return statisticsService.buyFinanceProductsCounts(s_buyProductsDto);
    }
    /**
     * 单位时间内到期产品列表  以及数量
     * @param
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/expireFinanceProducts",method = RequestMethod.POST)
    public  YhbResult ExpireFinanceProducts(@RequestBody S_BuyProductsDto s_buyProductsDto){
         return statisticsService.expireFinanceProducts(s_buyProductsDto);

    }

    @RequestMapping(value = "/statistics/expireFinanceProductsCounts",method = RequestMethod.POST)
    public  YhbResult ExpireFinanceProductsCounts(@RequestBody  S_BuyProductsDto s_buyProductsDto ){
         return statisticsService.expireFinanceProductsCounts(s_buyProductsDto);
    }

    /**
     * 单位时间内 新入金量,以及入金明细
     * @param
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping (value = "/statistics/inMoney", method = RequestMethod.POST)
    public  YhbResult allInMoney(@RequestBody  S_BuyProductsDto s_buyProductsDto){
        return statisticsService.allInMoney(s_buyProductsDto);
    }

    /**
     * 单位时间内 新入金量,以及入金明细总记录数
     * @param
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/inMoneyCounts",method = RequestMethod.POST)
    public  YhbResult allInMoneyCounts(@RequestBody  S_BuyProductsDto s_buyProductsDto){
        return statisticsService.allInMoneyCounts(s_buyProductsDto);
    }
    /**
     * 单位时间内  提现明细   以及提现钱数
     * @param
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/withdraw",method = RequestMethod.POST)
    public  YhbResult allWithdraw(@RequestBody S_BuyProductsDto s_buyProductsDto){
        return statisticsService.allWithdraw(s_buyProductsDto);
    }

    /**
     * 单位时间内  提现明细   以及提现钱数总记录数
     * @param
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/withdrawCounts",method =RequestMethod.POST)
    public  YhbResult allWithdrawCounts(@RequestBody S_BuyProductsDto s_buyProductsDto){
        return statisticsService.allWithdrawCounts(s_buyProductsDto);
    }

    /**
     * 单位时间内  注册明细 以及注册量
     * @param
     * @param
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/register",method = RequestMethod.POST)
    public  YhbResult allRegister(@RequestBody S_BuyProductsDto s_buyProductsDto){
        return statisticsService.allRegister(s_buyProductsDto);
    }

    /**
     * 查询注册量
     * @param s_buyProductsDto
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/registerCounts",method = RequestMethod.POST)
    public  YhbResult allRegisterCounts(@RequestBody S_BuyProductsDto s_buyProductsDto){
        return statisticsService.allRegisterCounts(s_buyProductsDto);
    }

    /**
     * 向数据库插入统计列表排序
     * @param
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/insertOrder",method = RequestMethod.POST)
    public  YhbResult insertOrder(@RequestBody StatisticsOrder[] statisticsOrder){
        return statisticsService.insertOrder(statisticsOrder);
    }

    /**
     * 查询 统计列表排序
     * @return
     * @Author Czy
     */
    @RequestMapping(value = "/statistics/selectOrder",method = RequestMethod.GET)
    public  YhbResult selectOrder(){
        return statisticsService.selectOrder();
    }


}
