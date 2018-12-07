package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //按用户名查找
    User selectByUserName(String username);

    //对用户进行登陆验证
    User selectUser(@Param("username")String username, @Param("password") String password);

}