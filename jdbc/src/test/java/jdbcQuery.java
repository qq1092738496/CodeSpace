import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import jdk.nashorn.internal.objects.annotations.Where;

import java.sql.*;
import java.util.List;

public class jdbcQuery
{
    public static void main(String[] args) {
       String jqu = new jdbcQuery().login("美美","1' or '2 == 2  ");
    }

    String Dir = "com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/ssm?characterEncoding=UTF-8";
    String username="root";
    String password="root";

    Connection connt = null;
    Statement stem = null;
    ResultSet resu = null;

    boolean isExsit = false;


    {
        try {
            Class.forName(Dir);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection cont(){
        try {
           connt = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connt;
    }

    public  String login(String username,String password){
        try {
            String sql = "SELECT * FROM stu WHERE username='"+username+"' AND math= '"+password+"'";
            stem = cont().createStatement();
            resu = stem.executeQuery(sql);
            isExsit = resu.next();
            if (isExsit == true){
                System.out.println("登陆成功");
            }else if(isExsit == false){
                System.out.println("登陆失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
