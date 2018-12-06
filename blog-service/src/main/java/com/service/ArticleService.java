package com.service;

import com.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    //查询所有文章的所有内容
    public Map<List<Article>,Integer> selectArticleAll();
}
