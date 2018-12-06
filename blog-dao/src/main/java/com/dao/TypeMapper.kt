package com.dao

import com.entity.Type

interface TypeMapper {
    fun deleteByPrimaryKey(tid: Int?): Int

    fun insert(record: Type): Int

    fun insertSelective(record: Type): Int

    fun selectByPrimaryKey(tid: Int?): Type

    fun updateByPrimaryKeySelective(record: Type): Int

    fun updateByPrimaryKey(record: Type): Int


}