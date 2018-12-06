package com.dao

import com.entity.ArticleKey

interface ArticleKeyMapper {
    fun deleteByPrimaryKey(ktaId: Int?): Int

    fun insert(record: ArticleKey): Int

    fun insertSelective(record: ArticleKey): Int

    fun selectByPrimaryKey(ktaId: Int?): ArticleKey

    fun updateByPrimaryKeySelective(record: ArticleKey): Int

    fun updateByPrimaryKey(record: ArticleKey): Int

    //通过文章id查找文章所对应的关键字id
    fun selectKeyIdByArticleId(aid: Int?): List<Int>

}