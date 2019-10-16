package com.entity;

import java.util.Date;
import java.util.List;

public class TimeLine {

    private Date lineTime;//时间
    private Integer count;//个数
    private List<Article> articleList;//文章列表

    public Date getLineTime() {
        return lineTime;
    }

    public void setLineTime(Date lineTime) {
        this.lineTime = lineTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
