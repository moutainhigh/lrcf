package com.lrcf.yhb.gift.service;

import com.lrcf.yhb.gift.api.*;
import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.vo.ActivityListVo;
import com.lrcf.yhb.pojo.AccountRaiseGet;
import com.lrcf.yhb.pojo.AccountUsersActivity;
import com.lrcf.yhb.pojo.ExperienceSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: CommonActivityServiceImpl.java
 * @Description: 公共的活动礼券实现类
 * @author:Krx
 * @date: 2017年5月16日 上午11:01:06
 */
@Service("commonActivityService")
public class CommonActivityServiceImpl implements CommonActivityService {

    @Autowired
    ExperienceSendService experienceSendService;
    @Autowired
    ExperienceuserBuycpService experienceuserBuycpService;
    @Autowired
    AccountUsersActivityService accountUsersActivityService;
    @Autowired
    RedBuyProService redBuyProService;
    @Autowired
    AccountRaiseGetService accountRaiseGetService;
    @Autowired
    RaiseBuyProService raiseBuyProService;

    //通用map
    static Map<String, Object> returnMap = null;


    /**
     * @Description: 根据UserId获取用户活动礼券
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    @Override
    public Map<String, Object> getUserActivity(String userId, Integer id,String ...type) {
        //id为产品Id
        // type 表示生命周期 未用 已用 过期
        //userId 表示用户的唯一表示Id
        returnMap = new HashMap();
        //获取加息劵
        List<AccountRaiseGet> accountRaiseGetList = accountRaiseGetService.getUserRaise(userId, id);
        //获取红包
        List<AccountUsersActivity> accountUsersActivityList = accountUsersActivityService.getUserRed(userId, id);
        //获取体验金
        List<ExperienceSend> experienceSendList = experienceSendService.getExperience(userId, id);

        returnMap.put("raise", accountRaiseGetList == null ? null : accountRaiseGetList);
        returnMap.put("red", accountUsersActivityList == null ? null : accountUsersActivityList);
        returnMap.put("experience", experienceSendList == null ? null : experienceSendList);

        return returnMap;
    }


    /**
     * @param userId
     * @param type
     * @Description: 我的礼券根据UserId, id获取用户活动礼券
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    @Override
    public Map<String, Object> getMyCoupon(String userId,Integer state ,Integer type) {
        returnMap = new HashMap();
        //type 为1.红包,2.加息劵,3.体验金4.分享金
        //state 表示礼券的生命周期  过期，已用，未用
        //userId 表示用户的唯一表示Id
        if(type == 1){
            List<AccountUsersActivity> accountUsersActivityList = accountUsersActivityService.getUserRed(userId, null, String.valueOf(state));
            //封装参数
        }else if(type == 2){
            List<ExperienceSend> experienceSendList = experienceSendService.getExperience(userId,null,String.valueOf(state));
            //封装参数
        } else if (type == 3) {
            List<AccountRaiseGet> accountRaiseGetList = accountRaiseGetService.getUserRaise(userId, null, String.valueOf(state));
            //封装参数
        }

        return returnMap;
    }

    /**
     * 获取加息劵，体验金，红包数据总数
     *
     * @param param
     * @param: param
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    @Override
    public int getActivityCount(Map<String, Object> param) {
        Integer type = Integer.parseInt(param.get("type").toString());

        if (type == 1) {
            return accountUsersActivityService.getUserRedCount(param);
        }else if (type == 2){
            return experienceSendService.getExperienceCount(param);
        }else if (type == 3){
            return accountRaiseGetService.getUserRaiseCount(param);
        }

        return 0;
    }

    /**
     * 获取加息劵，体验金，红包数据列表
     *
     * @param param
     * @param: param
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    @Override
    public List<ActivityListVo> activityList(Map<String, Object> param) {
        Integer type = Integer.parseInt(param.get("type").toString());

        //红包
        if(type == 1){
            List<AccountUsersActivity> accountUsersActivityList = accountUsersActivityService.getUserRedList(param);
            //转换成红包list
            List<ActivityListVo> activityListVoList = new ArrayList<>();
            ActivityListVo vo = null;
            Integer state = 0;
            String unuse = "";
            for (AccountUsersActivity accountUsersActivity :accountUsersActivityList){
                vo = new ActivityListVo();
                vo.setDay(String.valueOf(accountUsersActivity.getDay()));
                vo.setGetTime(DateUtil.parseToDateTimeStr(accountUsersActivity.getGaintime()));
                vo.setOverdueTime(DateUtil.parseToDateTimeStr(accountUsersActivity.getOverdutime()));
                vo.setName(accountUsersActivity.getActivityname());
                vo.setRemarks(accountUsersActivity.getActivitycount());
                //1表示已使用 2表示未使用 3表示已过期
                if(accountUsersActivity.getActivitystate() == 0){
                    state = 2;  //未使用
                    unuse = "未过期";
                }else if(accountUsersActivity.getActivitystate() == 2){
                    state = 1;  //已使用
                    unuse = "已使用";
                } else if (accountUsersActivity.getActivitystate() == 3) {
                    state = 2; //已过期
                    unuse = "已过期";
                }
                vo.setState(state);
                vo.setUnuse(unuse);
                vo.setValue(accountUsersActivity.getActivitymoney());

                activityListVoList.add(vo);
            }

            return activityListVoList;
        } else if (type == 2) { //体验金
            List<ExperienceSend> experienceSendList = experienceSendService.getExperienceList(param);
            //转换成红包list
            List<ActivityListVo> activityListVoList = new ArrayList<>();
            ActivityListVo vo = null;
            Integer state = 0;
            String unuse = "";
            Integer day = 0;
            for(ExperienceSend experienceSend:experienceSendList){
                vo = new ActivityListVo();
                vo.setOverdueTime(experienceSend.getExperiencesendemK2());
                vo.setGetTime(DateUtil.parseToDateTimeStr(experienceSend.getExperiencesendtime()));
                vo.setValue(experienceSend.getExperiencesendmoney());
                vo.setName(experienceSend.getExperiencesendemK1());
                try{
                    String time = String.valueOf(experienceSend.getExperiencesendemK2());
                    day = DateUtil.daysBetween(experienceSend.getExperiencesendtime(),DateUtil.convertStringToDate(DateUtil.dateTimePattern,time));
                }catch (ParseException e){
                 e.printStackTrace();
                }
                vo.setDay(day.toString());
                //体验金方法使用状态(   state 1 已使用 state 0  未使用 state 3  已过期）
                if(experienceSend.getExperiencesendisuse() == 3){
                    // 0：未使用，1：已使用，2：已过期
                    state = 2;
                    unuse = "已过期";
                }else if(experienceSend.getExperiencesendisuse() == 1){
                    unuse = "已使用";
                }
                vo.setState(state);
                vo.setUnuse(unuse);
                activityListVoList.add(vo);
            }
            return activityListVoList;
        } else if (type == 3){ //加息劵
            List<AccountRaiseGet> accountRaiseGetList = accountRaiseGetService.getUserRaiseList(param);
            //转换成红包list
            List<ActivityListVo> activityListVoList = new ArrayList<>();
            ActivityListVo vo = null;
            Integer state = 0;
            String unuse = "";
            for (AccountRaiseGet accountRaiseGet :accountRaiseGetList){
                vo = new ActivityListVo();
                vo.setValue(new BigDecimal(accountRaiseGet.getRaisesize()));
                vo.setRemarks(accountRaiseGet.getRaisemark());
                vo.setName(accountRaiseGet.getRaisename());
                vo.setDay(accountRaiseGet.getRaisedatenum().toString());
                vo.setGetTime(DateUtil.parseToDateTimeStr(accountRaiseGet.getRaisegettime()));
                vo.setOverdueTime(DateUtil.parseToDateTimeStr(accountRaiseGet.getRaiseovertime()));
                //0表示未使用 1表示已使用 3表示已过期
                if(accountRaiseGet.getRaisestate() == 3){
                    // 0：未使用，1：已使用，2：已过期
                    state = 2;
                    unuse = "已过期";
                }else if(accountRaiseGet.getRaisestate() == 1){
                    unuse = "已使用";
                }else if(accountRaiseGet.getRaisestate() == 0){
                    unuse = "未过期";
                }
                vo.setState(state);
                vo.setUnuse(unuse);
                activityListVoList.add(vo);
            }
            return activityListVoList;
        }else{
            return null;
        }
    }
}
