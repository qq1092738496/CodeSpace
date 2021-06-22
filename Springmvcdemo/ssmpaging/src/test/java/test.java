import com.meditation.controller.BookController;
import com.meditation.dao.BookDao;
import com.meditation.pojo.Book;
import com.meditation.pojo.BookPage;
import com.meditation.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

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

    @Autowired
    BookService bookService;

    @Autowired
    BookController bookController;
    @Test
    public void test(){


    }
}
