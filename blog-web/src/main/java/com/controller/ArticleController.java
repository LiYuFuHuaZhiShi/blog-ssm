package com.controller;

import com.entity.Article;
import com.entity.News;
import com.service.ArticleService;
import com.service.NewsService;
import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;//文章
    @Autowired
    private NewsService newsService;//每日一句
    @Autowired
    private TypeService typeService;//类别

    //显示首页
    @RequestMapping(value = "/index.action")
    public String toIndex(Model model){
        //对文章的内容，点击量，类别，关键字查询
        Map<List<Article>,Integer> articleList = articleService.selectArticleAll();
        model.addAttribute("lists",articleList);
        //查询并随即播放一条每日一句
        News news = newsService.selectAllNewsOutOne();
        model.addAttribute("news",news);
        //热点新闻播报（通过点击量判断，根据点击量排序出前三个）
        List<Article> articles = typeService.hotspotList();
        model.addAttribute("hotspot",articles);
        //最新国内国外新闻（通过发布时间判断）

        return "index";
    }

    @RequestMapping(value = "")
    public String writeBlog(){
        return "";
    }

}
