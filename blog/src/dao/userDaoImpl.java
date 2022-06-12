package dao;

import pojo.user;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 12:45
 */

public class userDaoImpl implements userDao {
    DBUtil db = new DBUtil();

    @Override
    public void add(user user) {
        Connection connection = db.getConnection();
        String sql = "INSERT INTO user(userName,passWord,fullName,Student_ID,mailbox) values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getStudent_ID());
            preparedStatement.setString(5, user.getMailbox());
            preparedStatement.execute();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    @Override
    public void delete(String userName) {
        Connection connection = db.getConnection();
        String sql = "DELETE FROM user WHERE userName=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.execute();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(user user) {
        Connection connection = db.getConnection();
        String sql = "UPDATE user SET passWord=?,fullName=?,Student_ID=?,mailbox=? WHERE userName=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassWord());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getStudent_ID());
            preparedStatement.setString(4, user.getMailbox());
            preparedStatement.setString(5, user.getUserName());
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<user> AllUser() {
        Connection connection = db.getConnection();
        String sql = "SELECT * FROM user";
        LinkedList<user> users = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                user user = new user();
                user.setUserName(res.getString("userName"));
                user.setPassWord(res.getString("passWord"));
                user.setFullName(res.getString("fullName"));
                user.setStudent_ID(res.getString("Student_ID"));
                user.setMailbox(res.getString("mailbox"));
                users.add(user);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public user getuser(String userName) {
        Connection connection = db.getConnection();
        String sql = "SELECT * FROM user WHERE userName= ?";
        user user = new user();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                user.setUserName(res.getString("userName"));
                user.setPassWord(res.getString("passWord"));
                user.setFullName(res.getString("fullName"));
                user.setStudent_ID(res.getString("Student_ID"));
                user.setMailbox(res.getString("mailbox"));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
