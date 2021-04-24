import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Arrays;

public class jdbcupdate {

    String driver = "com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/ssm?characterEncoding=UTF-8";
    String username = "root";
    String password = "root";
    Connection connt = null;
    PreparedStatement pst = null;
    ResultSet resultSet = null;

    {
        try {
            Class.forName(driver);
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
    };

    @Test
    public void  bigdate(){
        connt = connt();
        try {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("E:\\百度云下载\\超级聊天术\\001.mp3"));
            /*byte[] bytes = new byte[1024*25];
            inputStream.read(bytes);*/

            String sql = "INSERT INTO bigdata (myblob) VALUES (?)";
            pst = connt.prepareStatement(sql);
            pst.setBinaryStream(1,inputStream);
            int i = pst.executeUpdate();
            System.out.println(i);
            inputStream.close();
            connt.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bigdateinsert(){
        connt = connt();
        String sql ="SELECT * FROM bigdata ";
        try {
            byte[] bytes = new byte[1024*25];
            pst = connt.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                bytes = resultSet.getBytes("myblob");
            }

            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("E:\\haha.mp4"));
            outputStream.write(bytes);

            connt.close();
            pst.close();
            resultSet.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
