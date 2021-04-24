package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    Connection  connt = null;
    static String driver ="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/ssm?characterEncoding=UTF-8";
    String username="root";
    String password="root";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection connt(){

        try {

            connt = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connt;
    }
}
