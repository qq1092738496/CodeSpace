package in.mediataion.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.getconnt();
    }

    public Connection getconnt() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties per = new Properties();
        Connection connt = null;
        try {
            per.load(in);
            Class.forName(per.getProperty("driver"));
            connt = DriverManager.getConnection(per.getProperty("url"), per.getProperty("username"), per.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connt;
    }

    public void closeconnt(PreparedStatement pstm) {
        try {
            Connection connt = pstm.getConnection();
            if (pstm != null) {
                pstm.close();
                if (connt != null) {
                    connt.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
