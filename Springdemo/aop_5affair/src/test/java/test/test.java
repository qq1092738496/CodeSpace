package test;

import com.meditation.dao.bookdao;
import com.meditation.service.checkout;
import com.meditation.service.spread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/10 19:40
 */

@ContextConfiguration(locations = "classpath:ioc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    checkout checkout;

    @Autowired
    bookdao bookdao;

    @Autowired
    spread spread;

    @Test
    public void test()  {
       checkout.payments("张三","ISBN-001");
    }
}
