package com.meditation.dao.impl;


import com.meditation.dao.modify;
import com.meditation.pojo.message;
import com.meditation.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyimpl implements modify {
    private jdbc jdbc;
    private Connection connection;

    @Override
    public Integer Insert(message message) {
        String sql = "INSERT INTO message (title,companyName,companymessage,education,time,site,money,workmessage,url,source)VALUES " +
                "(?,?,?,?,?,?,?,?,?,?)";
        Integer in = null;
        try {
            jdbc = new jdbc();
            connection = jdbc.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getTitle());
            preparedStatement.setString(2,message.getCompanyName());
            preparedStatement.setString(3,message.getCompanymessage());
            preparedStatement.setString(4,message.getEducation());
            preparedStatement.setString(5,message.getTime());
            preparedStatement.setString(6,message.getSite());
            preparedStatement.setString(7,message.getMoney());
            preparedStatement.setString(8,message.getWorkmessage());
            preparedStatement.setString(9,message.getUrl());
            preparedStatement.setString(10,message.getSource());
            in = preparedStatement.executeUpdate();

            jdbc.close(this.connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return in;
    }
    @Override
    public Integer Insert2(message message) {
        String sql = "INSERT INTO message_java (title,companyName,companymessage,education,time,site,money," +
                "workmessage,url,source)VALUES " +
                "(?,?,?,?,?,?,?,?,?,?)";
        Integer in = null;
        try {
            jdbc = new jdbc();
            connection = jdbc.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,message.getTitle());
            preparedStatement.setString(2,message.getCompanyName());
            preparedStatement.setString(3,message.getCompanymessage());
            preparedStatement.setString(4,message.getEducation());
            preparedStatement.setString(5,message.getTime());
            preparedStatement.setString(6,message.getSite());
            preparedStatement.setString(7,message.getMoney());
            preparedStatement.setString(8,message.getWorkmessage());
            preparedStatement.setString(9,message.getUrl());
            preparedStatement.setString(10,message.getSource());
            in = preparedStatement.executeUpdate();

            jdbc.close(this.connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return in;
    }

}
