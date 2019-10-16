package com.dao;

import com.entity.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    //查询所有的文章的所有内容
    List<Article> selectAllArticles();


    //按时间对文章查询
    List<Article> selectAllArticlesByTime(String onetime);

    //通过排序后返回的点击量列表查询相对应的文章
    List<Article> selectArticlesByClick(List<Integer> clickList);

    //保存所有
    void insertArticleAll(Article article);

    //根据用户id查出此用户的所有文章
    List<Article> selectAllArticlesByUid(Integer uid);

}