import java.io.*;
import java.util.Properties;

public class JDBCDButil {
    public static void main(String[] args) throws Exception {
        BufferedInputStream buffinput = new BufferedInputStream(new FileInputStream("src\\db.properties"));
        Properties properties = new Properties();
        properties.load(buffinput);

        String driver = properties.getProperty("driver");
        System.out.println(driver);
    }
}
