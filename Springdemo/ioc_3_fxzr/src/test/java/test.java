import com.meditation.service.bookservice;
import com.meditation.service.userservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ProjectName: Springdemo
 * @Package: PACKAGE_NAME
 * @ClassName: test
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/4 0:37
 */

@ContextConfiguration(locations = "classpath:Applicationtext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
    @Autowired
    bookservice bookservice;
    @Autowired
    userservice userservice;

    @Test
    public void test1() {
        bookservice.save();
        userservice.save();
    }
}
