package com.service;

import com.entity.Article;

import java.util.List;

public interface TypeService {

    //通过点击量判断，根据点击量排序出前三个
    public List<Article> hotspotList();
}
