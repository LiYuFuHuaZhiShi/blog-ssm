package com.service;

import com.entity.Article;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    //查询所有文章的所有内容
    public Map<Integer, List<Article>> selectArticleAll();

    //写博客
    public void saveAtrcle(String headline, String content, String type, User user);

    //根据文章id查询所有文章
    public Article selectArticleById(Integer aid);

    //通过用户id查找到此用户的所有帖子
    public List<Article> selectArticleByUid(Integer uid);

    //上传图片
    public String savePic(MultipartFile imgFile);

    //根据时间(天)进行查询
//    public List<TimeLine> selectLineByTime();

    //分页查询
    public PageInfo selectArticleByPage(int currentPage, int pageSize);

}
