package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 对用户进行操作
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /*//跳转主页--AticleController
    @RequestMapping(value = "/user_toindex.action")
    public String usertoIndex(){
        return "index";
    }*/

    //跳转登陆界面
    @RequestMapping(value = "/user_tologin.action")
    public String usertoLogin(){
        return "WEB-INF/user/login";
    }

    //跳转注册界面
    @RequestMapping(value = "/user_torequest.action")
    public String usertoRequest(){
        return "WEB-INF/user/request";
    }

    //用户注册
    @RequestMapping(value = "/user_request.action")
    public String userRequest(String username, String password, HttpSession session,Model model){
        User user = userService.addUser(username,password);//将用户保存进数据库
        if(user != null)//注册成功
            return "WEB-INF/user/login";
        else {//失败
            model.addAttribute("error", "此用户已被注册，请重新输入");
            return "WEB-INF/user/request";
        }
    }

    //用户登陆
    @RequestMapping(value = "/user_login.action")
    public String userLogin(String username,String password,Model model,HttpSession session){
        User user = userService.checkLogin(username,password);
        if (user != null) {//成功
            session.setAttribute("user", user);//将用户放入session
            return "redirect:index.action";
        }
        model.addAttribute("error","无此用户，请重新登录");
        return "WEB-INF/user/login";
    }

    //退出登陆
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        //重定向到登陆界面的跳转方法
        return "redirect:user_tologin.action";
    }

}
