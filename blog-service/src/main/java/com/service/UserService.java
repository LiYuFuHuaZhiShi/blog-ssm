package com.service;

import com.entity.User;

public interface UserService {

    //将用户保存进数据库
    public User addUser(String username, String password);

    //检测用户是否登陆
    public User checkLogin(String username,String password);

}
