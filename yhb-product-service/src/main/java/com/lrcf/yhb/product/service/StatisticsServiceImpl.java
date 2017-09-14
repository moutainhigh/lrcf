package com.lrcf.yhb.product.service;

import com.alibaba.fastjson.JSON;
import com.lrcf.yhb.common.redis.RedisUtil;
import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.vo.YhbResult;
import com.lrcf.yhb.dao.mapper.AdminCountInfoDao;
import com.lrcf.yhb.dao.mapper.StatisticsOrderDao;
import com.lrcf.yhb.dto.S_BuyProductsDto;
import com.lrcf.yhb.pojo.AccountChangeinfo;
import com.lrcf.yhb.pojo.AccountsUsers;
import com.lrcf.yhb.pojo.AdminCountInfo;
import com.lrcf.yhb.pojo.StatisticsOrder;
import com.lrcf.yhb.product.api.StatisticsService;
import com.lrcf.yhb.user.api.AccountsUsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    AdminCountInfoDao adminCountInfoDao;
    @Autowired
    AccountsUsersService usersService;
    @Autowired
    StatisticsOrderDao statisticsOrderDao;

    private Map<String, Object> param = new HashMap<>();  //返回map
    private Map<String, String > map = new HashMap<String, String >(); //参数拼接map


    /**
     * 返回总入金,注册量,冻结金额,提现金额,绑卡数量
     * @param s_buyProductsDto
     * @return  map
     * @author: Czy
     */
     public YhbResult statistics (S_BuyProductsDto s_buyProductsDto){
         if (!StringUtils.isBlank(RedisUtil.get(RedisUtil.statistics))) {
             return YhbResult.success(JSON.parseObject(RedisUtil.get(RedisUtil.statistics),Map.class));
         }
         Map<String, String> map = new HashMap<String, String>();
         map.put("startTime",s_buyProductsDto.getStartTime());
         map.put("endTime",s_buyProductsDto.getEndTime());

         BigDecimal sunInMoney1 = adminCountInfoDao.getSunOutMoney(map);
         BigDecimal sunInMoney = adminCountInfoDao.getSunInMoney(map);

         BigDecimal rujin = sunInMoney == null || sunInMoney.equals("") ? BigDecimal.ZERO : sunInMoney;
         BigDecimal chujin= adminCountInfoDao.getSunOutMoney(map)==null || adminCountInfoDao.getSunOutMoney(map).equals("")? BigDecimal.ZERO :
                 adminCountInfoDao.getSunOutMoney( map);
         BigDecimal dongjie = adminCountInfoDao.getSunDongJieMoney( map)==null || adminCountInfoDao.getSunDongJieMoney( map).equals("") ? BigDecimal.ZERO :
                 adminCountInfoDao.getSunDongJieMoney( map);

         Integer countRegister = adminCountInfoDao.getCountRegister(map);
         Integer countCard = adminCountInfoDao.getCountCard(map);

         param.put("rujin",rujin );
         param.put("tixian",chujin);
         param.put("dongjie", dongjie);
         param.put("zhuce", countRegister);
         param.put("bangka", countCard);

         RedisUtil.set(RedisUtil.statistics, JSON.toJSONString(param));

         YhbResult result= YhbResult.success(param);
        return result;


    }

    /**
     *  单位时间内新购产品列表  以及数量
     * @param s_buyProductsDto
     * @return YhbResult
     * @author Czy
     */
    public YhbResult buyFinanceProducts(S_BuyProductsDto s_buyProductsDto) {
        if (!StringUtils.isBlank(RedisUtil.get(RedisUtil.buyFinanceProducts))) {

            return YhbResult.success(JSON.parseObject(RedisUtil.get(RedisUtil.buyFinanceProducts),List.class));
        }

        map= DateUtil.getTime(s_buyProductsDto.getType());
        map.put("pageSize", String.valueOf(s_buyProductsDto.getPageSize()));
        map.put("target",String.valueOf( (s_buyProductsDto.getTarget() - 1) * s_buyProductsDto.getPageSize()));

        List<AdminCountInfo> countInfoList = adminCountInfoDao.allBuyProducts(null);

        Map<String,Object>[] data = new Map[countInfoList.size()];
        Map<String,Object> map2= new HashMap<>();
        for ( int j=0; j<countInfoList.size();j++){
              map2.put("userName",countInfoList.get(j).getExpireUsers().getUserName());
              map2.put("time",countInfoList.get(j).getExpireUsers().getTime());
              map2.put("duringTime",countInfoList.get(j).getExpireUsers().getDuringTime());
              map2.put("fproductsName",countInfoList.get(j).getExpireUsers().getFProductsName());
              map2.put("trueName",countInfoList.get(j).getExpireUsers().getTrueName());
              map2.put("payMoney",countInfoList.get(j).getExpireUsers().getPayMoney());
            data =  transValueStack(data,map2,j);
            map2.clear();
        }
        List<Object> list2= new ArrayList<>();
        list2.add(data);

        RedisUtil.set(RedisUtil.buyFinanceProducts, JSON.toJSONString(list2));

        YhbResult result= YhbResult.success(list2);
        return result;
    }

    /**
     *  单位时间内新购产品 数量 以及总钱数
     * @param s_buyProductsDto
     * @return
     */
    public YhbResult buyFinanceProductsCounts(S_BuyProductsDto s_buyProductsDto) {
        map= DateUtil.getTime(s_buyProductsDto.getType());
        List<AdminCountInfo> list = adminCountInfoDao.allBuyProducts(map);

        BigDecimal sum= BigDecimal.ZERO;

        for(int i=0;i<list.size();i++){
            sum=sum.add( list.get(i).getExpireUsers().getPayMoney());
        }

        param.put("count", list.size());
        param.put("money", sum);

        YhbResult result= YhbResult.success(param);
        return result;
    }



    /**
     *  单位时间内 到期产品列表  以及数量
     * @param s_buyProductsDto
     * @return YhbResult
     * @author Czy
     */
    public YhbResult expireFinanceProducts(S_BuyProductsDto s_buyProductsDto) {
        map= DateUtil.getTime(s_buyProductsDto.getType());
        map.put("pageSize", String.valueOf(s_buyProductsDto.getPageSize()));
        map.put("target",String.valueOf( (s_buyProductsDto.getTarget() - 1) * s_buyProductsDto.getPageSize()));

        List<AdminCountInfo> countInfoLists = adminCountInfoDao.allExpireProducts(map);

        Map<String,Object>[] data = new Map[countInfoLists.size()];
        for ( int j=0; j<countInfoLists.size();j++){
            param.put("userName",countInfoLists.get(j).getExpireUsers().getUserName());
            param.put("time",countInfoLists.get(j).getExpireUsers().getTime());
            param.put("duringTime",countInfoLists.get(j).getExpireUsers().getDuringTime());
            param.put("fproductsName",countInfoLists.get(j).getExpireUsers().getFProductsName());
            param.put("trueName",countInfoLists.get(j).getExpireUsers().getTrueName());
            param.put("payMoney",countInfoLists.get(j).getExpireUsers().getPayMoney());
            data =  transValueStack(data,param,j);
            param.clear();
        }

        List<Object> objectsDataList= new ArrayList<>();
        objectsDataList.add(data);

        YhbResult result= YhbResult.success(objectsDataList);
        return result;
    }

    /**
     * 单位时间内 到期产品 数量 以及 即将减少的冻结金额
     * @param s_buyProductsDto
     * @return
     */
    public YhbResult expireFinanceProductsCounts(S_BuyProductsDto s_buyProductsDto) {
        map= DateUtil.getTime(s_buyProductsDto.getType());
        List<AdminCountInfo> list = adminCountInfoDao.allExpireProducts(map);

        BigDecimal sum= BigDecimal.ZERO;

        for(int i=0;i<list.size();i++){
            sum=sum.add( list.get(i).getExpireUsers().getPayMoney());
        }

        param.put("count", list.size());
        param.put("money", sum);

        YhbResult result= YhbResult.success(param);
        return result;
    }



    /**
     *  单位时间内 入金量 以及入金明细
     * @param s_buyProductsDto
     * @return YhbResult
     * @author Czy
     */
    public YhbResult allInMoney(S_BuyProductsDto s_buyProductsDto) {
        map= DateUtil.getTime(s_buyProductsDto.getType());
        map.put("pageSize", String.valueOf(s_buyProductsDto.getPageSize()));
        map.put("target",String.valueOf( (s_buyProductsDto.getTarget() - 1) * s_buyProductsDto.getPageSize()));

        List<AdminCountInfo> list1 = adminCountInfoDao.allInMoney(map); //分页

        Map<String,Object>[] data = new Map[list1.size()];
        for ( int j=0; j<list1.size();j++){
            param.put("payMoney",list1.get(j).getExpireUsers().getPayMoney());
            param.put("time",list1.get(j).getExpireUsers().getTime());
            param.put("channelName ",list1.get(j).getExpireUsers().getChannelName());
            param.put("userName",list1.get(j).getExpireUsers().getUserName());
            param.put("trueName",list1.get(j).getExpireUsers().getTrueName());
            data =  transValueStack(data,param,j);
            param.clear();
        }
        List<Object> list2= new ArrayList<>();
        list2.add(data);

        YhbResult result= YhbResult.success(list2);
        return result;
    }

    /**
     *   单位时间内 入金量 以及入金记录条数
     * @param s_buyProductsDto
     * @return
     */
    public YhbResult allInMoneyCounts(S_BuyProductsDto s_buyProductsDto) {
        map=DateUtil.getTime(s_buyProductsDto.getType());
        List<AdminCountInfo> list = adminCountInfoDao.allInMoney(map); //入金明细
        BigDecimal rujin = adminCountInfoDao.getSunInMoney(map);//入金总数

        param.put("rujin", rujin);
        param.put("count",list.size());
        YhbResult result= YhbResult.success(param);
        return result;
    }


    /**
     *  单位时间内  提现明细   以及提现总钱数
     * @param s_buyProductsDto
     * @return YhbResult
     * @author Czy
     */
    public YhbResult allWithdraw(S_BuyProductsDto s_buyProductsDto) {
        map= DateUtil.getTime(s_buyProductsDto.getType());
        map.put("pageSize", String.valueOf(s_buyProductsDto.getPageSize()));
        map.put("target",String.valueOf( (s_buyProductsDto.getTarget() - 1) * s_buyProductsDto.getPageSize()));

        List<AdminCountInfo> list1 = adminCountInfoDao.allWithdraw(map); //提现明细

        Map<String,Object>[] data = new Map[list1.size()];
        for ( int j=0; j<list1.size();j++){
            param.put("payMoney",list1.get(j).getExpireUsers().getPayMoney());
            param.put("time",list1.get(j).getExpireUsers().getTime());
            param.put("panyBank",list1.get(j).getExpireUsers().getPayBank());
            param.put("userName",list1.get(j).getExpireUsers().getUserName());
            param.put("trueName",list1.get(j).getExpireUsers().getTrueName());
            param.put("payFee",list1.get(j).getExpireUsers().getPayFee());
            Integer type1=list1.get(j).getExpireUsers().getCheckType();
            if (type1==1){
                param.put("checkType","余额结算");
            }else if(type1==2){
                param.put("checkType","分润结算");
            }else if(type1==3){
                param.put("checkType","代理商余额提现");
            }else if(type1==4){
                param.put("checkType","福利提现");
            }
            Integer checkState= list1.get(j).getExpireUsers().getCheckState();
            if(checkState==1){
                param.put("checkState","待审核");
            }else if(checkState==2){
                param.put("checkState","等待支付");
            }else if(checkState==3){
                param.put("checkState","已结算");
            }else if(checkState==-1) {
                param.put("checkState", "支付失败");
            }
            data =  transValueStack(data,param,j);
            param.clear();
        }
        List<Object> list2= new ArrayList<>();
        list2.add(data);

        YhbResult result=YhbResult.success(list2);
        return result;
    }

    /**
     * 单位时间内  提现记录数   以及提现总钱数
     * @param s_buyProductsDto
     * @return
     */
    public YhbResult allWithdrawCounts(S_BuyProductsDto s_buyProductsDto){
        map=DateUtil.getTime(s_buyProductsDto.getType());

        List<AdminCountInfo> list = adminCountInfoDao.allWithdraw(map); //提现明细
        BigDecimal  chujin= adminCountInfoDao.getSunOutMoney((HashMap<String, String>) map);//提现总钱数

        param.put("chujin", chujin);
        param.put("count", list.size());
        YhbResult result=YhbResult.success(param);
        return result;
    }


    /**
     *  单位时间内  注册明细   以及总注册量
     * @param s_buyProductsDto
     * @return YhbResult
     * @author Czy
     */
    public YhbResult allRegister(S_BuyProductsDto s_buyProductsDto) {
        map= DateUtil.getTime(s_buyProductsDto.getType());
        map.put("pageSize", String.valueOf(s_buyProductsDto.getPageSize()));
        map.put("target",String.valueOf( (s_buyProductsDto.getTarget() - 1) * s_buyProductsDto.getPageSize()));

        List<AdminCountInfo> list1= adminCountInfoDao.allRegister(map); //注册人明细

        Map<String,Object>[] data = new Map[list1.size()];
        for ( int j=0; j<list1.size();j++){
            param.put("time",list1.get(j).getExpireUsers().getTime());
            param.put("channelName ",list1.get(j).getExpireUsers().getChannelName());
            param.put("userName",list1.get(j).getExpireUsers().getUserName());
            param.put("trueName",list1.get(j).getExpireUsers().getTrueName());
            data =  transValueStack(data,param,j);
            param.clear();
        }

        List<Object> list2= new ArrayList<>();
        list2.add(data);

        YhbResult result=YhbResult.success(list2);
        return result;
    }

    /**
     * 单位时间内的注册量
     * @param s_buyProductsDto
     * @return
     */
    public YhbResult allRegisterCounts(S_BuyProductsDto s_buyProductsDto) {
        map=DateUtil.getTime(s_buyProductsDto.getType());
        Integer countRegister = adminCountInfoDao.getCountRegister(map);//注册量
        YhbResult result = YhbResult.success(countRegister);
        return result;
    }

    /**
     *  向数据库插入统计列表排序
     * @param
     * @return
     */
    public YhbResult insertOrder(StatisticsOrder[] statisticsOrder) {
        statisticsOrderDao.deleteFromTable();
        for(int i=0;i<statisticsOrder.length;i++){
            StatisticsOrder statisticsOrders= new StatisticsOrder();
            Integer order=statisticsOrder[i].getSequence();
            Integer start =statisticsOrder[i].getStart();
            statisticsOrders.setSequence(order);
            statisticsOrders.setStart(start);
            statisticsOrderDao.insertSelective(statisticsOrders);
        }
        return YhbResult.success(200);
    }

    /**
     *  查询 统计列表排序
     * @return
     */
    public YhbResult selectOrder() {
        List<StatisticsOrder> list=  statisticsOrderDao. selectAll();
        return YhbResult.success(list);
    }


    private Map<String,Object>[]  transValueStack(Map<String,Object>[] data,Map<String,Object> map,int i){
        HashMap<String, Object> temp = new HashMap<>();
        Set<String> keySet = map.keySet();
        for (String string : keySet) {
            temp.put(string, map.get(string));
        }
        data[i] = temp;
        return data;
    }
}
