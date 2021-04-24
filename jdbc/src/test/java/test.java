import dao.isgd;
import dao.isgdimpl;
import org.junit.Test;
import pojo.grade;
import util.jdbc;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        isgd isgd = new isgdimpl();
        int re = 0;
        try {
            grade grade = new grade("哈哈啊",22,22,2);
            isgd.insert(grade);

           /* List<grade> list  = isgd.select();
            for (grade grade : list) {
                System.out.println(grade);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(re);

    }

    @Test
    public void test() {
        System.out.println("22");
    }
}
