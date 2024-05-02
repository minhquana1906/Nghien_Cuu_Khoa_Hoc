package DataAccessObject;

import Model.Student;
import database.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_SignIn implements DAOInterface<Student>{

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
            String query = "SELECT * FROM studentList WHERE username = '" + obj.getUserName() + "' AND id = " + obj.getId() + " AND password = '" + obj.getPassword() + "' " ;

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
    public ArrayList selectByCondition(String condition) {
        ArrayList<Student> lst = null;
        Student model = null;
        Connection con = null;
        Statement st = null;
        ResultSet res = null;
        try{
            con = Database.mycon();
            st = con.createStatement();
            String query = "SELECT * FROM studentList WHERE username = ? AND id = ? AND password = ?";

            res = st.executeQuery(query);
            while(res.next()){
                int id = Integer.parseInt(res.getString("id"));
                String username = res.getString("username");
                String password = res.getString("password");
                String className = res.getString("classname");
                String imagePath = res.getString("imagepath");

                model = new Student(id, username, className, imagePath, password);
                lst.add(model);
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
        return null;
    }
}
