package test;

import in.mediataion.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        DBUtil dbUtil = new DBUtil();
        String sql1 = "UPDATE bank SET money = money - ? WHERE username = ?";
        String sql2 = "UPDATE bank SET money = money + ? WHERE username = ?";
        Connection connt = dbUtil.getconnt();
        try {
            //手动执行事务
            connt.setAutoCommit(false);
            PreparedStatement pstm1 = connt.prepareStatement(sql1);
            pstm1.setInt(1,100);
            pstm1.setString(2,"张三");
            pstm1.executeUpdate();
            if (true){
                throw new Exception();
            }
            PreparedStatement pstm2 = connt.prepareStatement(sql2);
            pstm2.setInt(1,100);
            pstm2.setString(2,"李四");
            pstm2.executeUpdate();
            //提交事务
            connt.commit();
            dbUtil.closeconnt(pstm1);
            pstm2.close();
        } catch (Exception e) {
            //回滚提交事务
            connt.rollback();
            e.printStackTrace();
        }
    }
}
