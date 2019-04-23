package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMessageMapper;
import com.mmall.dao.UserMessageResponseMapper;
import com.mmall.pojo.UserMessage;
import com.mmall.pojo.UserMessageResponse;
import com.mmall.service.IUserMessageResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserMessageResponseService")
public class UserMessageResponseServiceImpl implements IUserMessageResponseService
{

    @Autowired
    private UserMessageMapper userMessageMapper;
    @Autowired
    private UserMessageResponseMapper userMessageResponseMapper;


    @Override
    public ServerResponse<String> response(UserMessageResponse userMessageResponse)
    {
        UserMessage userMessage = userMessageMapper.selectByPrimaryKey(userMessageResponse.getMessageId());
        if(userMessage == null){
            return ServerResponse.createByErrorMessage("该留言不存在");
        }

        int resultCount = userMessageResponseMapper.insert(userMessageResponse);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("回复失败");
        }
        return ServerResponse.createBySuccessMessage("回复成功");
    }
}
