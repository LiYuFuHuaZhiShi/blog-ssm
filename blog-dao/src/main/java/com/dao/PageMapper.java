package com.dao;

import com.entity.Article;

import java.util.List;

public interface PageMapper {
    public List<Article> selectByPageAndSelections();
}
