package DataAccessObject;

import Model.Student;
import MyInterface.DAOInterface;
import database.Database;
import org.mindrot.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_SignIn implements DAOInterface<Student> {

    public DAO_SignIn getInstance(){
        return new DAO_SignIn();
    }
    @Override
    public int insert(Student obj) {

        return 0;
    }

    @Override
    public int update(Student obj) {
        return 0;
    }

    @Override
    public int delete(Student obj) {
        return 0;
    }

    @Override
    public ArrayList selectAll() {
        return null;
    }

    @Override
    public Student selectById(Student obj) {
        Student model = null;
        Connection con = null;
        Statement st = null;
        ResultSet res = null;
        try{
            con = Database.mycon();
            st = con.createStatement();

            String query = "SELECT * FROM studentList WHERE username = '" + obj.getUserName() + "' AND id = " + obj.getId();

            System.out.println("Recent query: "+query);
            res = st.executeQuery(query);
            while(res.next()){
                int id = res.getInt("id");
                String username = res.getString("username");
                String hashedPassword = res.getString("password");
                String imagePath = res.getString("imagepath");
                String className = res.getString("classname");

                // Check if the plaintext password matches the hashed password
                if (BCrypt.checkpw(obj.getPassword(), hashedPassword)) {
                    model = new Student(id, username, className, imagePath, hashedPassword);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(res != null){
                    res.close();
                }
                if(st != null){
                    st.close();
                }
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return model;
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        return null;
    }
}
