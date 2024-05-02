package Controller;

import DataAccessObject.DAO_HomeMenu;
import Model.Student;
import Model.UserSession;
import View.App;
import View.HomeMenu;
import View.SignInForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomeController implements ActionListener {
    private HomeMenu home;
    private DAO_HomeMenu dao;
    private Student user;

    public Student getUser() {
        return user;
    }

    public HomeController(HomeMenu home){
        this.home = home;

        dao = new DAO_HomeMenu();
        user = UserSession.getInstance(null).getUser();

//        userSignedIn();
    }

    public void userSignedIn() {
        System.out.println("User ID: " + user.getId());
        System.out.println("Username: " + user.getUserName());
        System.out.println("Image Path: " + user.getImagePath());
        System.out.println("Class Name: " + user.getClassName());
        // Note: It's not recommended to print the password for security reasons
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == home.getBtnJoin()){
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to join this course?", "Join course", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                App app = new App();
                app.setVisible(true);
            }
        }
        else if(source == home.getBtnRollCall()){
            JOptionPane.showMessageDialog(null, "Starting roll call", "Roll call", JOptionPane.INFORMATION_MESSAGE);
            startRollCallThread();
        }
        else if(source == home.getBtnCourses()){
            JOptionPane.showMessageDialog(null, "This feature is under development", "Courses", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(source == home.getBtnProfile()){
            JOptionPane.showMessageDialog(null, "This feature is under development", "Profile", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(source == home.getBtnSetting()){
            JOptionPane.showMessageDialog(null, "This feature is under development", "Setting", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(source == home.getBtnLogout()){
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                home.dispose();
                SignInForm signIn = new SignInForm();
                signIn.setVisible(true);

                // Clean the user session
                UserSession.getInstance(null).cleanUserSession();
            }
        }
    }

    private void startRollCallThread(){
        if(home.getRollCallThread() == null || !home.getRollCallThread().isAlive()){
            System.out.println("Starting rollcall thread...");
            home.setRollCallThread(new Thread(() -> {
                try {
                    new PythonConnection.RollCall().start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
            home.getRollCallThread().start();
        }
    }
}
