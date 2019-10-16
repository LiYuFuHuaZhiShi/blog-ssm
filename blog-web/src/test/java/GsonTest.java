import com.controller.util.GsonUtil;
import com.entity.Article;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller("TestController")
public class GsonTest {
    @Autowired
    private GsonUtil gsonUtil;

    @Test
    public void GsonUtilTest1() {
        Article article = new Article();
        article.setAid(1);
        article.setTitle("aifgiewg");
        article.setTime(new Date());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(article));


        System.out.println(gsonUtil.toJson(article));//null
    }

}
