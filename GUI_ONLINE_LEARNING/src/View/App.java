package View;

import Controller.AppController;
import Controller.HomeController;
import Model.MyButton;
import Model.Student;
import Model.UserSession;
import MyInterface.AppInterface;
import MyInterface.Paths;
import SoundProcessing.MicrophoneListener;


import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class App extends JFrame implements AppInterface, Paths {

    private static final long serialVersionUID = 1L;
    private Thread webCamThread;
    private MicrophoneListener microphoneListener;
    private Thread microphoneThread;
    private JPanel contentPane;
//    private JPanel panelHeader;
    private JPanel PanelChatBox;
    private JTextArea txtrDisplayMessage;
    private JPanel PanelChatInput;
    private JPanel panelChatRightGap;
    private JPanel panelChatLeftGap;
    private JPanel panelChatTopGap;
    private JPanel smallLayout;
    private JPanel mediumLayout;
    private JPanel largeLayout;
    private JLabel label_sml;
    private JPanel panel_ControlMenu;
    private JPanel panel_ControlMenu_Right;
    private JPanel panel_ControlMenu_Center;
    private MyButton btnSendMessage;
    private MyButton btnMicro_On;
    private MyButton btnMicro_Off;
    private MyButton btnCamera_On;
    private MyButton btnCamera_Off;
    private MyButton btnPresent;
    private MyButton btnOption;
    private MyButton btnEnd;
    private MyButton btnMembers;
    private MyButton btnSetting;
    private MyButton btnChat;
    private JTextArea txtrSendMessage;
    private JPanel panel_UsersDisplay;
    private CardLayout cardLayout;

    //dang ky su kien
    AppController appController;
    private Student user;

    //getters & setters


    public Thread getWebCamThread() {
        return webCamThread;
    }

    public MicrophoneListener getMicrophoneListener() {
        return microphoneListener;
    }

    public Thread getMicrophoneThread() {
        return microphoneThread;
    }

    public MyButton getBtnSendMessage() {
        return btnSendMessage;
    }

    public MyButton getBtnMicro_On() {
        return btnMicro_On;
    }

    public MyButton getBtnMicro_Off() {
        return btnMicro_Off;
    }

    public MyButton getBtnCamera_On() {
        return btnCamera_On;
    }

    public MyButton getBtnCamera_Off() {
        return btnCamera_Off;
    }

    public MyButton getBtnPresent() {
        return btnPresent;
    }

    public MyButton getBtnOption() {
        return btnOption;
    }

    public MyButton getBtnEnd() {
        return btnEnd;
    }

    public MyButton getBtnMembers() {
        return btnMembers;
    }

    public MyButton getBtnSetting() {
        return btnSetting;
    }

    public MyButton getBtnChat() {
        return btnChat;
    }

    public JTextArea getTxtrSendMessage() {
        return txtrSendMessage;
    }

    public JPanel getPanel_UsersDisplay() {
        return panel_UsersDisplay;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanelChatBox() {
        return PanelChatBox;
    }

    public void setWebCamThread(Thread webCamThread) {
        this.webCamThread = webCamThread;
    }

    public void setMicrophoneListener(MicrophoneListener microphoneListener) {
        this.microphoneListener = microphoneListener;
    }

    public void setMicrophoneThread(Thread microphoneThread) {
        this.microphoneThread = microphoneThread;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public App() {
        setTitle(TITLE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(APP_LOGO)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        this.setMinimumSize(new Dimension(420,450));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        initComponents();

        //dang ky su kien
        appController = new AppController(this);
        btnMicro_On.addActionListener(appController);
        btnMicro_Off.addActionListener(appController);
        btnCamera_On.addActionListener(appController);
        btnCamera_Off.addActionListener(appController);
        btnPresent.addActionListener(appController);
        btnOption.addActionListener(appController);
        btnEnd.addActionListener(appController);
        btnMembers.addActionListener(appController);
        btnSetting.addActionListener(appController);
        btnChat.addActionListener(appController);
        btnSendMessage.addActionListener(appController);
        txtrSendMessage.addFocusListener(appController);
    }

    private void initComponents(){
        user = UserSession.getInstance(null).getUser();

        cardLayout = new CardLayout();

        panel_UsersDisplay = new JPanel();
        panel_UsersDisplay.setBackground(new Color(32, 33, 37));
        panel_UsersDisplay.setLayout(cardLayout);
        contentPane.add(panel_UsersDisplay, BorderLayout.CENTER);

        PanelChatBox = new JPanel();
        PanelChatBox.setBackground(new Color(32, 33, 37));
        PanelChatBox.setPreferredSize(new Dimension(300, 500));
        PanelChatBox.setVisible(false);

        contentPane.add(PanelChatBox, BorderLayout.EAST);
        PanelChatBox.setLayout(new BorderLayout(0, 0));

        txtrDisplayMessage = new JTextArea();
        txtrDisplayMessage.setEditable(false);
        PanelChatBox.add(txtrDisplayMessage, BorderLayout.CENTER);

        PanelChatInput = new JPanel();
        PanelChatInput.setPreferredSize(new Dimension(280, 40));
        PanelChatBox.add(PanelChatInput, BorderLayout.SOUTH);

        txtrSendMessage = new JTextArea();
        txtrSendMessage.setFont(new Font("Monospaced", Font.PLAIN, 18));
        txtrSendMessage.setText(PLACEHOLDER);
        txtrSendMessage.setBackground(new Color(241, 243, 244));
        txtrSendMessage.setBounds(10, 0, 250, 40);
        PanelChatInput.add(txtrSendMessage);

        btnSendMessage = new MyButton();
        btnSendMessage.setIcon(new ImageIcon(getClass().getResource(APP_SEND_MESSAGE_ICON)));
        btnSendMessage.setBounds(260, 0, 40, 40);

        PanelChatInput.setLayout(null);
        btnSendMessage.setRadius(40);
        btnSendMessage.setPreferredSize(new Dimension(40, 40));
        btnSendMessage.setForeground(new Color(241, 243, 244));
        btnSendMessage.setFocusable(false);
        PanelChatInput.add(btnSendMessage);

        panelChatRightGap = new JPanel();
        PanelChatBox.add(panelChatRightGap, BorderLayout.EAST);

        panelChatLeftGap = new JPanel();
        PanelChatBox.add(panelChatLeftGap, BorderLayout.WEST);

        panelChatTopGap = new JPanel();
        PanelChatBox.add(panelChatTopGap, BorderLayout.NORTH);

        smallLayout = new JPanel(new GridLayout(1, 1));
        label_sml = new JLabel();
        label_sml.setIcon(new ImageIcon(getClass().getResource("/Icon/Profile/" + user.getImagePath())));
        label_sml.setHorizontalAlignment(SwingConstants.CENTER);
        smallLayout.add(label_sml);

        mediumLayout = new JPanel(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(getClass().getResource(APP_USER_REPLACEMENT_ICON)));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            mediumLayout.add(label);
        }

        largeLayout = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(getClass().getResource(APP_USER_REPLACEMENT_ICON)));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            largeLayout.add(label);
        }

        panel_UsersDisplay.add(smallLayout, SMALL_LAYOUT);
        panel_UsersDisplay.add(mediumLayout, MEDIUM_LAYOUT);
        panel_UsersDisplay.add(largeLayout, LARGE_LAYOUT);

        panel_ControlMenu = new JPanel();
        panel_ControlMenu.setBackground(new Color(32, 33, 37));
        panel_ControlMenu.setForeground(new Color(32, 33, 37));
        panel_ControlMenu.setPreferredSize(new Dimension(20, 65));
        contentPane.add(panel_ControlMenu, BorderLayout.SOUTH);
        panel_ControlMenu.setLayout(new BorderLayout(0, 0));

        panel_ControlMenu_Right = new JPanel();
        panel_ControlMenu_Right.setBackground(new Color(32, 33, 37));
        panel_ControlMenu_Right.setPreferredSize(new Dimension(200, 85));
        panel_ControlMenu.add(panel_ControlMenu_Right, BorderLayout.EAST);

        panel_ControlMenu_Center = new JPanel();
        panel_ControlMenu_Center.setBackground(new Color(32, 33, 37));
        panel_ControlMenu_Center.setPreferredSize(new Dimension(20, 90));
        panel_ControlMenu.add(panel_ControlMenu_Center, BorderLayout.CENTER);
        panel_ControlMenu_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        btnMicro_On = new MyButton();
        btnMicro_On.setIcon(new ImageIcon(getClass().getResource(APP_MIC_ON_ICON)));
        btnMicro_On.setRadius(40);
        btnMicro_On.setForeground(new Color(60, 64, 66));
        btnMicro_On.setBounds(340, 15, 40, 40);
        btnMicro_On.setFocusable(false);
        btnMicro_On.setVisible(false);
        btnMicro_On.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnMicro_On);

        btnMicro_Off = new MyButton();
        btnMicro_Off.setIcon(new ImageIcon(getClass().getResource(APP_MIC_OFF_ICON)));
        btnMicro_Off.setRadius(40);
        btnMicro_Off.setForeground(new Color(255, 0, 0));
        btnMicro_Off.setBounds(340, 15, 40, 40);

        btnMicro_Off.setFocusable(false);
        btnMicro_Off.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnMicro_Off);

        btnCamera_On = new MyButton();
        btnCamera_On.setIcon(new ImageIcon(getClass().getResource(APP_CAMERA_ON_ICON)));
        btnCamera_On.setRadius(40);
        btnCamera_On.setForeground(new Color(60, 64, 66));
        btnCamera_On.setBounds(390, 15, 40, 40);
        btnCamera_On.setFocusable(false);
        btnCamera_On.setVisible(false);
        btnCamera_On.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnCamera_On);

        btnCamera_Off = new MyButton();
        btnCamera_Off.setIcon(new ImageIcon(getClass().getResource(APP_CAMERA_OFF_ICON)));
        btnCamera_Off.setRadius(40);
        btnCamera_Off.setForeground(new Color(255, 0, 0));
        btnCamera_Off.setBounds(390, 15, 40, 40);
        btnCamera_Off.setVisible(true);
        btnCamera_Off.setFocusable(false);
        btnCamera_Off.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnCamera_Off);

        btnPresent = new MyButton();
