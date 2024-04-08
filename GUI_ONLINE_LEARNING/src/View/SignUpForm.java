package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_Email;
    private JTextField textField_Username;
    private JPasswordField passwordField_Password;
    private JPasswordField passwordField_ConfirmPassword;


    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public SignUpForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpForm.class.getResource("/Icon/Logo/signup.png")));
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 453, 567);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_Username = new JLabel("Username");
        label_Username.setBounds(32, 100, 67, 31);
        label_Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(label_Username);

        JLabel label_Tittle = new JLabel("SIGN UP");
        label_Tittle.setBounds(158, 33, 116, 31);
        label_Tittle.setHorizontalAlignment(SwingConstants.CENTER);
        label_Tittle.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(label_Tittle);

        JLabel label_Email = new JLabel("Email");
        label_Email.setBounds(32, 170, 33, 31);
        label_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(label_Email);

        JLabel label_Password = new JLabel("Password");
        label_Password.setBounds(32, 240, 61, 31);
        label_Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(label_Password);

        JLabel label_ConfirmPassword = new JLabel("Confirm Password");
        label_ConfirmPassword.setBounds(32, 310, 116, 31);
        label_ConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(label_ConfirmPassword);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(32, 373, 370, 37);
        btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnSignUp);
        //
        btnSignUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField_Username.getText();
                String email = textField_Email.getText();
                String password = String.valueOf(passwordField_Password.getPassword());
                String confirmPassword = String.valueOf(passwordField_ConfirmPassword.getPassword());

                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(btnSignUp, "Please fill in all fields", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(btnSignUp, "Invalid email format", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(btnSignUp, "Password must be between 8 and 16 characters", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(btnSignUp, "The confirmation password does not match the entered password", "Error!", JOptionPane.ERROR_MESSAGE);
                    passwordField_Password.setText("");
                    passwordField_ConfirmPassword.setText("");
                    return;
                }

                // kiem tra xem, tai khoan co ton tai hay khong
                if (checkAccountExist(username)) {
                    JOptionPane.showMessageDialog(btnSignUp, "Username already exists, please choose another one", "Error!", JOptionPane.ERROR_MESSAGE);
                    textField_Username.setText("");
                    return;
                }

                // them tai khoan moi vao csdl
                if (addAccount(username, email, password)) {
                    JOptionPane.showMessageDialog(btnSignUp, "Success!\nYour account has been created", "Success!", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    new LoginForm();
                } else {
                    JOptionPane.showMessageDialog(btnSignUp, "Failed to create an account", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel label_HaveAccount = new JLabel("Already have an account?");
        label_HaveAccount.setBounds(68, 446, 174, 31);
        label_HaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(label_HaveAccount);

        JLabel label_LoginHere = new JLabel("Login here");
        label_LoginHere.setForeground(new Color(0, 102, 255));
        label_LoginHere.setBounds(252, 446, 86, 31);
        label_LoginHere.setBackground(new Color(0, 102, 255));
        label_LoginHere.setFont(new Font("Tahoma", Font.BOLD, 15));
        label_LoginHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
        contentPane.add(label_LoginHere);

        textField_Email = new JTextField();
        textField_Email.setBounds(158, 177, 244, 20);
        textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_Email.setColumns(10);
        contentPane.add(textField_Email);

        textField_Username = new JTextField();
        textField_Username.setBounds(158, 107, 244, 20);
        textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_Username.setColumns(10);
        contentPane.add(textField_Username);

        passwordField_Password = new JPasswordField();
        passwordField_Password.setBounds(158, 247, 244, 20);
        passwordField_Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(passwordField_Password);

        passwordField_ConfirmPassword = new JPasswordField();
        passwordField_ConfirmPassword.setBounds(158, 317, 244, 20);
        passwordField_ConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(passwordField_ConfirmPassword);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    // check xem tai khoan co ton tai hay khong
    private boolean checkAccountExist(String username) {
        Connection connection = database.Database.mycon();
        if (connection != null) {
            try {
                String query = "SELECT * FROM users WHERE UserName = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                //check xem co ton tai trong database chua
                return preparedStatement.executeQuery().next();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    // them tai khoan moi vao csdl
    private boolean addAccount(String username, String email, String password) {
        Connection connection = database.Database.mycon();
        if (connection != null) {
            try {
                String query = "INSERT INTO users (UserName, Email, UserPassword) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                int result = preparedStatement.executeUpdate();
                return result > 0;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    //validate email

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 16;
    }
}

