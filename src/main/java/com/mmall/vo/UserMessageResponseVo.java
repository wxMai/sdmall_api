package com.mmall.vo;

import com.mmall.pojo.UserMessageResponse;

import java.util.Date;
import java.util.List;

public class UserMessageResponseVo
{

    private Integer id;

    private Integer messageId;

    private Integer userId;

    private Integer isAdmin;

    private Date createTime;

    private Date updateTime;

    private String content;

    private String userName;

    public UserMessageResponseVo(Integer id, Integer messageId, Integer userId, Integer isAdmin, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.messageId = messageId;
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public UserMessageResponseVo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
