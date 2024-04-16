package View;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;

public class SignInForm extends JFrame {
    private Dimension FRAME_SIZE;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JPanel panel_Main;
    private JPanel panel_Main_Header;
    private JPanel panel_Main_Center;
    private JPanel panel_Logo;
    private JLabel lbl_Logo;
    private JPanel panel_Main_Padding1;
    private JPanel panel_Main_Padding2;

    private JLabel lbl_Username;
    private JTextField textField_Username;
    private JLabel lbl_Id;
    private JTextField textField_Id;
    private JLabel lbl_Password;
    private JPasswordField passwordField_Password;
    private JPanel panel_UsernameContainer;
    private JLabel lbl_UserIcon;
    private JPanel panel_PasswordContainer;
    private JPanel panel_IdContainer;
    private JLabel lbl_IdIcon;
    private JLabel lbl_PasswordIcon;
    private JPanel panel_MainFooter;
    private JPanel panel_FooterPadding;
    private JPanel panel_ButtonSignUp;
    public JButton btnSignIn;
    private JPanel panel_RememberMe;
    private JPanel panel_SignUpOption;
    private JLabel lbl_HaveAccount;
    private JLabel lbl_LoginHere;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignInForm frame = new SignInForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SignInForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(SignInForm.class.getResource("/Icon/Logo/login.png")));
        setTitle("Sign In ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 585);
        setLocationRelativeTo(null);
        setResizable(false);
        //get size of frame
        FRAME_SIZE = this.getSize();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0,0,0,0));

        setContentPane(contentPane);

        this.init();

    }

    void init() {
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        panel_Main = new JPanel();
        panel_Main.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.1)));
        contentPane.add(panel_Main);
        panel_Main.setLayout(new BorderLayout(0, 0));

//		System.out.println(FRAME_SIZE);

        panel_Main_Header = new JPanel();
        panel_Main_Header.setBackground(new Color(255, 255, 255));
        panel_Main_Header.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.2)));
        panel_Main.add(panel_Main_Header, BorderLayout.NORTH);
        panel_Main_Header.setLayout(null);

        panel_Logo = new JPanel();
        panel_Logo.setBackground(new Color(255, 255, 255));
        FlowLayout fl_panel_Logo = (FlowLayout) panel_Logo.getLayout();
        fl_panel_Logo.setHgap(0);
        fl_panel_Logo.setVgap(0);
        panel_Logo.setBounds(0, 0, 258, 68);
        panel_Main_Header.add(panel_Logo);

        lbl_Logo = new JLabel("App's name");
        lbl_Logo.setIcon(new ImageIcon(SignInForm.class.getResource("/Icon/Logo/eye.png")));
        lbl_Logo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Logo.add(lbl_Logo);

        JLabel lbl_Title = new JLabel("Sign In");
        lbl_Title.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbl_Title.setBounds(53, 79, 74, 29);
        panel_Main_Header.add(lbl_Title);

        Dimension leftPanelSize = panel_Main.getPreferredSize();
        panel_Main_Padding1 = new JPanel();
        panel_Main_Padding1.setBackground(new Color(255, 255, 255));
        panel_Main_Padding1.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.1), (int)(leftPanelSize.getHeight())));
        panel_Main.add(panel_Main_Padding1, BorderLayout.WEST);

        panel_Main_Padding2 = new JPanel();
        panel_Main_Padding2.setBackground(new Color(255, 255, 255));
        panel_Main_Padding2.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.1), (int)(leftPanelSize.getHeight())));
        panel_Main.add(panel_Main_Padding2, BorderLayout.EAST);

        System.out.println(panel_Main_Padding1.getPreferredSize());

        System.out.println(panel_Main.getPreferredSize().getWidth());
        System.out.println(panel_Main_Padding1.getPreferredSize().getWidth());
        System.out.println(FRAME_SIZE.getHeight()*0.4);
//System.out.println();
//System.out.println();
        panel_Main_Center = new JPanel();
        panel_Main_Center.setBackground(new Color(255, 255, 255));
        panel_Main.add(panel_Main_Center, BorderLayout.CENTER);
//        panel_Main.setPreferredSize(new Dimension((int)(panel_Main.getPreferredSize().getWidth() - panel_Main_Padding1.getPreferredSize().getWidth() * 2),(int)(FRAME_SIZE.getHeight()*0.4)));
        panel_Main_Center.setPreferredSize(new Dimension(424, 256));
        GridLayout gl_panel_Main_Center = new GridLayout(4, 1);
