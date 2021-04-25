import com.meditation.dao.BookDao;
import com.meditation.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2021/4/25 15:11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationcontext.xml" )
public class test {
    @Autowired
    BookDao bookDao;
    @Test
    public void test(){
        List<Book> books = bookDao.limitBook(1, 5);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
