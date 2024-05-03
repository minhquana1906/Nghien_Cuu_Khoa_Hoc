package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/onlinelearningdb";
    private static String username = "root";
    private static String password = "minhquan2004";
    public static Connection mycon() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            //tao nguoi dung moi voi role mac dinh la app_user
//            createUser(con, "new_user", "password");
//
//            //cap quyen cho app_user
//            grantPrivileges(con, "new_user", "onlinelearningdb.studentlist");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }

//    private static void createUser(Connection con, String userName, String password){
////        String hashedPassword = hashPassword(password);
//        String createUser = "CREATE USER " + userName + " IDENTIFIED BY '" + password + "' DEFAULT ROLE 'app_user'";
//        try{
//            Statement st = con.createStatement();
//            st.execute(createUser);
//            System.out.println("Recent query: "+createUser);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    private static void grantPrivileges(Connection con, String roleName, String tableName){
//        String grantPrivileges = "GRANT SELECT, INSERT ON  " + tableName + "TO " + roleName;
//        try{
//            Statement st = con.createStatement();
//            st.execute(grantPrivileges);
//            System.out.println("Recent query: "+grantPrivileges);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private void hashPassword(String password){
//        int rounds = 12;
//        return BCrypt.hashpw(password, BCrypt.gensalt(rounds));
//    }
}