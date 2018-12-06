package com.service;

import com.entity.News;


public interface NewsService {

    //查询出所有的每日一句，并循环
    public News selectAllNewsOutOne();

}
