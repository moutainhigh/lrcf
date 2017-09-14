package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

/**
 * 用户消息vo
 * Created by Administrator on 2017/6/9 0009.
 */
public class UserMessageVo  extends BaseEntity {

    private boolean read; //是否已读
    private String origin; //消息来源
    private String content;//内容
    private String time;//发送时间
    private Integer id;//消息唯一id

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
