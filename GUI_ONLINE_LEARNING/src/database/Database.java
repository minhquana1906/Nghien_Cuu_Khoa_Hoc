package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/login";
    private static String username = "root";
    private static String password = "minhquan2004";
    public static Connection mycon() {
        Connection con = null;
        try {
            // load the driver
            Class.forName(driver);
            //create connection
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}