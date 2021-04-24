package com.meditation.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc {
    String path = this.getClass().getClassLoader().getResource("jebc.properties").getPath();
    Properties properties = new Properties();
    private Connection connection;

    {
        try {
            FileInputStream inputStream = new FileInputStream(new File(path));
            properties.load(inputStream);
            Class.forName(properties.get("Driver").toString());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            FileInputStream inputStream = new FileInputStream(new File(path));
            properties.load(inputStream);
            connection = DriverManager.getConnection(properties.get("addurl").toString(), properties.get("username").toString(), properties.get("password").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void close(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        jdbc jdbc = new jdbc();
        jdbc.getConnection();
    }

}
