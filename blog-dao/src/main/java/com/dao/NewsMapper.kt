package com.dao

import com.entity.News

interface NewsMapper {
    fun deleteByPrimaryKey(nid: Int?): Int

    fun insert(record: News): Int

    fun insertSelective(record: News): Int

    fun selectByPrimaryKey(nid: Int?): News

    fun updateByPrimaryKeySelective(record: News): Int

    fun updateByPrimaryKey(record: News): Int

    //查询出所有的每日一句
    fun selectAllNews(): List<News>

}