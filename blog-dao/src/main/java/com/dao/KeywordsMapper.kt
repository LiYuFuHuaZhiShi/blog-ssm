package com.dao

import com.entity.Keywords

interface KeywordsMapper {
    fun deleteByPrimaryKey(kid: Int?): Int

    fun insert(record: Keywords): Int

    fun insertSelective(record: Keywords): Int

    fun selectByPrimaryKey(kid: Int?): Keywords

    fun updateByPrimaryKeySelective(record: Keywords): Int

    fun updateByPrimaryKey(record: Keywords): Int
}