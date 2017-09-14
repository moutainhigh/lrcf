package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

/**
 * Copyright: Copyright (c) 2017 LanRu-Caifu
 *
 * @ClassName: Ip.java
 * @Description: Ip信息
 * @author:Krx
 * @date: 2017年4月27日 下午3:05:11
 */
public class Ip extends BaseEntity {

    private String ip;

    private Integer count;

    public Ip(String ip,Integer count) {
        this.ip = ip;
        this.count = count;
    }

    public Ip(){


    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
