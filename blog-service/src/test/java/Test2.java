import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springmvc.xml", "classpath:spring/applicationContext-*.xml"})
public class Test2 {
    @Test
    public void pageHelper() {

    }
}
