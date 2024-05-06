package Controller;

import DataAccessObject.DAO_SignUp;
import Model.SignUpModel;
import View.SignInForm;
import View.SignUpForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpController implements ActionListener, MouseListener {
    private SignUpForm signUp;
    public SignUpController(SignUpForm signUp){
        this.signUp = signUp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DAO_SignUp dao = new DAO_SignUp();
        // validate
        String userName = signUp.getTextField_Username().getText();
        String className = signUp.getTextField_Class().getText();
        String password = signUp.getPasswordField_Password().getText();
        String passwordConfirm = signUp.getPasswordField_PasswordConfirm().getText();



        //validate
        if(userName.isEmpty() || className.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!password.equals(passwordConfirm)){
            JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!isValidatePassword(password)){
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{

            int id = Integer.parseInt(signUp.getTextField_Id().getText());

            //tao doi tuong moi
            SignUpModel model = new SignUpModel(userName, id, className, password, passwordConfirm);
            if(dao.selectById(model) != null){
                JOptionPane.showMessageDialog(null, "Student ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                if(dao.insert(model) > 0){
                    JOptionPane.showMessageDialog(null, "Sign up successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    signUp.dispose();
                    SignInForm signIn = new SignInForm();
                    signIn.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Sign up failed", "Error", JOptionPane.ERROR_MESSAGE);
                    signUp.getTextField_Username().setText("");
                    signUp.getTextField_Id().setText("");
                    signUp.getTextField_Class().setText("");
                    signUp.getPasswordField_Password().setText("");
                    signUp.getPasswordField_PasswordConfirm().setText("");
                }
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID must be a number and cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        if(src instanceof JLabel){
            signUp.dispose();
            SignInForm signIn = new SignInForm();
            signIn.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object src = e.getSource();
        if(src instanceof JLabel){
            JLabel label = (JLabel) src;
            if(label == signUp.getLbl_LoginHere()){
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object src = e.getSource();
        if(src instanceof JLabel){
            JLabel label = (JLabel) src;
            if(label == signUp.getLbl_LoginHere()){
                label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

    //validate password
    private boolean isValidatePassword(String password){
        return password.length() >= 8 && password.length() <= 20;
    }


}
