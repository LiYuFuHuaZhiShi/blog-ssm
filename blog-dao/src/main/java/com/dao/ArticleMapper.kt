package com.dao

import com.entity.Article

interface ArticleMapper {
    fun deleteByPrimaryKey(aid: Int?): Int

    fun insert(record: Article): Int

    fun insertSelective(record: Article): Int

    fun selectByPrimaryKey(aid: Int?): Article

    fun updateByPrimaryKeySelective(record: Article): Int

    fun updateByPrimaryKey(record: Article): Int

    //查询所有的文章的所有内容
    fun selectAllArticles(): List<Article>


    //按时间对文章查询
    fun selectAllArticlesByTime(onetime: String): List<Article>

    //通过排序后返回的点击量列表查询相对应的文章
    fun selectArticlesByClick(clickList: List<Int>): List<Article>

}