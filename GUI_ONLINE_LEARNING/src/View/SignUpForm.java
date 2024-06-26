package View;

import Controller.SignUpController;
import MyInterface.Paths;

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
import java.sql.SQLException;
import java.awt.Toolkit;

public class SignUpForm extends JFrame implements Paths {
    private Dimension FRAME_SIZE;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JPanel panel_Left;
    private JPanel panel_Left_Header;
    private JPanel panel_Left_Main;
    private JPanel panel_Logo;
    private JLabel lbl_Logo;
    private JPanel panel_Left_Padding1;
    private JPanel panel_Left_Padding2;

    private JLabel lbl_Username;
    private JTextField textField_Username;
    private JLabel lbl_Id;
    private JTextField textField_Id;
    private JLabel lbl_Class;
    private JLabel lbl_Password;
    private JLabel lbl_PasswordConfirm;
    private JTextField textField_Class;
    private JPasswordField passwordField_Password;
    private JPasswordField passwordField_PasswordConfirm;
    private JPanel panel_UsernameContainer;
    private JLabel lbl_UserIcon;
    private JPanel panel_ClassContainer;
    private JPanel panel_PasswordContainer;
    private JPanel panel_PassConfirmContainer;
    private JPanel panel_IdContainer;
    private JLabel lbl_IdIcon;
    private JLabel lblClassIcon;
    private JLabel lbl_PasswordIcon;
    private JLabel lbl_PasswordConfirmIcon;
    private JPanel panel_LeftFooter;
    private JPanel panel_SignUpOption;
    private JPanel panel_LoginOption;
    private JLabel lbl_HaveAccount;
    private JLabel lbl_LoginHere;
    private JPanel panel_FooterPadding;
    private JPanel panel_ButtonSignUp;
    private JButton btnSignup;

    private SignUpController signUpController;
    
    //getters
    public JTextField getTextField_Username() {
        return textField_Username;
    }

    public JTextField getTextField_Id() {
        return textField_Id;
    }

    public JTextField getTextField_Class() {
        return textField_Class;
    }

    public JPasswordField getPasswordField_Password() {
        return passwordField_Password;
    }

    public JPasswordField getPasswordField_PasswordConfirm() {
        return passwordField_PasswordConfirm;
    }

    public JLabel getLbl_LoginHere() {
        return lbl_LoginHere;
    }

