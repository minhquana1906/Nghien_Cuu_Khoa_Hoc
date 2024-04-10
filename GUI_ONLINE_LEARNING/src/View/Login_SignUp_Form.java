package View;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Component;

public class Login_SignUp_Form extends JFrame {
    private Dimension FRAME_SIZE;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JPanel panel_Left;
    private JPanel panel_Left_Header;
    private JPanel panel_Left_Main;
    private JPanel panel_Left_Footer;

    private JPanel panel_Right;
    private JPanel panel_Right_Header;
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
    private JLabel lblNewLabel_5;
    private JTextField textField_3;
    private JPasswordField passwordField_Password;
    private JPasswordField passwordField_PasswordConfirm;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_6;
    private JPanel panel_5;
    private JButton btnNewButton;
    private JPanel panel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login_SignUp_Form frame = new Login_SignUp_Form();
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
    public Login_SignUp_Form() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1060, 680);
        //get size of frame
        FRAME_SIZE = this.getSize();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0,0,0,0));

        setContentPane(contentPane);

        this.init();

    }

    void init() {
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        panel_Left = new JPanel();
        panel_Left.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()*0.5), (int)(FRAME_SIZE.getHeight() * 0.1)));
        contentPane.add(panel_Left);
        panel_Left.setLayout(new BorderLayout(0, 0));

//		System.out.println(FRAME_SIZE);

        panel_Left_Header = new JPanel();
        panel_Left_Header.setBackground(new Color(255, 255, 255));
        panel_Left_Header.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()*0.5), (int)(FRAME_SIZE.getHeight() * 0.2)));
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
        lbl_Logo.setIcon(new ImageIcon(Login_SignUp_Form.class.getResource("/Icon/Logo/eye.png")));
        lbl_Logo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Logo.add(lbl_Logo);

        JLabel lblNewLabel_1 = new JLabel("Sign Up");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(53, 79, 84, 29);
        panel_Left_Header.add(lblNewLabel_1);



        panel_Left_Main = new JPanel();
        panel_Left_Main.setBackground(new Color(255, 255, 255));
        panel_Left.add(panel_Left_Main, BorderLayout.CENTER);
        GridLayout gl_panel_Left_Main = new GridLayout(6, 2);
        gl_panel_Left_Main.setVgap(5);
        panel_Left_Main.setLayout(gl_panel_Left_Main);

        Dimension leftPanelSize = panel_Left.getPreferredSize();

        JPanel panel_Username = new JPanel();
        panel_Username.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Username);
        panel_Username.setLayout(new BoxLayout(panel_Username, BoxLayout.Y_AXIS));

        lbl_Username = new JLabel("Username");
        lbl_Username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Username.add(lbl_Username);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel_Username.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Login_SignUp_Form.class.getResource("/Icon/Login_SignUp/profile.png")));
        panel.add(lblNewLabel);

        textField_Username = new JTextField();
        panel.add(textField_Username);
        textField_Username.setColumns(10);


        JPanel panel_Id = new JPanel();
        panel_Id.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Id);
        panel_Id.setLayout(new BoxLayout(panel_Id, BoxLayout.Y_AXIS));

        lbl_Id = new JLabel("Student's ID");
        lbl_Id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Id.add(lbl_Id);

        panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_Id.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Login_SignUp_Form.class.getResource("/Icon/Login_SignUp/id.png")));
        panel_4.add(lblNewLabel_2);

        textField_Id = new JTextField();
        panel_4.add(textField_Id);
        textField_Id.setColumns(10);

        JPanel panel_Class = new JPanel();
        panel_Class.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Class);
        panel_Class.setLayout(new BoxLayout(panel_Class, BoxLayout.Y_AXIS));

        lbl_Class = new JLabel("Student's Class");
        lbl_Class.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Class.add(lbl_Class);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_Class.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

        lblNewLabel_3 = new JLabel("\r\n");
        lblNewLabel_3.setIcon(new ImageIcon(Login_SignUp_Form.class.getResource("/Icon/Login_SignUp/class.png")));
        panel_1.add(lblNewLabel_3);

        textField_3 = new JTextField();
        panel_1.add(textField_3);
        textField_3.setColumns(10);

        JPanel panel_Password = new JPanel();
        panel_Password.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_Password);
        panel_Password.setLayout(new BoxLayout(panel_Password, BoxLayout.Y_AXIS));

        lbl_Password = new JLabel("Password");
        lbl_Password.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_Password.add(lbl_Password);

        panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_Password.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        lblNewLabel_4 = new JLabel("\r\n");
        lblNewLabel_4.setIcon(new ImageIcon(Login_SignUp_Form.class.getResource("/Icon/Login_SignUp/password.png")));
        panel_2.add(lblNewLabel_4);

        passwordField_Password = new JPasswordField();
        panel_2.add(passwordField_Password);

        JPanel panel_PasswordConfirm = new JPanel();
        panel_PasswordConfirm.setBackground(new Color(255, 255, 255));
        panel_Left_Main.add(panel_PasswordConfirm);
        panel_PasswordConfirm.setLayout(new BoxLayout(panel_PasswordConfirm, BoxLayout.Y_AXIS));

        lblNewLabel_5 = new JLabel("Confirm password");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_PasswordConfirm.add(lblNewLabel_5);

        panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_PasswordConfirm.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

        lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(Login_SignUp_Form.class.getResource("/Icon/Login_SignUp/password.png")));
        panel_3.add(lblNewLabel_6);

        passwordField_PasswordConfirm = new JPasswordField();
        panel_3.add(passwordField_PasswordConfirm);

        JPanel panel_BtnSignUp = new JPanel();
        panel_Left_Main.add(panel_BtnSignUp);
        panel_BtnSignUp.setLayout(new BoxLayout(panel_BtnSignUp, BoxLayout.Y_AXIS));

        panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_BtnSignUp.add(panel_5);

        btnNewButton = new JButton("New button");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.6), 30));

        panel_5.add(btnNewButton);

        panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
        flowLayout.setHgap(20);
        panel_BtnSignUp.add(panel_6);

        lblNewLabel_7 = new JLabel("Already have an account?");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel_6.add(lblNewLabel_7);

        lblNewLabel_8 = new JLabel("Login here");
        lblNewLabel_8.setForeground(new Color(0, 128, 255));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_6.add(lblNewLabel_8);







        panel_Left_Padding1 = new JPanel();
        panel_Left_Padding1.setBackground(new Color(255, 255, 255));
        panel_Left_Padding1.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.1), (int)(leftPanelSize.getHeight())));
        panel_Left.add(panel_Left_Padding1, BorderLayout.WEST);

        panel_Left_Padding2 = new JPanel();
        panel_Left_Padding2.setBackground(new Color(255, 255, 255));
        panel_Left_Padding2.setPreferredSize(new Dimension((int)(leftPanelSize.getWidth()*0.1), (int)(leftPanelSize.getHeight())));
        panel_Left.add(panel_Left_Padding2, BorderLayout.EAST);

        //Panel left


        panel_Right = new JPanel();
        contentPane.add(panel_Right);
        panel_Right.setLayout(new BorderLayout(0, 0));

        panel_Right_Header = new JPanel();
        panel_Right_Header.setPreferredSize(new Dimension((int)(FRAME_SIZE.getWidth()*0.5), (int)(FRAME_SIZE.getHeight() * 0.1)));
        panel_Right.add(panel_Right_Header, BorderLayout.NORTH);
    }
}
