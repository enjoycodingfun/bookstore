package com.ssm.pojo;

import java.util.Date;

public class News {
    private Integer nid;

    private String title;

    private String content;

    private Date publishtime;

    private Date updatetime;

    private String publishby;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPublishby() {
        return publishby;
    }

    public void setPublishby(String publishby) {
        this.publishby = publishby == null ? null : publishby.trim();
    }
}