package View;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.HomeController;
import DataTable.TableActionCellEditor;
import DataTable.TableActionCellRender;
import DataTable.TableProfileRender;
import MyComponent.MenuItem;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.TableActionEvent;

import MyComponent.CircularImageIcon;
import MyComponent.MyButton;
import MyInterface.Paths;

public class HomeMenu extends JFrame implements Paths {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel_Center;
    private JPanel panel_Function;
    private GridBagLayout gbl_panel_Function;
    private MyButton btnJoin;
    private GridBagConstraints constraint_btnJoin;
    private MyButton btnRollCall;
    private GridBagConstraints constraint_btnRollCall;
    private JLabel lblJoinMeeting;
    private GridBagConstraints gbc_lblJoinMeeting;
    private JLabel lblRollCall;
    private GridBagConstraints gbc_lblRollCall;
    private JPanel panel_DataTable;
    private JLabel label_AttendancesStatus;
    private JTable table;
    private JPanel panel_Left;
    private JPanel panel_AppLogo;
    private JPanel panel_Menu;
    private JLabel ProfileImg;
    private Thread RollCallThread;

    private MenuItem btnHome;
    public MenuItem btnCourses;
    private MenuItem btnProfile;
    private MenuItem btnSetting;
    private MenuItem btnLogout;

    //getters & setters
    public MyButton getBtnJoin() {
        return btnJoin;
    }

    public MyButton getBtnRollCall() {
        return btnRollCall;
    }

    public MenuItem getBtnHome() {
        return btnHome;
    }

    public MenuItem getBtnCourses() {
        return btnCourses;
    }

    public MenuItem getBtnProfile() {
        return btnProfile;
    }

    public MenuItem getBtnSetting() {
        return btnSetting;
    }

    public MenuItem getBtnLogout() {
        return btnLogout;
    }


    public Thread getRollCallThread() {
        return RollCallThread;
    }

    public void setRollCallThread(Thread rollCallThread) {
        RollCallThread = rollCallThread;
    }

    //controller
    private HomeController homeController;

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

    public HomeMenu() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(HomeMenu.class.getResource(HOME_ICON)));
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 680);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        init();

        //controller
        homeController = new HomeController(this);
        btnJoin.addActionListener(homeController);
        btnRollCall.addActionListener(homeController);
        btnCourses.addActionListener(homeController);
        btnProfile.addActionListener(homeController);
        btnSetting.addActionListener(homeController);
        btnLogout.addActionListener(homeController);
    }

    private void init(){
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
        btnJoin.setName("btnJoin");
        btnJoin.setIcon(new ImageIcon(HomeMenu.class.getResource(HOME_BTN_JOIN)));
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
        btnRollCall.setName("btnRollCall");
        btnRollCall.setIcon(new ImageIcon(HomeMenu.class.getResource(HOME_BTN_ROLLCALL)));
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

        label_AttendancesStatus = new JLabel("Students List");
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
                        {new ImageIcon(getClass().getResource("/Icon/Profile/TranTienDung_222611080.png")), "Trần Tiến Dũng", "222611080", "CNTT VA2", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/VuQuangHuy_222631105.png")), "Vũ Quang Huy", "222631105", "CNTT VA1", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/NguyenMinh_222631124.png")), "Nguyễn Minh", "222631124", "CNTT VA2", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/NguyenMinhQuan_222631132.png")), "Nguyễn Minh Quân", "222631132", "CNTT VA1", null},
                        {new ImageIcon(getClass().getResource("/Icon/Profile/NguyenMaiThanh_222631141.png")), "Nguyễn Mai Thanh", "222631141", "CNTT VA2", null},
                },
                new String[] {
                        "Profile image", "Name", "ID", "Class", "Action"
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
    }
}
