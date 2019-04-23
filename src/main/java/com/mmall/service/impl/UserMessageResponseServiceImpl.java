package com.mmall.service.impl;

import com.mmall.dao.UserMessageMapper;
import com.mmall.service.IUserMessageResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserMessageResponseService")
public class UserMessageResponseServiceImpl implements IUserMessageResponseService
{

    @Autowired
    private UserMessageMapper userMessageMapper;


}
