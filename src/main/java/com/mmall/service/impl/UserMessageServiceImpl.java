package com.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMessageMapper;
import com.mmall.pojo.UserMessage;
import com.mmall.service.IUserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserMessageService")
public class UserMessageServiceImpl implements IUserMessageService
{

    @Autowired
    private UserMessageMapper userMessageMapper;

    @Override
    public ServerResponse<PageInfo> getListByUserId(Integer userId, int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<UserMessage> messageList = userMessageMapper.selectByUserId(userId);
        PageInfo pageResult = new PageInfo(messageList);
        pageResult.setList(messageList);
        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse<String> addMessage(UserMessage userMessage)
    {
        int resultCount = userMessageMapper.insert(userMessage);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("留言失败");
        }
        return ServerResponse.createBySuccessMessage("留言成功");
    }

    @Override
    public ServerResponse<PageInfo> getList(int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<UserMessage> messageList = userMessageMapper.selectAll();
        PageInfo pageResult = new PageInfo(messageList);
        pageResult.setList(messageList);
        return ServerResponse.createBySuccess(pageResult);
    }
















}
