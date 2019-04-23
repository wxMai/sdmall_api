package com.mmall.vo;

import com.mmall.pojo.UserMessageResponse;

import java.text.SimpleDateFormat;
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

    private String createDate;

    private String updateDate;

    public UserMessageResponseVo(Integer id, Integer messageId, Integer userId, Integer isAdmin, Date createTime, Date updateTime, String content)
    {
        this.id = id;
        this.messageId = messageId;
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public UserMessageResponseVo(UserMessageResponse userMessageResponse)
    {
        this.id = userMessageResponse.getId();
        this.messageId = userMessageResponse.getMessageId();
        this.userId = userMessageResponse.getUserId();
        this.isAdmin = userMessageResponse.getIsAdmin();
        this.createTime = userMessageResponse.getCreateTime();
        this.updateTime = userMessageResponse.getUpdateTime();
        this.content = userMessageResponse.getContent();
    }

    public UserMessageResponseVo()
    {
        super();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getMessageId()
    {
        return messageId;
    }

    public void setMessageId(Integer messageId)
    {
        this.messageId = messageId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void formatData()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createDate = sdf.format(this.createTime);
        this.updateDate = sdf.format(this.updateTime);
    }

    public String getCreateDate()
    {
        return createDate;
    }

    public String getUpdateDate()
    {
        return updateDate;
    }

    public String getUserName()
    {
        return userName;
    }
}
