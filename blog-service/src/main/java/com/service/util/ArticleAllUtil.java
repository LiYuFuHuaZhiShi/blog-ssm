package com.service.util;

import com.dao.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询所有文章
 * 查询所有文章的所有内容
 */
@Service //申明为spring组件
public class ArticleAllUtil {
    @Autowired
    private ArticleMapper articleMapper;//文章
    @Autowired
    private ContentMapper contentMapper;//内容
    @Autowired
    private ClickMapper clickMapper;//点击量
    @Autowired
    private TypeMapper typeMapper;//类别
    @Autowired
    private ArticleKeyMapper articleKeyMapper;//关键词文章关联表
    @Autowired
    private KeywordsMapper keywordsMapper;//关键词表
    @Autowired
    private CommentMapper commentMapper;//评论表
    @Autowired
    private UserMapper userMapper;//用户（用来查询文章作者）

    private static ArticleAllUtil articleAllUtil;//单例 //静态初使化 一个工具类  这样是为了在spring初使化之前

    @PostConstruct//通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
    public void init() {
        articleAllUtil = this;
        articleAllUtil.articleMapper = this.articleMapper;
        articleAllUtil.clickMapper = this.clickMapper;
        articleAllUtil.contentMapper = this.contentMapper;
        articleAllUtil.typeMapper = this.typeMapper;
        articleAllUtil.articleKeyMapper = this.articleKeyMapper;
        articleAllUtil.keywordsMapper = this.keywordsMapper;
        articleAllUtil.userMapper = this.userMapper;
    }

    /**
     * 1.查询出所有文章list
     * 2.遍历list，将文章内容，点击量，类别，关键字，作者加入
     * 3.输出经过处理的最终lists
     *
     * @return
     */
    public List<Article> findArticlesAll() {
        List<Article> articleList = articleMapper.selectAllArticles();//查询所有文章(只有article一张表里的内容)
        List<Article> articleFinalList = new ArrayList<>();//新建列表用来保存最终结果
        for (Article a :
                articleList) {//循环查询出的文章，向其中插入值

            //查询并插入文章内容
            Content content = contentMapper.selectByPrimaryKey(a.getContentId());
            a.setThecontent(content);
            //查询并插入文章点击量
            Click click = clickMapper.selectArticleId(a.getAid());
            a.setTheclick(click);
            //查询并插入文章类别
            Type type = typeMapper.selectByPrimaryKey(a.getTypeId());
            a.setThetype(type);
            //查询并插入文章关键字
            //查询文章对应关键字id
            List<Integer> keyidList = articleKeyMapper.selectKeyIdByArticleId(a.getAid());
            List<Keywords> keyList = new ArrayList<>();
            for (Integer is :
                    keyidList) {
                //根据每个id查询关键字
                Keywords keywords = keywordsMapper.selectByPrimaryKey(is);
                //放到list集合里
                keyList.add(keywords);
            }
            a.setKeywordsList(keyList);
            //查询文章对应作者
            User user = userMapper.selectByPrimaryKey(a.getAuthorId());
            a.setUser(user);

            articleFinalList.add(a);//把所有文章建成列表
        }

        return articleFinalList;
    }

    /**
     * 数据库查询时没有类别，点击量，关键词，评论
     * 输入list
     * 遍历list，点击量，类别，关键字，作者加入
     * 输出最终list
     *
     * @param articles
     * @return
     */
    public List<Article> addArticleAll(List<Article> articles) {
        List<Article> articles1 = new ArrayList<>();//新建列表用于输出
        for (Article article :
                articles) {
            //查询并插入文章点击量
            Click click = clickMapper.selectArticleId(article.getAid());
            article.setTheclick(click);
            //查询并插入文章类别
            Type type = typeMapper.selectByPrimaryKey(article.getTypeId());
            article.setThetype(type);
            //查询并插入文章关键字
            //查询文章对应关键字id
            List<Integer> keyidList = articleKeyMapper.selectKeyIdByArticleId(article.getAid());
            List<Keywords> keyList = new ArrayList<>();
            for (Integer is :
                    keyidList) {
                //根据每个id查询关键字
                Keywords keywords = keywordsMapper.selectByPrimaryKey(is);
                //放到list集合里
                keyList.add(keywords);
            }
            article.setKeywordsList(keyList);
            //对文章作者进行查询
            User user = userMapper.selectByPrimaryKey(article.getAuthorId());
            article.setUser(user);

            articles1.add(article);
        }
        return articles1;
    }


    /**
     * 将传入的文章补全
     * 传入一篇文章
     * 分别将文章内容，点击量，类别，关键字，作者，评论加入
     * 传出
     *
     * @param article
     * @return
     */

    public Article makeArticleAll(Article article) {
        //查询并插入文章内容
        Content content = contentMapper.selectByPrimaryKey(article.getContentId());
        article.setThecontent(content);
        //查询并插入文章点击量
        Click click = clickMapper.selectArticleId(article.getAid());
        article.setTheclick(click);
        //查询并插入文章类别
        Type type = typeMapper.selectByPrimaryKey(article.getTypeId());
        article.setThetype(type);
        //查询并插入文章关键字
        //查询文章对应关键字id
        List<Integer> keyidList = articleKeyMapper.selectKeyIdByArticleId(article.getAid());
        List<Keywords> keyList = new ArrayList<>();
        for (Integer is :
                keyidList) {
            //根据每个id查询关键字
            Keywords keywords = keywordsMapper.selectByPrimaryKey(is);
            //放到list集合里
            keyList.add(keywords);
        }
        article.setKeywordsList(keyList);
        //查询文章对应作者
        User user = userMapper.selectByPrimaryKey(article.getAuthorId());
        //将用户的头像改为只有图片名称
        String headpath = user.getHeadPic();
        user.setHeadPic(headpath.replace("D:\\front-end\\picture\\", ""));
        article.setUser(user);
        //加入评论，根据文章id查询出文章所对应的评论
        List<Comment> commentList = commentMapper.selectByAid(article.getAid());
        for (Comment comment :
                commentList) {
            //遍历评论列表，将用户加到评论里
            User user1 = userMapper.selectByPrimaryKey(comment.getUserId());
            //将用户的头像改为只有图片名称
            String headpath2 = user1.getHeadPic();
            user1.setHeadPic(headpath2.replace("D:\\front-end\\picture\\", ""));
            comment.setUser(user1);
        }
        article.setCommentList(commentList);
        return article;
    }


    /**
     * 用aid返回完整文章类
     *
     * @param aid
     * @return
     */
    public Article selectArticleAllByAid(Integer aid) {

        //查询出文章的id所对应的id，对文章进行补全
        Article article = articleMapper.selectByPrimaryKey(aid);
        //返回将文章补全的内容
        Article article1 = this.makeArticleAll(article);
        return article1;

    }


}
