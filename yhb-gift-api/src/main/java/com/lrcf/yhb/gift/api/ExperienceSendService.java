/**
 * 
 */
package com.lrcf.yhb.gift.api;


import com.lrcf.yhb.pojo.ExperienceSend;

import java.util.List;
import java.util.Map;

/**
* Copyright: Copyright (c) 2017 LanRu-Caifu
* 
* @ClassName: ExperienceSendService.java
* @Description: 体验金
* @author:Krx
* @date: 2017年5月16日 上午11:04:13 
*/
public interface ExperienceSendService {


    /**
     * @Description: 根据UserId,type,id获取用户活动礼券
     * @param: userId
     * @return：List
     * @author: Krx
     * @date: 2017年5月8日 下午3:47:16
     */
    List<ExperienceSend> getExperience(String userId, Integer id, String... type);


    /***
     * 获取体验金的总数
     * @param param
     * @return
     */
    int getExperienceCount(Map<String, Object> param);

    /***
     * 获取体验金列表
     * @param param
     * @return
     */
    List<ExperienceSend> getExperienceList(Map<String, Object> param);
}
