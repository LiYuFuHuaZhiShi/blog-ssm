package com.dao

import com.entity.Comment

interface CommentMapper {
    fun deleteByPrimaryKey(comid: Int?): Int

    fun insert(record: Comment): Int

    fun insertSelective(record: Comment): Int

    fun selectByPrimaryKey(comid: Int?): Comment

    fun updateByPrimaryKeySelective(record: Comment): Int

    fun updateByPrimaryKey(record: Comment): Int
}