package txtest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.meditation.pojo.information;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/9 21:28
 */
@ContextConfiguration(locations = "classpath:applicationcontext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Qualifier("sources")
    @Autowired
    DataSource Source;


    @Qualifier("jdbcTemplate")
    @Autowired
    JdbcTemplate jdbcTemplate;

    /*static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    @Autowired
    information information;

    @Autowired
    ComboPooledDataSource dataSource;

    //批量插入
    @Test
    public void test3() {
        String sql = "INSERT INTO message (title,companyName,companymessage,education,time,site,money,workmessage," +
                "url,source) VALUES (?,?,?,?,?,?,?,?,?,?)";

        information.setCompanymessage("哈哈");
        information.setCompanyName("呵呵");
        information.setEducation("嘿嘿");
        information.setMoney("嘻嘻");
        information.setSite("吼吼");
        information.setSource("呱呱");
        information.setTime("呜呜");
        information.setTitle("啧啧");
        information.setUrl("略略");
        information.setWorkmessage("嘀嘀");
        System.out.println(information);
        List<Object[]> list = new ArrayList<Object[]>();

        list.add(new Object[]{information.getCompanymessage(),
                information.getCompanyName(),
                information.getEducation(),
                information.getMoney(),
                information.getSite(),
                information.getSource(),
                information.getTime(),
                information.getTitle(),
                information.getUrl(),
                information.getWorkmessage()});
        list.add(new Object[]{information.getCompanymessage(),
                information.getCompanyName(),
                information.getEducation(),
                information.getMoney(),
                information.getSite(),
                information.getSource(),
                information.getTime(),
                information.getTitle(),
                information.getUrl(),
                information.getWorkmessage()});
        list.add(new Object[]{information.getCompanymessage(),
                information.getCompanyName(),
                information.getEducation(),
                information.getMoney(),
                information.getSite(),
                information.getSource(),
                information.getTime(),
                information.getTitle(),
                information.getUrl(),
                information.getWorkmessage()});
        //传入一个list , 集合中有每个数组代表一条sql语句
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }

    //修改数据
    @Test
    public void test2() {
        String sql = "\n" +
                "UPDATE 51job.message SET " +
                "title = ?," +
                "companyName = ?," +
                "companymessage = ?, " +
                "education = ?," +
                "time = ?," +
                "site = ?," +
                "money = ?," +
                "workmessage = ?," +
                "url= ?," +
                "source = ?" +
                "WHERE " +
                "id = ?;";

        information.setId(2);
        information.setCompanymessage("哈哈哈");
        information.setCompanyName("哈哈");
        information.setEducation("哈哈");
        information.setMoney("哈哈");
        information.setSite("哈哈");
        information.setSource("哈哈");
        information.setTime("哈哈");
        information.setTitle("哈哈");
        information.setUrl("哈哈");
        information.setWorkmessage("哈哈");
        int update = jdbcTemplate.update(sql, information.getCompanymessage(),
                information.getCompanyName(),
                information.getEducation(),
                information.getMoney(),
                information.getSite(),
                information.getSource(),
                information.getTime(),
                information.getTitle(),
                information.getUrl(),
                information.getWorkmessage(),
                information.getId());
        System.out.println(update);

    }

    @Test
    public void test() {
        try {
            Connection connection = Source.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       /*Connection connection = null;
        try {
            connection = dataSource.getConnection();
        System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
