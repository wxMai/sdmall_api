package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.UserMessageResponse;

public interface IUserMessageResponseService
{

    ServerResponse<String> response(UserMessageResponse userMessageResponse);

}
