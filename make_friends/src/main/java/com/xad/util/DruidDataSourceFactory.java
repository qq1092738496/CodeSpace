package com.xad.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/11 23:40
 */

public class DruidDataSourceFactory extends PooledDataSourceFactory {
    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init();
        } catch (SQLException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
        return this.dataSource;
    }
}
