package com.dao;

import com.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer comid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}