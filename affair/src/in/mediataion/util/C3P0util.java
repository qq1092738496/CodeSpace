package in.mediataion.util;

import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class C3P0util {
    public Connection getconnt() {
        Connection connt = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取非池化的数据源
            DataSource ds = DataSources.unpooledDataSource("jdbc:mysql://localhost:3306/ssm", "root", "root");
            //把非池数据源转换成池的数据源
            DataSource dataSource = DataSources.pooledDataSource(ds);

            connt = dataSource.getConnection();
            System.out.println(connt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connt;
    }
}

