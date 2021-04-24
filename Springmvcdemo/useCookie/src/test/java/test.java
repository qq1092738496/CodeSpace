import com.meditation.dao.BookDao;
import com.meditation.pojo.Book;
import com.meditation.service.service;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2021/1/14 8:41
 */

public class test {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDao bookDao = sqlSession.getMapper(BookDao.class);
        Book getbook = bookDao.getbook(5);
        System.out.println(getbook);
        sqlSession.commit();
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String,Object> map= new HashMap<String, Object>();
        byte[] bytes = new byte[1];
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        map.put("Id",1);
        map.put("BookName", "map插入");
        map.put("BookImage", bytes);
        map.put("Author","map插入" );
        map.put("Intro", "map插入");
        map.put("UpdateTime", timestamp);
        map.put("BookUrl", "map插入");
        map.put("Price", 1.1);
        map.put("Rent", 1.1);
        BookDao mapper = sqlSession.getMapper(BookDao.class);
       // mapper.deletebook(1);
        mapper.addbook(map);
        sqlSession.commit();
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Book book = new Book();
        book.setId(1);
        book.setBookName("pojo修改书名");
        book.setBooklmage(new byte[2]);
        book.setUpdateTime(timestamp);
        book.setAuthor("pojo修改书名");
        book.setIntro("pojo修改书名");
        book.setBookUrl("pojo修改书名");
        book.setPrice(1.1);
        book.setRent(1.1);
        mapper.modifybook(book);
        sqlSession.commit();
    }

    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDao bookdaos = sqlSession.getMapper(BookDao.class);
        Map<String,Integer> maps = new HashMap<>();
        maps.put("indexes", 0);
        maps.put("showdata", 20);
        List<Book> books = bookdaos.paging(maps);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
