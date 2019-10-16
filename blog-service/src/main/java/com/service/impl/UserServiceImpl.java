package com.service.impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //将用户保存进数据库
    public User addUser(String username, String password, String grade, MultipartFile head_pic) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGrade(grade);
        //上传图片
        String path = "D:\\front-end\\picture\\head";
        // 文件保存路径
        String savePath = path + "\\" + head_pic.getOriginalFilename();
        //保存文件
        saveFile(head_pic, path, savePath);
        user.setHeadPic(savePath);

        User user1 = userMapper.selectByUserName(username);
        if (user1 == null) {
            userMapper.insertSelective(user);
        } else
            return null;
        return user;
    }

    //保存文件
    private static boolean saveFile(MultipartFile file, String path, String savePath) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();

                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    //检测用户是否登陆
    public User checkLogin(String username, String password, String grade) {
        User user = userMapper.selectUser(username, password, grade);
        //将头像保存路径转换成相对，因为前端无法读取绝对路径
        if (user != null) {
            String headpath = user.getHeadPic();
            user.setHeadPic(headpath.replace("D:\\front-end\\picture\\", ""));
            return user;
        } else
            return null;
    }


    //修改用户名和头像
    public User updateUser(User user, String username, MultipartFile head_pic) {
        //首先修改用户名
        user.setUsername(username);
        //上传图片
        String path = "D:\\front-end\\picture\\";
        // 文件保存路径
        String savePath = path + head_pic.getOriginalFilename();
        //保存文件
        saveFile(head_pic, path, savePath);
        //将数据库路径中存的图片替换成新图片
        user.setHeadPic(savePath);
        //更新数据库
        userMapper.updateByPrimaryKeySelective(user);
        //将用户的头像传出时进行修改
        //将头像保存路径转换成相对，因为前端无法读取绝对路径
        String headpath = user.getHeadPic();
        user.setHeadPic(headpath.replace("D:\\front-end\\picture\\", ""));
        return user;
    }


}
