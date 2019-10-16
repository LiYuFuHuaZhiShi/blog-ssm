import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/springmvc.xml", "classpath:spring/applicationContext-*.xml"})
@WebAppConfiguration("src/main/resources")
/**
 * 所有对有分层的测试类的父类
 */
public class TestUtil {
}
