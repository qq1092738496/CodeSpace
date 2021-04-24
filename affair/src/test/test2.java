package test;

import in.mediataion.util.C3P0util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test2 {
    public static void main(String[] args) {
        C3P0util c3P0util = new C3P0util();
        Connection connt = c3P0util.getconnt();
        ResultSet res = null;
        PreparedStatement pst = null;
        try {
            String sql = "SELECT * FROM bank";
            pst = connt.prepareStatement(sql);
            res = pst.executeQuery();
            while (res.next()){
                System.out.println("账户卡号:"+res.getBigDecimal("account")+"      " +
                        "用户姓名:"+res.getString("username")+"      " +
                        "账户金额:"+res.getBigDecimal("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (res != null){
                    res.close();
                }
                if (pst != null){
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
