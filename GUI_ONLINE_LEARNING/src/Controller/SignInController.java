package Controller;

import DataAccessObject.DAO_SignIn;
import Model.SignInModel;
import Model.Student;
import Model.UserSession;
import View.HomeMenu;
import View.SignInForm;
import View.SignUpForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class SignInController implements ActionListener, MouseListener {

    private SignInForm signIn;
    private DAO_SignIn dao;
    private Student user;

    public Student getUser() {
        return user;
    }

    public SignInController(SignInForm signIn){
        this.signIn = signIn;
        user = new Student(1,"","","","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        //database
        dao = new DAO_SignIn();

        if(signIn.getBtnSignIn().getText().equals(cmd)){

            String username = signIn.getTextField_Username().getText();
            String password = signIn.getPasswordField_Password().getText();

            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try{
                int id = Integer.parseInt(signIn.getTextField_Id().getText());

                //init model
                Student model = new Student(id, username, "", "", password);

                if(dao.selectById(model) != null) {
                    user = dao.selectById(model);
                    UserSession.getInstance(user);

                    signIn.dispose();
                    HomeMenu home =  new HomeMenu();
                    home.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                    signIn.getTextField_Username().setText("");
                    signIn.getTextField_Id().setText("");
                    signIn.getPasswordField_Password().setText("");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "ID must be a number and cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof JLabel){
            JLabel label = (JLabel) source;
            String cmd = label.getText();

            if(signIn.getLbl_LoginHere().getText().equals(cmd)){
                SignUpForm signUpForm = new SignUpForm();
                signUpForm.setVisible(true);
                signIn.dispose();
            }
//            if(label == signIn.getLbl_LoginHere()){
//                SignUpForm signUpForm = new SignUpForm();
//                signUpForm.setVisible(true);
//                signIn.dispose();
//            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
