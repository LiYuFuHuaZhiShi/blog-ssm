package com.controller;

import com.entity.Article;
import com.entity.News;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.ArticleService;
import com.service.CommentService;
import com.service.NewsService;
import com.service.TypeService;
import com.service.util.ArticleAllUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private CommentService commentService;//评论
    @Autowired
    private ArticleAllUtil articleAllUtil;//工具类 补全博客

    //显示首页
    @RequestMapping(value = "/index.action")
    public String toIndex(Model model) {
        //对文章的内容，点击量，类别，关键字查询,按时间分类
        Map<Integer, List<Article>> articleList = articleService.selectArticleAll();

        model.addAttribute("lists", articleList);
        //查询并随即播放一条每日一句
        News news = newsService.selectAllNewsOutOne();
        model.addAttribute("news", news);
        //热点新闻播报（通过点击量判断，根据点击量排序出前三个）
        List<Article> articles = typeService.hotspotList();
        model.addAttribute("hotspot", articles);
        //最新国内国外新闻（通过发布时间判断）


        return "WEB-INF/blog/index";
    }

    //分页操作
    @RequestMapping(value = "/pagination.action")
    @ResponseBody
    public List<Article> pagination(Integer currentPage) {
        PageInfo<Article> page = articleService.selectArticleByPage(currentPage, 4);
        List<Article> articles = new ArrayList<>();//建立新的数组用来储存ArticleList
        List<Article> articleList = page.getList();
        for (Article a :
                articleList) {
            //循环并补全文章
            a = articleAllUtil.selectArticleAllByAid(a.getAid());
            articles.add(a);
        }
        return articles;
    }


    //跳转--到写博客页面
    @RequestMapping(value = "/toWriteBlog.action")
    public String toWriteBlog(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "WEB-INF/blog/writearticle";
        } else
            model.addAttribute("error", "请先登陆用户，这样才能使用写博客功能");
        return "WEB-INF/user/login";
    }

    //写博客
    @RequestMapping(value = "/writeArticle.action", method = RequestMethod.POST)
    public String writeBlog(HttpSession session, String headline, String content, String type) {
        User user = (User) session.getAttribute("user");
        articleService.saveAtrcle(headline, content, type, user);//保存文章
        // 重定向
        return "redirect:index.action";
    }

    //上传图片
    @RequestMapping(value = "/downloadPic.action", method = RequestMethod.POST)
    @ResponseBody
    public Object downloadPic(@RequestBody MultipartFile imgFile) {
        Map<String, String> map = new HashMap<>();
        //上传图片并返回路径
        String url = articleService.savePic(imgFile);
        map.put("url", url);
        return map;
    }

    //跳转到博客详情界面
    @RequestMapping(value = "/toArticle.action")
    public String toArticle(Integer aid, Model model) {
        //从页面获得到aid，查询并返回
        Article article = articleService.selectArticleById(aid);
        model.addAttribute(article);
        return "WEB-INF/blog/article";
    }

    //对博客进行编辑操作
    @RequestMapping(value = "/reArticle.action")
    public String reArticle(Integer aid, Model model) {
        //获得到需要编辑的文章详情
        Article article = articleService.selectArticleById(aid);
        //将文章内容填入
        model.addAttribute("article", article);
        //跳转到写博客界面
        return "WEB-INF/blog/writearticle";//在重定向时加上参数
    }
    //修改文章


    //对文章进行评论
    @RequestMapping(value = "/addComment.action")
    public String addComment(HttpSession session, Integer aid, String comment) {
        User user = (User) session.getAttribute("user");
        //将评论保存到数据库中
        commentService.addComment(user, aid, comment);
        return "redirect:toArticle.action?aid=" + aid;//在重定向时加上参数
    }

}
