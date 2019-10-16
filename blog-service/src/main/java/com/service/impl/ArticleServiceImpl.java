package com.service.impl;

import com.dao.*;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ArticleService;
import com.service.util.ArticleAllUtil;
import com.service.util.TimeSortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    private PageMapper pageMapper;//分页
    //将工具类注入
    @Autowired
    private ArticleAllUtil articleAllUtil;
    @Autowired
    private TimeSortUtil timeSortUtil;

    //查询所有文章的所有内容，并按时间输出
    public Map<Integer, List<Article>> selectArticleAll() {
        Map<Integer, List<Article>> maps = new HashMap<>();
        int i1 = 1;

        List<Article> articleList = articleAllUtil.findArticlesAll();//查询出所有文章的所有内容

        List<Article> articles;//保存最终list结果

        List<String> timeList = new ArrayList<>();//创建时间list

        for (Article a :
                articleList) {//按时间对文章分类
            Date time = a.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(time);//转换日期格式（一定不能为null）

            timeList.add(date);//添加到list里
            removeDuplicate(timeList);//去重复值

        }

        //对时间进行排序
        timeSortUtil.TimeSort(timeList);

        for (String date :
                timeList) {//遍历timeList
            //根据日期查找相应的list
            articles = articleMapper.selectAllArticlesByTime(date + "%");//模糊查询

            //但是数据库查询时没有类别，点击量，关键词，作者
            articleAllUtil.addArticleAll(articles);//将articles补全

            //按照时间对文章排序
            timeSortUtil.ListSortByTime(articles);

            //将数据放入value里面
            maps.put(i1++, articles);
        }

        //分页
        PageInfo<Article> articlePageInfo = selectArticleByPage(1, 3);
        System.out.println(articlePageInfo);

        return maps;

    }

    // 删除ArrayList中重复元素，用于去重复值
    private static void removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
    }


    //分页查询
    public PageInfo<Article> selectArticleByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Article> articles = pageMapper.selectByPageAndSelections();
        return new PageInfo<Article>(articles);
    }


    //写博客
    public void saveAtrcle(String headline, String content, String type, User user) {
        Article article = new Article();
        //保存标题
        article.setTitle(headline);
        //保存时间
        article.setTime(new Date());
        //保存内容id
        Content content1 = new Content();
        content1.setContent(content);
        //入库
        contentMapper.insertSelective(content1);
        article.setThecontent(content1);
        //保存类别
        Type type1;
        //通过类别查询
        type1 = typeMapper.selectByType(type);
        article.setThetype(type1);
        //保存作者
        article.setUser(user);

        //将文章保存进数据库
        articleMapper.insertArticleAll(article);


        //bug：每增加一个文章就要将点击量，评论量加入
        Click click = new Click();
        click.setClick(0);//点击量为0
        click.setComment(0);//评论量为0
        click.setArticleid(article.getAid());//对应文章id
        //需要将点击量加到click表中
        clickMapper.insert(click);
        //关键词
        //。。。

    }

    //上传图片
    public String savePic(MultipartFile imgFile) {
        //上传文件到path
        String path = "D:\\front-end\\picture\\content\\";
        //保存文件
        saveFile(imgFile, path);
        //返回图片保存路径
        return "http://localhost:8080/picture/content/" + imgFile.getOriginalFilename();
    }

    private static boolean saveFile(MultipartFile file, String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = path + "\\" + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    //根据文章id查询所有文章
    public Article selectArticleById(Integer aid) {
        //根据aid查询出文章
        Article article = articleMapper.selectByPrimaryKey(aid);
        //将文章补全
        articleAllUtil.makeArticleAll(article);
        return article;
    }


    //通过用户id查找到此用户的所有帖子
    public List<Article> selectArticleByUid(Integer uid) {
        //根据用户id查出此用户的所有文章
        List<Article> articleList = articleMapper.selectAllArticlesByUid(uid);
        //将文章列表补全
        articleAllUtil.addArticleAll(articleList);
        return articleList;
    }


    //根据时间(天)进行查询
    /*public List<TimeLine> selectLineByTime(){

    }*/

}
