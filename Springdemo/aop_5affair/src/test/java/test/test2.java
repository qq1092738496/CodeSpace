package test;

import com.meditation.pojo.book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/10 23:06
 */
public class test2 {

    @Test
    public void test2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        book book = (book) ioc.getBean("book");

        System.out.println(book);

    }
}
