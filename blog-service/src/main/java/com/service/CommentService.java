package com.service;

import com.entity.User;

public interface CommentService {

    //将评论保存到数据库中
    public void addComment(User user, Integer aid, String comment);
}
