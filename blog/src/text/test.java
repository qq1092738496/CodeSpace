package text;

import dao.userDao;
import dao.userDaoImpl;
import org.junit.Test;
import pojo.user;
import service.business;
import service.businessImpl;
import util.DBUtil;

import java.sql.Connection;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 12:40
 */

public class test {
    @Test
    public void test1(){
        user user = new user("3","3","1","1","1");
        business businewss = new businessImpl();
        businewss.Register("8987", "4546", "545646");

    }
}
