package com.mmall.vo;

import com.mmall.pojo.UserMessageResponse;

import java.util.List;

public class UserMessageVo
{

    private Integer id;

    private Integer userId;

    private String title;

    private String content;

    private List<UserMessageResponseVo> userMessageResponseList;

    public UserMessageVo(Integer id, Integer userId, String title, String content)
    {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public UserMessageVo()
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

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public List<UserMessageResponseVo> getUserMessageResponseList()
    {
        return userMessageResponseList;
    }

    public void setUserMessageResponseList(List<UserMessageResponseVo> userMessageResponseList)
    {
        this.userMessageResponseList = userMessageResponseList;
    }
}
