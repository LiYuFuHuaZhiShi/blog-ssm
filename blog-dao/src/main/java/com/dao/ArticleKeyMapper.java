package com.dao;

import com.entity.ArticleKey;

import java.util.List;

public interface ArticleKeyMapper {
    int deleteByPrimaryKey(Integer ktaId);

    int insert(ArticleKey record);

    int insertSelective(ArticleKey record);

    ArticleKey selectByPrimaryKey(Integer ktaId);

    int updateByPrimaryKeySelective(ArticleKey record);

    int updateByPrimaryKey(ArticleKey record);

    //通过文章id查找文章所对应的关键字id
    List<Integer> selectKeyIdByArticleId(Integer aid);

}