import com.meditation.dao.bookdao;
import com.meditation.pojo.Book;
import com.meditation.service.service;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2021/2/7 20:14
 */

public class test {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookdao bookdaos = sqlSession.getMapper(bookdao.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("indexes", 0);
        map.put("showdata", 20);
        List<Book> limitbook = bookdaos.limitbook(map);
        for (Book book : limitbook) {
            System.out.println(book);
        }

    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        service service = (service) applicationContext.getBean("service");
        List<Book> limitbook = service.getlimitbook(1, 20);
        for (int i = 0; i < limitbook.size(); i++) {

            try {
               /* ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(limitbook.get(i).getBookImage());

                int len;
                byte[] bytes = new byte[2048];*/
                OutputStream outputStream = new FileOutputStream("F:\\"+i+".jpg");
               outputStream.write(limitbook.get(i).getBookImage());

                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
