package com.dao

import com.entity.Click

interface ClickMapper {
    fun deleteByPrimaryKey(clid: Int?): Int

    fun insert(record: Click): Int

    fun insertSelective(record: Click): Int

    fun selectByPrimaryKey(clid: Int?): Click

    fun updateByPrimaryKeySelective(record: Click): Int

    fun updateByPrimaryKey(record: Click): Int

    //通过文章id查询所对应的点击量
    fun selectArticleId(aid: Int?): Click
}