package com.service.impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //将用户保存进数据库
    public User addUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userMapper.selectByUserName(username);
        if (user1 == null)
            userMapper.insertSelective(user);
        else
            return null;
        return user;
    }

    //检测用户是否登陆
    public User checkLogin(String username,String password){
        User user = userMapper.selectUser(username,password);
        if (user != null)
            return user;
        else
            return null;
    }

}