//        gl_panel_Main_Center.setVgap(20);
        panel_Main_Center.setLayout(gl_panel_Main_Center);

        JPanel panel_Username = new JPanel();
        panel_Username.setBackground(new Color(255, 255, 255));
        panel_Main_Center.add(panel_Username);
        panel_Username.setLayout(new BoxLayout(panel_Username, BoxLayout.Y_AXIS));

        lbl_Username = new JLabel("Username");
        lbl_Username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Username.add(lbl_Username);

        panel_UsernameContainer = new JPanel();
        panel_UsernameContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_UsernameContainer.setBackground(new Color(255, 255, 255));
        panel_Username.add(panel_UsernameContainer);
        panel_UsernameContainer.setLayout(new BoxLayout(panel_UsernameContainer, BoxLayout.X_AXIS));

        lbl_UserIcon = new JLabel("");
        lbl_UserIcon.setIcon(new ImageIcon(SignInForm.class.getResource("/Icon/Login_SignUp/profile.png")));
        panel_UsernameContainer.add(lbl_UserIcon);

        textField_Username = new JTextField();
        textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_UsernameContainer.add(textField_Username);
        textField_Username.setColumns(10);


        JPanel panel_Id = new JPanel();
        panel_Id.setBackground(new Color(255, 255, 255));
        panel_Main_Center.add(panel_Id);
        panel_Id.setLayout(new BoxLayout(panel_Id, BoxLayout.Y_AXIS));

        lbl_Id = new JLabel("Student's ID");
        lbl_Id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Id.add(lbl_Id);

        panel_IdContainer = new JPanel();
        panel_IdContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_IdContainer.setBackground(new Color(255, 255, 255));
        panel_Id.add(panel_IdContainer);
        panel_IdContainer.setLayout(new BoxLayout(panel_IdContainer, BoxLayout.X_AXIS));

        lbl_IdIcon = new JLabel("");
        lbl_IdIcon.setIcon(new ImageIcon(SignInForm.class.getResource("/Icon/Login_SignUp/id.png")));
        panel_IdContainer.add(lbl_IdIcon);

        textField_Id = new JTextField();
        textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_IdContainer.add(textField_Id);
        textField_Id.setColumns(10);

        JPanel panel_Password = new JPanel();
        panel_Password.setBackground(new Color(255, 255, 255));
        panel_Main_Center.add(panel_Password);
        panel_Password.setLayout(new BoxLayout(panel_Password, BoxLayout.Y_AXIS));

        lbl_Password = new JLabel("Password");
        lbl_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Password.add(lbl_Password);

        panel_PasswordContainer = new JPanel();
        panel_PasswordContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_PasswordContainer.setBackground(new Color(255, 255, 255));
        panel_Password.add(panel_PasswordContainer);
        panel_PasswordContainer.setLayout(new BoxLayout(panel_PasswordContainer, BoxLayout.X_AXIS));

        lbl_PasswordIcon = new JLabel("\r\n");
        lbl_PasswordIcon.setIcon(new ImageIcon(SignInForm.class.getResource("/Icon/Login_SignUp/password.png")));
        panel_PasswordContainer.add(lbl_PasswordIcon);

        passwordField_Password = new JPasswordField();
        passwordField_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_PasswordContainer.add(passwordField_Password);

        panel_RememberMe = new JPanel();
        panel_RememberMe.setBackground(new Color(255, 255, 255));
        panel_Main_Center.add(panel_RememberMe);
        panel_RememberMe.setLayout(null);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
        chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        chckbxNewCheckBox.setBounds(6, 18, 129, 23);
        panel_RememberMe.add(chckbxNewCheckBox);

        panel_MainFooter = new JPanel();
        panel_MainFooter.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.25)));
        panel_Main.add(panel_MainFooter, BorderLayout.SOUTH);
        panel_MainFooter.setLayout(new BorderLayout(0, 0));

        panel_FooterPadding = new JPanel();
        panel_FooterPadding.setBackground(new Color(255, 255, 255));
        panel_FooterPadding.setPreferredSize(new Dimension((int)(panel_MainFooter.getPreferredSize().getWidth()*0.5), (int)(panel_MainFooter.getPreferredSize().getHeight() * 0.3)));
        panel_MainFooter.add(panel_FooterPadding, BorderLayout.SOUTH);
        panel_FooterPadding.setLayout(null);

        panel_ButtonSignUp = new JPanel();
        panel_ButtonSignUp.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout = (FlowLayout) panel_ButtonSignUp.getLayout();
