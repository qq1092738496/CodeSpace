package test;

import in.mediataion.util.DBCPutil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {
    public static void main(String[] args) {
        DBCPutil dbcPutil = new DBCPutil();
        Connection connt = dbcPutil.connt();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connt.prepareStatement("SELECT * FROM bank");
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("username"));
                System.out.println(rs.getBigDecimal("money"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
