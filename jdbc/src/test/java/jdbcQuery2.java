import java.sql.*;

public class jdbcQuery2
{
    public static void main(String[] args) {

        String jqu = new jdbcQuery2().login("美美","22");
    }

    String Dir = "com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/ssm?characterEncoding=UTF-8";
    String username="root";
    String password="root";

    Connection connt = null;
    PreparedStatement sta = null;
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
            String sql = "SELECT * FROM stu WHERE username= ? AND math= ?";
            sta = cont().prepareStatement(sql);
            sta.setString(1,username);
            sta.setString(2,password);
            resu = sta.executeQuery();
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
