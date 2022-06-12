package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 12:12
 */

public class DBUtil {
    private String url = "jdbc:mysql://localhost:3306/my_blog?characterEncoding=UTF-8";
    private String username = "root";
    private String password = "root";

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection cont = null;
        try {
            cont = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cont;
    }


}
