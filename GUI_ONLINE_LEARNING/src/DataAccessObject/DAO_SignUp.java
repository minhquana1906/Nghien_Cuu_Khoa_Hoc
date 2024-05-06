package DataAccessObject;

import Model.SignUpModel;
import MyInterface.DAOInterface;
import database.Database;
import org.mindrot.bcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;

public class DAO_SignUp implements DAOInterface<SignUpModel> {

    public DAO_SignUp getInstance(){
        return new DAO_SignUp();
    }

    @Override
    public int insert(SignUpModel obj) {
        int changes = 0;
        Connection con = null;
        Statement st = null;
        try{
            con = Database.mycon();
            st = con.createStatement();

            String hashed = BCrypt.hashpw(obj.getPassword(), BCrypt.gensalt(12));


            String query = "INSERT INTO studentList (id, username, classname, password) VALUES " +
                    "("+ obj.getId() + ", '" + obj.getUsername() + "', '" + obj.getClassName() + "', '" + hashed + "')";

            changes = st.executeUpdate(query);
            System.out.println("Recent query: "+query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        return changes;
    }

    @Override
    public int update(SignUpModel obj) {
        return 0;
    }

    @Override
    public int delete(SignUpModel obj) {
        return 0;
    }

    @Override
    public ArrayList<SignUpModel> selectAll() {
        return null;
    }

    @Override
    public SignUpModel selectById(SignUpModel obj) {
        SignUpModel model = null;
        Statement st = null;
        ResultSet res = null;
        Connection con = Database.mycon();
        try{
            con = Database.mycon();
            st = con.createStatement();
            String query = "SELECT * FROM studentList WHERE id = '" + obj.getId() + "'";

            res = st.executeQuery(query);

            while(res.next()){
                int id = Integer.parseInt(res.getString("id"));
                String username = res.getString("username");
                String className = res.getString("className");
                String password = res.getString("password");

                model = new SignUpModel(username, id, className, password, password);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(res != null)
                    res.close();
                if(st != null)
                    st.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public ArrayList<SignUpModel> selectByCondition(String condition) {
        return null;
    }
}
