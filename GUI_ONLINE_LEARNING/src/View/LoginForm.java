package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_Username;
    private JTextField textField_Password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginForm frame = new LoginForm();
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
    public LoginForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/Icon/Logo/login.png")));
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 453, 472);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("LOG IN");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(158, 33, 116, 31);
        contentPane.add(lblNewLabel);

        JLabel Label_Username = new JLabel("Username");
        Label_Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Label_Username.setBounds(32, 100, 67, 31);
        contentPane.add(Label_Username);

        JLabel Label_Password = new JLabel("Password");
        Label_Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Label_Password.setBounds(32, 170, 67, 31);
        contentPane.add(Label_Password);

        textField_Username = new JTextField();
        textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_Username.setColumns(10);
        textField_Username.setBounds(109, 107, 293, 20);
        contentPane.add(textField_Username);

        textField_Password = new JTextField();
        textField_Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_Password.setColumns(10);
        textField_Password.setBounds(109, 177, 293, 20);
        contentPane.add(textField_Password);

        JLabel Label_lAlreadyHaveAn = new JLabel("Don't have an account?");
        Label_lAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Label_lAlreadyHaveAn.setBounds(79, 338, 155, 31);
        contentPane.add(Label_lAlreadyHaveAn);

        JLabel label_SignUpHere = new JLabel("Signup here");
        label_SignUpHere.setForeground(new Color(0, 102, 255));
        label_SignUpHere.setFont(new Font("Tahoma", Font.BOLD, 15));
        label_SignUpHere.setBackground(new Color(0, 102, 255));
        label_SignUpHere.setBounds(251, 338, 89, 31);
        label_SignUpHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                SignUpForm signupForm = new SignUpForm();
                signupForm.setVisible(true);
            }
        });
        contentPane.add(label_SignUpHere);

        JButton btn_LogIn = new JButton("Log In");
        btn_LogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_LogIn.setBounds(32, 265, 370, 37);

        //fix for SQL
        btn_LogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField_Username.getText();
                String password = textField_Password.getText();

                // check Login
                if (checkLogin(username, password)) {
                    dispose();
                    HomeMenu home = new HomeMenu();
                    home.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
        contentPane.add(btn_LogIn);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    // checkLogin method
    private boolean checkLogin(String username, String password) {
        // call connection
        Connection connection = database.Database.mycon();

        if (connection != null) {
            // if connection thanh cong
            try {
                //Dấu ? là một tham số được sử dụng để tránh tình trạng SQL injection và sẽ được thay thế bằng giá trị thực tế trong bước tiếp theo.
                String query = "SELECT * FROM users WHERE UserName = ? AND UserPassword = ?";
                //make a statement
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                //Đây là cách bạn thiết lập giá trị cho tham số thứ nhất trong câu truy vấn. Trong trường hợp này, tham số thứ nhất là UserName, và giá trị của nó sẽ là giá trị của biến username.
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                //save data in resultSet
                ResultSet resultSet = preparedStatement.executeQuery();

                // if co result tra ve
                if (resultSet.next()) {
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    connection.close(); // dong ket noi sau khi su dung
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false; // Thất bại nếu có vấn đề với kết nối hoặc không có bản ghi phù hợp
    }
}
