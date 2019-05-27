package classLoader;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDriver {
    public static void main(String args[]) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yjc", "root", "123456");
    }
}