//        flowLayout.setVgap(15);
        panel_MainFooter.add(panel_ButtonSignUp, BorderLayout.NORTH);

        btnSignIn = new JButton("Sign In");
        btnSignIn.setForeground(new Color(255, 255, 255));
        btnSignIn.setBackground(new Color(0, 0, 0));
        btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSignIn.setFocusable(false);
        btnSignIn.setPreferredSize(new Dimension((int)(panel_MainFooter.getPreferredSize().getWidth()*0.65), (int)(panel_MainFooter.getPreferredSize().getHeight() * 0.3)));
        btnSignIn.setFocusable(false);
        panel_ButtonSignUp.add(btnSignIn);

        panel_SignUpOption = new JPanel();
        panel_SignUpOption.setBackground(Color.WHITE);
        panel_MainFooter.add(panel_SignUpOption, BorderLayout.CENTER);
        panel_SignUpOption.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));

        lbl_HaveAccount = new JLabel("Don't have an account yet?");
        lbl_HaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_SignUpOption.add(lbl_HaveAccount);

        lbl_LoginHere = new JLabel("Sign Up here");
        lbl_LoginHere.setForeground(new Color(0, 128, 255));
        lbl_LoginHere.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbl_LoginHere.setAlignmentX(1.0f);
        panel_SignUpOption.add(lbl_LoginHere);

        //validate
        btnSignIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String username = textField_Username.getText();
                String id = textField_Id.getText();
                String password = passwordField_Password.getText();

                if(username.isEmpty() || id.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    if(check(username, id, password)) {
                        dispose();
                        HomeMenu home =  new HomeMenu();
                        home.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                        textField_Username.setText("");
                        textField_Id.setText("");
                        passwordField_Password.setText("");
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        panel_SignUpOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mousePressed(e);
                dispose();
                SignUpForm signUp = new SignUpForm();
                signUp.setVisible(true);
            }
        });

    }

    private boolean checkPassword(String username, String id, String password) throws SQLException {
        Connection con = database.Database.mycon();
        ResultSet res = null;

        if(con != null) {
            try {
                String query = "Select password from studentlist where username = ? and id = ?";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, username);
                ps.setString(2, id);

                res = ps.executeQuery();
                if(res.next()) {
                    String pass = res.getString("password");
                    if(pass.equals(password)) {
                        return true;
                    }
                }

            } finally {
                if(res != null){
                    res.close();
                }
                if(con != null){
                    con.close();
                }
            }
        }
        return false;
    }

    private boolean check(String username, String id, String password) throws SQLException {
        Connection con = database.Database.mycon();
        ResultSet res = null;
//    	PreparedStatement ps = null;

        if(con != null) {
            try {
                String query = "Select * from studentlist where username = ? and id = ? and password = ?";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, username);
                ps.setString(2, id);
                ps.setString(3, password);

                res = ps.executeQuery();
                if(res.next()) {
                    //ton tai gia tri trong db
                    return true;
                }
            } finally {
                if(res != null) {
                    res.close();
                }
//    			if(ps != null) {
//    				ps.close();
//    			}
                if(con != null) {
                    con.close();
                }
            }
        }
        return false;
    }

//    private boolean check(String username, String id, String password) {
//    	// call connection
//        Connection connection = database.Database.mycon();
//
//        if (connection != null) {
//            // if connection thanh cong
//            try {
//            	//Dấu ? là một tham số được sử dụng để tránh tình trạng SQL injection và sẽ được thay thế bằng giá trị thực tế trong bước tiếp theo.
//            	String query = "Select * from studentlist where username = ? and id = ? and password = ?";
//                //make a statement
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                //Đây là cách bạn thiết lập giá trị cho tham số thứ nhất trong câu truy vấn. Trong trường hợp này, tham số thứ nhất là UserName, và giá trị của nó sẽ là giá trị của biến username.
//                preparedStatement.setString(1, username);
//                preparedStatement.setString(2, id);
//                preparedStatement.setString(3, password);
//
//                //save data in resultSet
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                // if co result tra ve
//                if (resultSet.next()) {
//                    return true;
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            } finally {
//                try {
//                    connection.close(); // dong ket noi sau khi su dung
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//
//        return false; // Thất bại nếu có vấn đề với kết nối hoặc không có bản ghi phù hợp
//    }
}
