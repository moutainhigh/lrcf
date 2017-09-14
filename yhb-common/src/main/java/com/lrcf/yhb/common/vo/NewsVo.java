package com.lrcf.yhb.common.vo;


import com.lrcf.yhb.common.config.BaseEntity;

/**
 * 新闻公告
 * Created by Krx on 2017/6/9 0009.
 */
public class NewsVo extends BaseEntity {
    private String img;
    private String title;
    private String time;
    private String summary;
    private Integer id;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
