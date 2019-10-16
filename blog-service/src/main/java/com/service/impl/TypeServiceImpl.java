package com.service.impl;

import com.dao.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TypeServiceImpl implements com.service.TypeService {
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

    //通过点击量判断，根据点击量排序出前三个
    public List<Article> hotspotList() {
        List<Article> articleList1 = findArticlesAllClick();//查询出所有文章的所有点击量

        /*ArticleServiceImpl articleService = new ArticleServiceImpl();
        List<Article> articles = articleService.findArticlesAll();*/

        //根据点击量排序,返回前三个热门文章
        List<Integer> clickList = sortClick(articleList1);

        //通过排序后返回的点击量列表查询相对应的文章
        articleList1 = articleMapper.selectArticlesByClick(clickList);//可以查询clickList：从大到小，但是通过sql之后articleList1变正序了
        Collections.reverse(articleList1);//倒叙输出
        return articleList1;
    }

    /**
     * 查询所有文章的点击量
     */
    public List<Article> findArticlesAllClick() {
        //查询所有文章
        List<Article> articleList = articleMapper.selectAllArticles();
        List<Article> articleList1 = new ArrayList<>();
        for (Article a :
                articleList) {
            //查询并插入文章点击量
            Click click = clickMapper.selectArticleId(a.getAid());
            a.setTheclick(click);
            articleList1.add(a);//把所有文章建成列表
        }
        return articleList1;
    }


    /**
     * 根据点击量倒序排序
     */
    public List<Integer> sortClick(List<Article> articleList1) {
        List<Click> clickList = new ArrayList<>();
        for (Article a :
                articleList1) {
            Click click = a.getTheclick();//循环新建的clickList
            clickList.add(click);//将其加入新的列表里面
        }
        Collections.sort(clickList, new Comparator<Click>() {
            public int compare(Click c1, Click c2) {//定义方法重写sort方法
                //按照点击量大小进行降序排列
                if (c1.getClick() < c2.getClick()) {//小返回1
                    return 1;
                }
                if (c1.getClick() == c2.getClick()) {//相等返回0
                    return 0;
                }
                return -1;//大返回-1
            }
        });

        List<Integer> clicks = new ArrayList<>();
        //降序获取前3个集合//输出前三个点击量最多的文章
        if (clickList != null && clickList.size() > 0) {
            if (clickList.size() > 3) {
                clickList = clickList.subList(0, 3);//倒序排序前三个
                for (Click c : clickList) {
                    Integer click = c.getClick();
//                    System.out.println(click);//输出
                    clicks.add(click);
                }
            } else {
                clickList = clickList.subList(0, clickList.size());
                for (Click c : clickList) {
                    Integer click = c.getClick();
                    clicks.add(click);
                }
            }
        }
        return clicks;
    }


}
