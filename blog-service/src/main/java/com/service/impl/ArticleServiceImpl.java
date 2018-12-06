package com.service.impl;

import com.dao.*;
import com.entity.*;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {

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
    private UserMapper userMapper;//用户（用来查询文章作者）

    //查询所有文章的所有内容
    public Map<List<Article>,Integer>  selectArticleAll(){
        Map<List<Article>,Integer> maps = new HashMap<>();
        int i1 = 1;
        List<Article> articleList1 = findArticlesAll();//查询出所有文章的所有内容
        List<Article> articles ;
        for (Article atr :
                articleList1) {//按时间对文章分类
            Date time = atr.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(time);//转换日期格式（一定不能为null）
            //根据日期查找相应的list
            articles = articleMapper.selectAllArticlesByTime(date + "%");
            //但是数据库查询时没有类别，点击量，评论量，关键词
            //再查一遍
            List<Article> articles1 = new ArrayList<>();
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
            //将数据放入key里面，可以预防重复数据
            maps.put(articles,i1++);
        }

        return maps;

    }

    /**
     * 查询所有文章的所有内容
     * @return
     */
    public List<Article> findArticlesAll(){
        //查询所有文章
        List<Article> articleList = articleMapper.selectAllArticles();
//        List<Article> articles ;
        List<Article> articleList1 = new ArrayList<>();
        for (Article a :
                articleList) {
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
            articleList1.add(a);//把所有文章建成列表
        }
        return articleList1;
    }

}
