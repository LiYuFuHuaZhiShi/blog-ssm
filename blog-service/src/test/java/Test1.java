import com.entity.Article;
import com.entity.Click;
import com.service.impl.ArticleServiceImpl;
import org.junit.Test;

import java.util.*;

public class Test1 {
    @Test
    public void TestFindArticleAlls() {
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        Map<List<Article>, Integer> map = articleService.selectArticleAll();
        System.out.println(map);
    }

    @Test
    public void Test2() {
        List<Click> list = new ArrayList<>();
//创建3个对象，点击量分别是7000、9000、8000，6000并将他们依次放入List中  
        Click a1 = new Click();
        a1.setClick(7200);
        Click a2 = new Click();
        a2.setClick(100);
        list.add(a1);
        list.add(a2);
        Collections.sort(list, new Comparator<Click>() {
            public int compare(Click c1, Click c2) {
                //按照金额大小进行降序排列  
                if (c1.getClick() < c2.getClick()) {
                    return 1;
                }
                if (c1.getClick() == c2.getClick()) {
                    return 0;
                }
                return -1;
            }
        });

        //降序获取前3个集合
        if (list != null && list.size() > 0) {
            if (list.size() > 3) {
                list = list.subList(0, 3);
                for (Click c : list) {
                    System.out.println(c.getClick());
                }
            } else {
                list = list.subList(0, list.size());
                for (Click a : list) {
                    System.out.println(a.getClick());
                }
            }
        }

    }





}