    public JLabel getLbl_HaveAccount() {
        return lbl_HaveAccount;
    }
    public JButton getBtnSignUp() {
        return btnSignup;
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUpForm frame = new SignUpForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public SignUpForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpForm.class.getResource(SIGN_UP_ICON)));
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530,680);
        setLocationRelativeTo(null);
        setResizable(false);
        //get size of frame
        FRAME_SIZE = this.getSize();
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0,0,0,0));
        setContentPane(contentPane);

        this.init();

        //dang ky su kien
        signUpController = new SignUpController(this);
        btnSignup.addActionListener(signUpController);
        lbl_LoginHere.addMouseListener(signUpController);
    }

    void init() {
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        panel_Left = new JPanel();
        panel_Left.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.1)));
        contentPane.add(panel_Left);
        panel_Left.setLayout(new BorderLayout(0, 0));

        panel_Left_Header = new JPanel();
        panel_Left_Header.setBackground(new Color(255, 255, 255));
        panel_Left_Header.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.2)));
        panel_Left.add(panel_Left_Header, BorderLayout.NORTH);
        panel_Left_Header.setLayout(null);

        panel_Logo = new JPanel();
        panel_Logo.setBackground(new Color(255, 255, 255));
        FlowLayout fl_panel_Logo = (FlowLayout) panel_Logo.getLayout();
        fl_panel_Logo.setHgap(0);
        fl_panel_Logo.setVgap(0);
        panel_Logo.setBounds(0, 0, 258, 68);
        panel_Left_Header.add(panel_Logo);

        lbl_Logo = new JLabel("App's name");
        lbl_Logo.setIcon(new ImageIcon(SignUpForm.class.getResource(SIGN_UP_LOGO)));
        lbl_Logo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Logo.add(lbl_Logo);

        JLabel lbl_Title = new JLabel("Sign Up");
        lbl_Title.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbl_Title.setBounds(53, 79, 84, 29);
        panel_Left_Header.add(lbl_Title);



        panel_Left_Main = new JPanel();
        panel_Left_Main.setBackground(new Color(255, 255, 255));
        panel_Left.add(panel_Left_Main, BorderLayout.CENTER);
        GridLayout gl_panel_Left_Main = new GridLayout(5, 2);
        gl_panel_Left_Main.setVgap(20);
        panel_Left_Main.setLayout(gl_panel_Left_Main);

        Dimension leftPanelSize = panel_Left.getPreferredSize();

        JPanel panel_Username = new JPanel();
        panel_Username.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Username);
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
        lbl_UserIcon.setIcon(new ImageIcon(SignUpForm.class.getResource(USER_ICON)));
        panel_UsernameContainer.add(lbl_UserIcon);

        textField_Username = new JTextField();
        textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_UsernameContainer.add(textField_Username);
        textField_Username.setColumns(10);


        JPanel panel_Id = new JPanel();
        panel_Id.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Id);
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
        lbl_IdIcon.setIcon(new ImageIcon(SignUpForm.class.getResource(ID_ICON)));
        panel_IdContainer.add(lbl_IdIcon);

        textField_Id = new JTextField();
        textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_IdContainer.add(textField_Id);
        textField_Id.setColumns(10);

        JPanel panel_Class = new JPanel();
        panel_Class.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Class);
        panel_Class.setLayout(new BoxLayout(panel_Class, BoxLayout.Y_AXIS));

        lbl_Class = new JLabel("Student's Class");
        lbl_Class.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Class.add(lbl_Class);

        panel_ClassContainer = new JPanel();
        panel_ClassContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_ClassContainer.setBackground(new Color(255, 255, 255));
        panel_Class.add(panel_ClassContainer);
        panel_ClassContainer.setLayout(new BoxLayout(panel_ClassContainer, BoxLayout.X_AXIS));

        lblClassIcon = new JLabel("\r\n");
        lblClassIcon.setIcon(new ImageIcon(SignUpForm.class.getResource(CLASS_ICON)));
        panel_ClassContainer.add(lblClassIcon);

        textField_Class = new JTextField();
        textField_Class.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_ClassContainer.add(textField_Class);
        textField_Class.setColumns(10);

        JPanel panel_Password = new JPanel();
        panel_Password.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Password);
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
        lbl_PasswordIcon.setIcon(new ImageIcon(SignUpForm.class.getResource(PASSWORD_ICON)));
        panel_PasswordContainer.add(lbl_PasswordIcon);

        passwordField_Password = new JPasswordField();
        passwordField_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_PasswordContainer.add(passwordField_Password);

        JPanel panel_PasswordConfirm = new JPanel();
        panel_PasswordConfirm.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_PasswordConfirm);
        panel_PasswordConfirm.setLayout(new BoxLayout(panel_PasswordConfirm, BoxLayout.Y_AXIS));

        lbl_PasswordConfirm = new JLabel("Confirm password");
        lbl_PasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_PasswordConfirm.add(lbl_PasswordConfirm);

        panel_PassConfirmContainer = new JPanel();
        panel_PassConfirmContainer.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel_PassConfirmContainer.setBackground(new Color(255, 255, 255));
        panel_PasswordConfirm.add(panel_PassConfirmContainer);
        panel_PassConfirmContainer.setLayout(new BoxLayout(panel_PassConfirmContainer, BoxLayout.X_AXIS));

        lbl_PasswordConfirmIcon = new JLabel("");
        lbl_PasswordConfirmIcon.setIcon(new ImageIcon(SignUpForm.class.getResource(PASSWORD_ICON)));
        panel_PassConfirmContainer.add(lbl_PasswordConfirmIcon);

        passwordField_PasswordConfirm = new JPasswordField();
        passwordField_PasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_PassConfirmContainer.add(passwordField_PasswordConfirm);

        panel_Left_Padding1 = new JPanel();
        panel_Left_Padding1.setBackground(new Color(255, 255, 255));
        panel_Left_Padding1.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.1), (int)(leftPanelSize.getHeight())));
        panel_Left.add(panel_Left_Padding1, BorderLayout.WEST);

        panel_Left_Padding2 = new JPanel();
        panel_Left_Padding2.setBackground(new Color(255, 255, 255));
        panel_Left_Padding2.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.1), (int)(leftPanelSize.getHeight())));
        panel_Left.add(panel_Left_Padding2, BorderLayout.EAST);

        panel_LeftFooter = new JPanel();
        panel_LeftFooter.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()), (int)(FRAME_SIZE.getHeight() * 0.18)));
        panel_Left.add(panel_LeftFooter, BorderLayout.SOUTH);
        panel_LeftFooter.setLayout(new BorderLayout(0, 0));

        panel_SignUpOption = new JPanel();
        panel_SignUpOption.setBackground(Color.WHITE);
        panel_LeftFooter.add(panel_SignUpOption);
        panel_SignUpOption.setLayout(new BorderLayout(0, 0));

        panel_LoginOption = new JPanel();
        panel_LoginOption.setBackground(Color.WHITE);
        panel_SignUpOption.add(panel_LoginOption, BorderLayout.CENTER);
        panel_LoginOption.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));

        lbl_HaveAccount = new JLabel("Already have an account?");
        lbl_HaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_LoginOption.add(lbl_HaveAccount);

        lbl_LoginHere = new JLabel("Login here");
        lbl_LoginHere.setForeground(new Color(0, 128, 255));
        lbl_LoginHere.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbl_LoginHere.setAlignmentX(1.0f);
        panel_LoginOption.add(lbl_LoginHere);

        panel_FooterPadding = new JPanel();
        panel_FooterPadding.setBackground(new Color(255, 255, 255));
        panel_FooterPadding.setPreferredSize(new Dimension((int)(panel_LeftFooter.getPreferredSize().getWidth()*0.5), (int)(panel_LeftFooter.getPreferredSize().getHeight() * 0.3)));
        panel_LeftFooter.add(panel_FooterPadding, BorderLayout.SOUTH);
        panel_FooterPadding.setLayout(null);

        panel_ButtonSignUp = new JPanel();
        panel_ButtonSignUp.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout = (FlowLayout) panel_ButtonSignUp.getLayout();
        flowLayout.setVgap(15);
        panel_LeftFooter.add(panel_ButtonSignUp, BorderLayout.NORTH);

        btnSignup = new JButton("Sign Up");
        btnSignup.setForeground(new Color(255, 255, 255));
        btnSignup.setBackground(new Color(0, 0, 0));
        btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSignup.setFocusable(false);
        btnSignup.setPreferredSize(new Dimension((int)(panel_LeftFooter.getPreferredSize().getWidth()*0.65), (int)(panel_LeftFooter.getPreferredSize().getHeight() * 0.3)));
        panel_ButtonSignUp.add(btnSignup);
    }
}
