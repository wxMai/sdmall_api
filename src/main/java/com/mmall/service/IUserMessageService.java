package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.UserMessage;
import com.mmall.vo.UserMessageVo;

/**
 * Created by geely
 */
public interface IUserMessageService
{

    ServerResponse<PageInfo> getListByUserId(Integer userId, int pageNum, int pageSize);

    ServerResponse<String> addMessage(UserMessage userMessage);

    ServerResponse<PageInfo> getList(int pageNum, int pageSize);

    ServerResponse<UserMessageVo> getInfoAndResponse(Integer messageId);

}
