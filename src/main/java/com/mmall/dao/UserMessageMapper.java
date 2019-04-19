package com.mmall.dao;

import com.mmall.pojo.UserMessage;

public interface UserMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKeyWithBLOBs(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}