//        btnPresent.setEnabled(false);
        btnPresent.setIcon(new ImageIcon(getClass().getResource(APP_SCREEN_SHARE_ICON)));
        btnPresent.setRadius(40);
        btnPresent.setForeground(new Color(60, 64, 66));
        btnPresent.setBounds(440, 15, 40, 40);
        btnPresent.setFocusable(false);
        btnPresent.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnPresent);

        btnOption = new MyButton();
//        btnOption.setEnabled(false);
        btnOption.setIcon(new ImageIcon(getClass().getResource(APP_OPTION_ICON)));
        btnOption.setRadius(40);
        btnOption.setForeground(new Color(60, 64, 66));
        btnOption.setBounds(490, 15, 40, 40);
        btnOption.setFocusable(false);
        btnOption.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnOption);

        btnEnd = new MyButton();
        btnEnd.setRadius(40);
        btnEnd.setIcon(new ImageIcon(getClass().getResource(APP_LEAVE_ICON)));
        btnEnd.setForeground(Color.RED);
        btnEnd.setBounds(540, 15, 60, 40);
        btnEnd.setFocusable(false);
        btnEnd.setPreferredSize(new Dimension(60,40));
        panel_ControlMenu_Center.add(btnEnd);

        panel_ControlMenu_Right.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnMembers = new MyButton();
//        btnMembers.setEnabled(false);
        btnMembers.setIcon(new ImageIcon(getClass().getResource(APP_MEMBER_ICON)));
        btnMembers.setRadius(40);
        btnMembers.setForeground(new Color(60, 64, 66));
        btnMembers.setFocusable(false);
        btnMembers.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Right.add(btnMembers);

        btnChat = new MyButton();
        btnChat.setIcon(new ImageIcon(getClass().getResource(APP_CHAT_ICON)));
        btnChat.setRadius(40);
        btnChat.setForeground(new Color(60, 64, 66));
        btnChat.setFocusable(false);
        btnChat.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Right.add(btnChat);

        btnSetting = new MyButton();
//        btnSetting.setEnabled(false);
        btnSetting.setIcon(new ImageIcon(getClass().getResource(APP_SETTING_ICON)));
        btnSetting.setRadius(40);
        btnSetting.setForeground(new Color(60, 64, 66));
        btnSetting.setFocusable(false);
        btnSetting.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Right.add(btnSetting);

        microphoneListener = new MicrophoneListener();
    }
}