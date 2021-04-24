import org.junit.Test;

import java.sql.*;
import java.util.Date;

public class jdbctime {
    public static void main(String[] args) {
        new jdbctime().Time_test();
    }

    String dri = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ssm?characterEncoding=UTF-8";
    String username = "root";
    String password = "root";
    Connection connt = null;
    PreparedStatement pstame = null;
    ResultSet resut = null;

    {
        try {
            Class.forName(dri);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection connt(){
        try {
           connt = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connt;
    }

    @Test
    public void Time_test() {
        Date date = new Date();

        String sql = "INSERT INTO time_test  VALUES (?,?,?)";
        try {
            pstame = connt().prepareStatement(sql);

            pstame.setDate(1,new java.sql.Date(date.getTime()));
            pstame.setTime(2,new Time(date.getTime()));
            pstame.setTimestamp(3, new Timestamp(date.getTime()));
            pstame.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selecttime(){
        String sql = "SELECT * FROM time_test WHERE my_date = ?";
        try {
            Date date = new Date();
            pstame = connt().prepareStatement(sql);
            pstame.setDate(1,new java.sql.Date(date.getTime()));
            resut = pstame.executeQuery();
            while (resut.next()){
                java.sql.Date datej = resut.getDate("my_date");
                Time time = resut.getTime("my_time");
                Timestamp times = resut.getTimestamp("my_timetamp");

                System.out.println("日期:"+datej+" 时分秒:"+time+"  时间戳:"+times);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
