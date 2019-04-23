package com.mmall.controller.backend;

import com.github.pagehelper.PageInfo;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by geely
 */

@Controller
@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }

    @RequestMapping(value="adminList.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> adminList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");

        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iUserService.getAdminList(pageNum, pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value="normalUserList.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> normalUserList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");

        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iUserService.getNormalUserList(pageNum, pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value="addAdmin.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addAdmin(HttpSession session, User userData){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
        }

        if(iUserService.checkAdminRole(user).isSuccess()){
            userData.setRole(1);
            return iUserService.register(userData);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value="addNormalUser.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addNormalUser(HttpSession session, User userData){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
        }

        if(iUserService.checkAdminRole(user).isSuccess()){
            userData.setRole(0);
            return iUserService.register(userData);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping(value="delUser.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addAdmin(HttpSession session, Integer userId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
        }

        if(iUserService.checkAdminRole(user).isSuccess()){

            if(user.getId() == userId){
                return ServerResponse.createByErrorMessage("不能删除自己");
            }

            return iUserService.delUser(userId);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

}
