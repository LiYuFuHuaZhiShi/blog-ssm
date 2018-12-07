package com.dao;

import com.entity.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer nid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    //查询出所有的每日一句
    List<News> selectAllNews();

}