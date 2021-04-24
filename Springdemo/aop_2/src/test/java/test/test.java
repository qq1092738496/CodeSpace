package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: Springdemo
 * @Package: PACKAGE_NAME
 * @ClassName: test.test
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/5 21:31
 */

/*@ContextConfiguration(locations = "classpath:applicationcontext.xml")
@RunWith(SpringJUnit4ClassRunner.class)*/
public class test {


   /* @Autowired
    private Calculator bean;*/


    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationcontext.xml");
        /*Calculator bean = ioc.getBean(Calculatorimpl.class);
        bean.add(1, 1);*/

    }
}
