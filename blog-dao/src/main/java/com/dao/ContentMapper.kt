package com.dao

import com.entity.Content

interface ContentMapper {
    fun deleteByPrimaryKey(conid: Int?): Int

    fun insert(record: Content): Int

    fun insertSelective(record: Content): Int

    fun selectByPrimaryKey(conid: Int?): Content

    fun updateByPrimaryKeySelective(record: Content): Int

    fun updateByPrimaryKeyWithBLOBs(record: Content): Int
}