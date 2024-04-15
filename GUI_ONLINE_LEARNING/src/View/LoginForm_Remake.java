package View;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginForm_Remake extends JFrame {
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
    private JPanel panel_SignUpOption;
    private JPanel panel_LoginOption;
    private JLabel lbl_HaveAccount;
    private JLabel lbl_LoginHere;
    private JPanel panel_FooterPadding;
    private JPanel panel_ButtonSignUp;
    public JButton btnSignup;
    private JPanel panel;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginForm_Remake frame = new LoginForm_Remake();
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
    public LoginForm_Remake() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 640);
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
        lbl_Logo.setIcon(new ImageIcon(LoginForm_Remake.class.getResource("/Icon/Logo/eye.png")));
        lbl_Logo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Logo.add(lbl_Logo);

        JLabel lbl_Title = new JLabel("Login");
        lbl_Title.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbl_Title.setBounds(53, 79, 55, 29);
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
        panel_Main_Center = new JPanel();
        panel_Main_Center.setBackground(new Color(255, 255, 255));
        panel_Main.add(panel_Main_Center, BorderLayout.CENTER);
//        panel_Main.setPreferredSize(new Dimension((int)(panel_Main.getWidth() - panel_Main_Padding1.getWidth() * 2),(int)(FRAME_SIZE.getHeight()*0.4)));
        GridLayout gl_panel_Main_Center = new GridLayout(4, 1);
        gl_panel_Main_Center.setVgap(20);
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
        lbl_UserIcon.setIcon(new ImageIcon(LoginForm_Remake.class.getResource("/Icon/Login_SignUp/profile.png")));
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
        lbl_IdIcon.setIcon(new ImageIcon(LoginForm_Remake.class.getResource("/Icon/Login_SignUp/id.png")));
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
        lbl_PasswordIcon.setIcon(new ImageIcon(LoginForm_Remake.class.getResource("/Icon/Login_SignUp/password.png")));
        panel_PasswordContainer.add(lbl_PasswordIcon);

        passwordField_Password = new JPasswordField();
        passwordField_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_PasswordContainer.add(passwordField_Password);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel_Main_Center.add(panel);
        panel.setLayout(null);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
        chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        chckbxNewCheckBox.setBounds(6, 7, 129, 23);
        panel.add(chckbxNewCheckBox);

        panel_MainFooter = new JPanel();
        panel_MainFooter.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.18)));
        panel_Main.add(panel_MainFooter, BorderLayout.SOUTH);
        panel_MainFooter.setLayout(new BorderLayout(0, 0));

        panel_SignUpOption = new JPanel();
        panel_SignUpOption.setBackground(Color.WHITE);
        panel_MainFooter.add(panel_SignUpOption);
        panel_SignUpOption.setLayout(new BorderLayout(0, 0));

        panel_LoginOption = new JPanel();
        panel_LoginOption.setBackground(Color.WHITE);
        panel_SignUpOption.add(panel_LoginOption, BorderLayout.CENTER);
        panel_LoginOption.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));

        lbl_HaveAccount = new JLabel("Don't have an account yet?");
        lbl_HaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_LoginOption.add(lbl_HaveAccount);

        lbl_LoginHere = new JLabel("Sign Up here");
        lbl_LoginHere.setForeground(new Color(0, 128, 255));
        lbl_LoginHere.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbl_LoginHere.setAlignmentX(1.0f);
        panel_LoginOption.add(lbl_LoginHere);

        panel_FooterPadding = new JPanel();
        panel_FooterPadding.setBackground(new Color(255, 255, 255));
        panel_FooterPadding.setPreferredSize(new Dimension((int)(panel_MainFooter.getPreferredSize().getWidth()*0.5), (int)(panel_MainFooter.getPreferredSize().getHeight() * 0.3)));
        panel_MainFooter.add(panel_FooterPadding, BorderLayout.SOUTH);
        panel_FooterPadding.setLayout(null);

        panel_ButtonSignUp = new JPanel();
        panel_ButtonSignUp.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout = (FlowLayout) panel_ButtonSignUp.getLayout();
        flowLayout.setVgap(15);
        panel_MainFooter.add(panel_ButtonSignUp, BorderLayout.NORTH);

        btnSignup = new JButton("Sign Up");
        btnSignup.setForeground(new Color(255, 255, 255));
        btnSignup.setBackground(new Color(0, 0, 0));
        btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSignup.setFocusable(false);
        btnSignup.setPreferredSize(new Dimension((int)(panel_MainFooter.getPreferredSize().getWidth()*0.65), (int)(panel_MainFooter.getPreferredSize().getHeight() * 0.3)));
        panel_ButtonSignUp.add(btnSignup);

        //validate


        // Event Handle
    }
}
