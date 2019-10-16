package com.service.impl;

import com.dao.CommentMapper;
import com.entity.Comment;
import com.entity.User;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    //将评论保存到数据库中
    public void addComment(User user, Integer aid, String comment) {
        //新建评论用于储存
        Comment comment1 = new Comment();
        //将内容加入
        comment1.setContent(comment);
        //时间实时更新
        comment1.setTime(new Date());
        //将文章id加入
        comment1.setArticleid(aid);
        //将用户id加入
        comment1.setUserId(user.getUid());
        //将用户加入
        comment1.setUser(user);
        //入库
        commentMapper.insertSelective(comment1);
    }

}
