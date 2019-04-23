package com.mmall.dao;

import com.mmall.pojo.UserMessageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMessageResponseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMessageResponse record);

    int insertSelective(UserMessageResponse record);

    UserMessageResponse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMessageResponse record);

    int updateByPrimaryKeyWithBLOBs(UserMessageResponse record);

    int updateByPrimaryKey(UserMessageResponse record);

    List<UserMessageResponse> selectByMessageId(@Param("messageId")Integer messageId);

}