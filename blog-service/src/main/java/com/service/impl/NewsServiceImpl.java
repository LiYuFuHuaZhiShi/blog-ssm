package com.service.impl;

import com.dao.NewsMapper;
import com.entity.News;
import com.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    //查询出所有的每日一句，并循环
    public News selectAllNewsOutOne() {
        //查询所有news并放入列表
        List<News> newsList = newsMapper.selectAllNews();
        News news = new News();
        /*for (News n :
                newsList) {
            //转换新闻作者文本格式
            n.setAuthor("----by:"+n.getAuthor());
        }*/
        //随机算法
        int i = (int) (Math.random() * (newsList.size()));
        news = newsList.get(i);
        return news;
    }

}
