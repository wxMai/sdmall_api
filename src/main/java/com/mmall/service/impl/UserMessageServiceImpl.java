package com.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.dao.UserMessageMapper;
import com.mmall.dao.UserMessageResponseMapper;
import com.mmall.pojo.*;
import com.mmall.service.IUserMessageService;
import com.mmall.vo.UserMessageResponseVo;
import com.mmall.vo.UserMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserMessageService")
public class UserMessageServiceImpl implements IUserMessageService
{

    @Autowired
    private UserMessageMapper userMessageMapper;
    @Autowired
    private UserMessageResponseMapper userMessageResponseMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<PageInfo> getListByUserId(Integer userId, int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
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
        PageHelper.startPage(pageNum, pageSize);
        List<UserMessage> messageList = userMessageMapper.selectAll();
        PageInfo pageResult = new PageInfo(messageList);
        pageResult.setList(messageList);
        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse<UserMessageVo> getInfoAndResponse(Integer messageId)
    {
        UserMessage userMessage = userMessageMapper.selectByPrimaryKey(messageId);
        if (userMessage != null) {
            List<UserMessageResponse> userMessageResponseList = userMessageResponseMapper.selectByMessageId(messageId);
            UserMessageVo userMessageVo = assembleUserMessageVo(userMessage, userMessageResponseList);
            return ServerResponse.createBySuccess(userMessageVo);
        }
        return ServerResponse.createByErrorMessage("没用找到该留言信息");
    }

    @Override
    public ServerResponse delMessage(Integer messageId)
    {
        int rowCount = userMessageMapper.deleteByPrimaryKey(messageId);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("删除留言成功");
        }
        return ServerResponse.createByErrorMessage("删除留言失败");
    }


    private UserMessageVo assembleUserMessageVo(UserMessage userMessage, List<UserMessageResponse> userMessageResponsesList)
    {

        UserMessageVo userMessageVo = new UserMessageVo();

        userMessageVo.setId(userMessage.getId());
        userMessageVo.setUserId(userMessage.getUserId());
        userMessageVo.setTitle(userMessage.getTitle());
        userMessageVo.setContent(userMessage.getContent());

        List<UserMessageResponseVo> userMessageResponseVoList = Lists.newArrayList();

        for (UserMessageResponse userMessageResponse : userMessageResponsesList){
            UserMessageResponseVo userMessageResponseVo = new UserMessageResponseVo(userMessageResponse);
            userMessageResponseVo.setUserName(userMapper.selectUserNameByUserId(userMessageResponse.getUserId()));
            userMessageResponseVo.formatData();
            userMessageResponseVoList.add(userMessageResponseVo);
        }

        userMessageVo.setUserMessageResponseList(userMessageResponseVoList);

        return userMessageVo;
    }

}
