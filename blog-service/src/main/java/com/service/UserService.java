package com.service;

import com.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    //将用户保存进数据库
    public User addUser(String username, String password, String grade, MultipartFile head_pic);

    //检测用户是否登陆
    public User checkLogin(String username, String password, String grade);

    //修改用户名和头像
    public User updateUser(User user, String username, MultipartFile head_pic);

}
