package View;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DataTable.TableActionCellEditor;
import DataTable.TableActionCellRender;
import DataTable.TableProfileRender;
import MenuBar.MenuItem;

import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.TableActionEvent;

import MyComponent.CircularImageIcon;
import javax.swing.JSeparator;

public class HomeMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JPanel panel_Center;
    JPanel panel_Function;
    GridBagLayout gbl_panel_Function;
    private MyButton btnJoin;
    GridBagConstraints constraint_btnJoin;
    private MyButton btnRollCall;
    GridBagConstraints constraint_btnRollCall;
    JLabel lblJoinMeeting;
    GridBagConstraints gbc_lblJoinMeeting;
    JLabel lblRollCall;
    GridBagConstraints gbc_lblRollCall;
    JPanel panel_DataTable;
    JLabel label_AttendancesStatus;
    private JTable table;
    private JPanel panel_Left;
    private JPanel panel_AppLogo;
    private JPanel panel_Menu;
    private JLabel ProfileImg;
    private Thread RollCallThread;

    private static String homeIconPath = "/Icon/Logo/home_16.png";
    private static String coursesIconPath = "/Icon/Logo/courses.png";
    private static String profileIconPath = "/Icon/Logo/profile.png";
    private static String settingIconPath = "/Icon/Function/settings.png";
    private static String logoutIconPath = "/Icon/Logo/logout.png";
    public static String getHomeIconPath() {
        return homeIconPath;
    }
    public static String getCoursesIconPath(){
        return coursesIconPath;
    }
    public static String getProfileIconPath(){
        return profileIconPath;
    }
    public static String getSettingIconPath(){
        return settingIconPath;
    }
    public static String getLogoutIconPath(){
        return logoutIconPath;
    }
    private static MenuItem btnHome;
    public static MenuItem btnCourses;
    private static MenuItem btnProfile;
    private static MenuItem btnSetting;
    private MenuItem btnLogout;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeMenu frame = new HomeMenu();
                    frame.setLocationRelativeTo(null);
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
    public HomeMenu() {
        init();
    }

    private void init(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(HomeMenu.class.getResource("/Icon/Logo/3d-house-red-24.png")));
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 683);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        panel_Center = new JPanel();
        contentPane.add(panel_Center, BorderLayout.CENTER);
        panel_Center.setLayout(new BorderLayout(0, 0));

        panel_Function = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                Color color1 = new Color(44, 122, 170);
                Color color2 = new Color(232, 176, 185);
                GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        panel_Center.add(panel_Function);

        gbl_panel_Function = new GridBagLayout();
        gbl_panel_Function.rowWeights = new double[]{0.0, 0.0};
        gbl_panel_Function.columnWeights = new double[]{0.0};
        panel_Function.setLayout(gbl_panel_Function);

        btnJoin = new MyButton();
        btnJoin.setIcon(new ImageIcon(HomeMenu.class.getResource("/Icon/Function/join64x64.png")));
        btnJoin.setForeground(new Color(128, 128, 255));
        btnJoin.setPreferredSize(new Dimension(100, 100));
        btnJoin.setFocusable(false);

        constraint_btnJoin = new GridBagConstraints();
        constraint_btnJoin.anchor = GridBagConstraints.EAST;
        constraint_btnJoin.insets = new Insets(5, 30, 5, 30);
        constraint_btnJoin.gridx = 0;
        constraint_btnJoin.gridy = 0;
        panel_Function.add(btnJoin, constraint_btnJoin);

        btnRollCall = new MyButton();
        btnRollCall.setIcon(new ImageIcon(HomeMenu.class.getResource("/Icon/Function/roll_call64x64.png")));
        btnRollCall.setBackground(new Color(128, 128, 255));
        btnRollCall.setForeground(new Color(128, 128, 255));
        btnRollCall.setPreferredSize(new Dimension(100, 100));
        btnRollCall.setFocusable(false);

        constraint_btnRollCall = new GridBagConstraints();
        constraint_btnRollCall.anchor = GridBagConstraints.WEST;
        constraint_btnRollCall.insets = new Insets(5, 30, 5, 30);
        constraint_btnRollCall.gridx = 1;
        constraint_btnRollCall.gridy = 0;
        panel_Function.add(btnRollCall, constraint_btnRollCall);

        lblJoinMeeting = new JLabel("Join Meeting");
        lblJoinMeeting.setForeground(new Color(255, 255, 255));
        lblJoinMeeting.setFont(new Font("Tahoma", Font.BOLD, 14));
        gbc_lblJoinMeeting = new GridBagConstraints();
        gbc_lblJoinMeeting.anchor = GridBagConstraints.WEST;
        gbc_lblJoinMeeting.insets = new Insets(0, 35, 0, 40);
        gbc_lblJoinMeeting.gridx = 0;
        gbc_lblJoinMeeting.gridy = 1;
        panel_Function.add(lblJoinMeeting, gbc_lblJoinMeeting);

        lblRollCall = new JLabel("Roll Call");
        lblRollCall.setForeground(new Color(255, 255, 255));
        lblRollCall.setFont(new Font("Tahoma", Font.BOLD, 14));
        gbc_lblRollCall = new GridBagConstraints();
        gbc_lblRollCall.anchor = GridBagConstraints.EAST;
        gbc_lblRollCall.insets = new Insets(0, 4, 0, 55);
        gbc_lblRollCall.gridx = 1;
        gbc_lblRollCall.gridy = 1;
        panel_Function.add(lblRollCall, gbc_lblRollCall);

        panel_DataTable = new JPanel();
        panel_DataTable.setPreferredSize(new Dimension(0, 300));
        panel_Center.add(panel_DataTable, BorderLayout.SOUTH);
        panel_DataTable.setLayout(new BorderLayout(0, 0));

        label_AttendancesStatus = new JLabel("Students List\r\n");
        label_AttendancesStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_DataTable.add(label_AttendancesStatus, BorderLayout.NORTH);

        //set up table
        table = new JTable();
        table.setRowSelectionAllowed(false);
        table.setAutoscrolls(false);
        table.setFocusable(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRequestFocusEnabled(false);
        table.setShowGrid(false);
        table.setRowSelectionAllowed(false);

        table.setRowHeight(50);
        table.setBorder(null);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {new ImageIcon(getClass().getResource("/Icon/Profile/TranTienDung_222611080.png")), "Male", "CNTT-VA2", "222611080", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/VuQuangHuy_222631105.png")), "Male", "CNTT-VA1", "222631105", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/NguyenMinh.png")), "Male", "CNTT-VA2", "222631124", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/NguyenMinhQuan_222631132.png")), "Male", "CNTT-VA1", "222631132", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/NguyenMaiThanh.png")), "Male", "CNTT-VA2", "222631141", null},
                },
                new String[] {
                        "Name", "Gender", "Class", "ID", "Action"
                }
        ));


        panel_Left = new JPanel();
        panel_Left.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_Left, BorderLayout.WEST);
        panel_Left.setPreferredSize(new Dimension(250, 100));
        panel_Left.setLayout(null);

        panel_AppLogo = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_AppLogo.getLayout();
        flowLayout.setVgap(20);
        panel_AppLogo.setBackground(new Color(255, 255, 255));
        panel_AppLogo.setBackground(new Color(128,128,255));
        panel_AppLogo.setBounds(0, 0, 250, 150);
        panel_Left.add(panel_AppLogo);

        panel_Menu = new JPanel();
        panel_Menu.setBackground(new Color(128, 128, 255));
        panel_Menu.setBounds(0, 194, 250, 450);
        panel_Left.add(panel_Menu);

        Dimension menuSize = panel_Left.getPreferredSize();

        btnHome = new MenuItem("Home");
        btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnHome.setIconTextGap(15);
        btnHome.setPreferredSize(new Dimension((int)(menuSize.getWidth()*0.8), (int)(menuSize.getHeight()*0.5)));
        btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_Menu.add(btnHome);

        btnCourses = new MenuItem("Courses");
        btnCourses.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCourses.setForeground(new Color(255, 255, 255));
        btnCourses.setBackground(new Color(128,128,255));
        btnCourses.setIconTextGap(15);
        btnCourses.setIcon(new ImageIcon(HomeMenu.class.getResource(coursesIconPath)));
        btnCourses.setPreferredSize(new Dimension((int)(menuSize.getWidth()*0.8), (int)(menuSize.getHeight()*0.5)));
        btnCourses.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_Menu.add(btnCourses);

        btnProfile = new MenuItem("Profile");
        btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnProfile.setForeground(new Color(255, 255, 255));
        btnProfile.setBackground(new Color(128,128,255));
        btnProfile.setIconTextGap(15);
        btnProfile.setIcon(new ImageIcon(HomeMenu.class.getResource(profileIconPath)));
        btnProfile.setPreferredSize(new Dimension((int)(menuSize.getWidth()*0.8), (int)(menuSize.getHeight()*0.5)));
        btnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_Menu.add(btnProfile);

        btnSetting = new MenuItem("Setting");
        btnSetting.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSetting.setForeground(new Color(255, 255, 255));
        btnSetting.setBackground(new Color(128,128,255));
        btnSetting.setIconTextGap(15);
