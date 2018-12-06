package com.dao

import com.entity.User
import org.apache.ibatis.annotations.Param

interface UserMapper {
    fun deleteByPrimaryKey(uid: Int?): Int

    fun insert(record: User): Int

    fun insertSelective(record: User): Int

    fun selectByPrimaryKey(uid: Int?): User

    fun updateByPrimaryKeySelective(record: User): Int

    fun updateByPrimaryKey(record: User): Int

    //按用户名查找
    fun selectByUserName(username: String): User

    //对用户进行登陆验证
    fun selectUser(@Param("username") username: String, @Param("password") password: String): User

}