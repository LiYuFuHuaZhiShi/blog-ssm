package com.dao;

import com.entity.Click;

public interface ClickMapper {
    int deleteByPrimaryKey(Integer clid);

    int insert(Click record);

    int insertSelective(Click record);

    Click selectByPrimaryKey(Integer clid);

    int updateByPrimaryKeySelective(Click record);

    int updateByPrimaryKey(Click record);

    //通过文章id查询所对应的点击量
    Click selectArticleId(Integer aid);
}