//        btnSetting.setIcon(new ImageIcon(HomeMenu.class.getResource("/Icon/Function/settings.png")));
        btnSetting.setIcon(new ImageIcon(HomeMenu.class.getResource(settingIconPath)));
        btnSetting.setPreferredSize(new Dimension((int)(menuSize.getWidth()*0.8), (int)(menuSize.getHeight()*0.5)));
        btnSetting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_Menu.add(btnSetting);

        btnLogout = new MenuItem("Log out");
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnLogout.setForeground(new Color(255, 255, 255));
        btnLogout.setBackground(new Color(128,128,255));
        btnLogout.setIconTextGap(15);
        btnLogout.setIcon(new ImageIcon(HomeMenu.class.getResource(logoutIconPath)));
        btnLogout.setPreferredSize(new Dimension((int)(menuSize.getWidth()*0.8), (int)(menuSize.getHeight()*0.5)));
        btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_Menu.add(btnLogout);

        ProfileImg = new JLabel();   //TODO: get username from database
        ProfileImg.setForeground(new Color(255, 255, 255));
        ProfileImg.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ProfileImg.setText("User's name");
        ProfileImg.setHorizontalTextPosition(SwingConstants.CENTER);
        ProfileImg.setVerticalTextPosition(SwingConstants.BOTTOM);
        ImageIcon imageIcon = new ImageIcon(HomeMenu.class.getResource("/Icon/Profile/NguyenMinhQuan_222631132.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance((int)(panel_AppLogo.getHeight() * 0.6), (int)(panel_AppLogo.getHeight() * 0.6),  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new CircularImageIcon(newimg);
        ProfileImg.setIcon(imageIcon);
        panel_AppLogo.add(ProfileImg);
        panel_AppLogo.revalidate();
        panel_AppLogo.repaint();


        //event handler
        btnJoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnJoin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //TODO them nhap ma
                dispose();
                AppModel model = new AppModel();
            }
        });

        //event handler for table
        TableActionEvent event = new TableActionEvent() {

            @Override
            public void onEdit(int row) {
                JOptionPane.showInputDialog("Edit student: " , JOptionPane.INPUT_VALUE_PROPERTY);
                //TODO add db
            }

            @Override
            public void onDelete(int row) {
                int option = JOptionPane.showOptionDialog(null, "Do you want to delete this student?", "Delete Student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (option == JOptionPane.YES_NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Delete successfull", null, JOptionPane.OK_OPTION);
                    if(table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.removeRow(row);
                    //TODO: xoa khoi csdl
                }
            }
        };
        table.getColumnModel().getColumn(0).setCellRenderer(new TableProfileRender());
//		table.getColumnModel().getColumn(0).setCellEditor(new TableProfileImageEditor(null));

        table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        panel_DataTable.add(new JScrollPane(table), BorderLayout.CENTER);


        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);
                if(choice == 0){
                    dispose();
                    SignInForm signIn = new SignInForm();
                    signIn.setVisible(true);
                }
            }
        });
        btnRollCall.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startRollCallThread();
                super.mousePressed(e);
            }
        });
    }


    private static ImageIcon getImageIcon(String filename) {
        try {
            File file = new File(filename);
            Image image = ImageIO.read(file);
            return new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Diem danh
    private void startRollCallThread(){
        if(RollCallThread == null || !RollCallThread.isAlive()){
            System.out.println("Starting rollcall thread...");
            RollCallThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        new PythonConnection.RollCall().start();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            RollCallThread.start();
        }
    }
}
