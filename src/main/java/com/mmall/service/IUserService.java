package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.PayInfo;
import com.mmall.pojo.User;
import com.mmall.vo.UserVo;

/**
 * Created by geely
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username,String question,String answer);

    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse<UserVo> getUserInfoAndShipping(Integer userId);

    ServerResponse checkAdminRole(User user);

    ServerResponse<PageInfo> getAdminList(int pageNum,int pageSize);

    ServerResponse<PageInfo> getNormalUserList(int pageNum,int pageSize);

    ServerResponse<String> delUser(Integer userId);

}
