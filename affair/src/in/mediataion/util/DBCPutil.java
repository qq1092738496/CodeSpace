package in.mediataion.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPutil {

    public static void main(String[] args) {
        DBCPutil dbcP = new DBCPutil();
        dbcP.connt();
    }

    public Connection connt() {
        InputStream in = DBCPutil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        Connection connt = null;
        try {
            pro.load(in);
            //创建dbcp连接池
            DataSource ds = BasicDataSourceFactory.createDataSource(pro);
            connt = ds.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connt;
    }

    public void closeupdata(ResultSet rs,PreparedStatement ps){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
