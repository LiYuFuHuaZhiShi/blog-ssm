package com.dao;

import com.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer comid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);


    //根据文章id查询出文章所对应的评论
    List<Comment> selectByAid(Integer aid);

}