package DataAccessObject;

import Model.Student;
import database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_HomeMenu implements DAOInterface<Student> {
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
    public ArrayList<Student> selectAll() {
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
            String query = "SELECT * FROM studentList WHERE id = " + obj.getId();

//            System.out.println("Recent query: "+query);
            res = st.executeQuery(query);
            while(res.next()){
                int id = res.getInt("id");
                String username = res.getString("username");
                String password = res.getString("password");
                String imagePath = res.getString("imagepath");
                String className = res.getString("classname");

                model = new Student(id, username, className, imagePath, password);
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
    public ArrayList<Student> selectByCondition(String condition) {
        return null;
    }
}
