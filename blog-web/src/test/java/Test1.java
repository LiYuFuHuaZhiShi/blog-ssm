import com.entity.Article;
import com.github.pagehelper.PageInfo;
import com.service.ArticleService;
import com.service.util.ArticleAllUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class Test1 extends TestUtil {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleAllUtil articleAllUtil;


    @Test
    public void showAllArticles() {
        Article article = articleService.selectArticleById(60);
        System.out.println(article);
    }

    @Test
    public void pageTest() {
        PageInfo<Article> page = articleService.selectArticleByPage(1, 3);
        List<Article> articleList = page.getList();
        List<Article> articles = new ArrayList<>();
        for (Article a :
                articleList) {
            a = articleAllUtil.selectArticleAllByAid(a.getAid());
            System.out.println(a);
            articles.add(a);
        }
        for (Article a :
                articles) {
            System.out.println(a);
        }
    }

}
