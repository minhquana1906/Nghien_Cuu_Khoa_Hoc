package View;

import SoundProcessing.MicrophoneListener;


import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.io.IOException;

public class AppModel extends JFrame {

    private static final long serialVersionUID = 1L;

    private Thread rollCallThread;
    private Thread webCamThread;
    private MicrophoneListener microphoneListener;
    private Thread microphoneThread;
    private JPanel contentPane;
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
    private static final String SMALL_LAYOUT = "small";
    private static final String MEDIUM_LAYOUT = "medium";
    private static final String LARGE_LAYOUT = "large";
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppModel frame = new AppModel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AppModel() {
        setTitle("Behavior Detection AI for Meetings");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AppModel.class.getResource("/Icon/Logo/AppLogo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        cardLayout = new CardLayout();

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_UsersDisplay = new JPanel();
        panel_UsersDisplay.setBackground(new Color(32, 33, 37));
        panel_UsersDisplay.setLayout(cardLayout);
        contentPane.add(panel_UsersDisplay, BorderLayout.CENTER);

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(32, 33, 37));
        contentPane.add(panelHeader, BorderLayout.NORTH);

        JPanel PanelChatBox = new JPanel();
        PanelChatBox.setBackground(new Color(32, 33, 37));
        PanelChatBox.setPreferredSize(new Dimension(300, 500));
        PanelChatBox.setVisible(false); 		// Ẩn ban đầu

        contentPane.add(PanelChatBox, BorderLayout.EAST);
        PanelChatBox.setLayout(new BorderLayout(0, 0));

        JTextArea txtrDisplayMessage = new JTextArea();
        txtrDisplayMessage.setEditable(false);
        PanelChatBox.add(txtrDisplayMessage, BorderLayout.CENTER);

        JPanel PanelChatInput = new JPanel();
        PanelChatInput.setPreferredSize(new Dimension(280, 40));
        PanelChatBox.add(PanelChatInput, BorderLayout.SOUTH);

        JTextArea txtrSendMessage = new JTextArea();
        String placeHolder = "Send message";
        txtrSendMessage.setFont(new Font("Monospaced", Font.PLAIN, 18));
        txtrSendMessage.setText(placeHolder);
        txtrSendMessage.setBackground(new Color(241, 243, 244));
        txtrSendMessage.setBounds(10, 0, 250, 40);
        txtrSendMessage.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(txtrSendMessage.getText().equals(placeHolder)) {
                    txtrSendMessage.setText("");
                }
            }
        });

        txtrSendMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtrSendMessage.getText().isEmpty()) {
                    txtrSendMessage.setText(placeHolder);
                }
            }
        });
        PanelChatInput.add(txtrSendMessage);

        btnSendMessage = new MyButton();
        btnSendMessage.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/send_msg.png")));
        btnSendMessage.setBounds(260, 0, 40, 40);
        btnSendMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String msg = txtrSendMessage.getText();
                if(txtrSendMessage.getText().equals("")) {
                    return ;
                }

                long currentTime = System.currentTimeMillis();
                txtrDisplayMessage.append("You   " + String.format("%tH:%tM:%tS", currentTime, currentTime, currentTime) + "\n" + msg + "\n\n");
                txtrSendMessage.setText("");
                //TODO replace You with username attribute

            }
        });
        PanelChatInput.setLayout(null);
        btnSendMessage.setRadius(40);
        btnSendMessage.setPreferredSize(new Dimension(40, 40));
        btnSendMessage.setForeground(new Color(241, 243, 244));
        btnSendMessage.setFocusable(false);
        PanelChatInput.add(btnSendMessage);

        JPanel panelChatRightGap = new JPanel();
        PanelChatBox.add(panelChatRightGap, BorderLayout.EAST);

        JPanel panelChatLeftGap = new JPanel();
        PanelChatBox.add(panelChatLeftGap, BorderLayout.WEST);

        JPanel panelChatTopGap = new JPanel();
        PanelChatBox.add(panelChatTopGap, BorderLayout.NORTH);



        JPanel panelLeftSide = new JPanel();
        panelLeftSide.setBackground(new Color(32, 33, 37));
        contentPane.add(panelLeftSide, BorderLayout.WEST);

        JPanel smallLayout = new JPanel(new GridLayout(1, 1));
        JLabel label_sml = new JLabel();
        label_sml.setIcon(new ImageIcon(getClass().getResource("/Icon/Function/user_webcam.png")));
        label_sml.setHorizontalAlignment(SwingConstants.CENTER);
        smallLayout.add(label_sml);

        JPanel mediumLayout = new JPanel(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(getClass().getResource("/Icon/Function/user_webcam.png")));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            mediumLayout.add(label);
        }

        // Tạo bố cục lớn
        JPanel largeLayout = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(getClass().getResource("/Icon/Function/user_webcam.png")));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            largeLayout.add(label);
        }

        panel_UsersDisplay.add(smallLayout, SMALL_LAYOUT);
        panel_UsersDisplay.add(mediumLayout, MEDIUM_LAYOUT);
        panel_UsersDisplay.add(largeLayout, LARGE_LAYOUT);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() < 450) {
                    cardLayout.show(panel_UsersDisplay, SMALL_LAYOUT);
                }
                else if (getWidth() < 1200) {
                    cardLayout.show(panel_UsersDisplay, MEDIUM_LAYOUT);
                }
                else {
                    cardLayout.show(panel_UsersDisplay, LARGE_LAYOUT);
                }
            }
        });

        JPanel panel_ControlMenu = new JPanel();
        panel_ControlMenu.setBackground(new Color(32, 33, 37));
        panel_ControlMenu.setForeground(new Color(32, 33, 37));
        panel_ControlMenu.setPreferredSize(new Dimension(20, 65));
        contentPane.add(panel_ControlMenu, BorderLayout.SOUTH);
        panel_ControlMenu.setLayout(new BorderLayout(0, 0));

        JPanel panel_ControlMenu_Right = new JPanel();
        panel_ControlMenu_Right.setBackground(new Color(32, 33, 37));
        panel_ControlMenu_Right.setPreferredSize(new Dimension(200, 85));
        panel_ControlMenu.add(panel_ControlMenu_Right, BorderLayout.EAST);

        JPanel panel_ControlMenu_Center = new JPanel();
        panel_ControlMenu_Center.setBackground(new Color(32, 33, 37));
        panel_ControlMenu_Center.setPreferredSize(new Dimension(20, 90));
        panel_ControlMenu.add(panel_ControlMenu_Center, BorderLayout.CENTER);
        panel_ControlMenu_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));


        btnMicro_On = new MyButton();
        btnMicro_On.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/mic-on.png")));
        btnMicro_On.setRadius(40);
        btnMicro_On.setForeground(new Color(60, 64, 66));
        btnMicro_On.setBounds(340, 15, 40, 40);
        btnMicro_On.setFocusable(false);
        btnMicro_On.setVisible(false);
        btnMicro_On.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnMicro_On);

        btnMicro_Off = new MyButton();
        btnMicro_Off.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/mic-off.png")));
        btnMicro_Off.setRadius(40);
        btnMicro_Off.setForeground(new Color(255, 0, 0));
        btnMicro_Off.setBounds(340, 15, 40, 40);

        btnMicro_Off.setFocusable(false);
        btnMicro_Off.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnMicro_Off);


        btnCamera_On = new MyButton();
        btnCamera_On.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/cam-on.png")));
        btnCamera_On.setRadius(40);
        btnCamera_On.setForeground(new Color(60, 64, 66));
        btnCamera_On.setBounds(390, 15, 40, 40);
        btnCamera_On.setFocusable(false);
        btnCamera_On.setVisible(false);
        btnCamera_On.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnCamera_On);

        btnCamera_Off = new MyButton();
        btnCamera_Off.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/cam-off.png")));
        btnCamera_Off.setRadius(40);
        btnCamera_Off.setForeground(new Color(255, 0, 0));
        btnCamera_Off.setBounds(390, 15, 40, 40);
        btnCamera_Off.setVisible(true);
        btnCamera_Off.setFocusable(false);
        btnCamera_Off.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnCamera_Off);


        btnPresent = new MyButton();
        btnPresent.setEnabled(false);
        btnPresent.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/present-24px.png")));
        btnPresent.setRadius(40);
        btnPresent.setForeground(new Color(60, 64, 66));
        btnPresent.setBounds(440, 15, 40, 40);
        btnPresent.setFocusable(false);
        btnPresent.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnPresent);

        btnOption = new MyButton();
        btnOption.setEnabled(false);
        btnOption.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/option.png")));
        btnOption.setRadius(40);
        btnOption.setForeground(new Color(60, 64, 66));
        btnOption.setBounds(490, 15, 40, 40);
        btnOption.setFocusable(false);
        btnOption.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Center.add(btnOption);

        btnEnd = new MyButton();
        btnEnd.setRadius(40);
        btnEnd.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/phone-call-end-white.png")));
        btnEnd.setForeground(Color.RED);
        btnEnd.setBounds(540, 15, 60, 40);
        btnEnd.setFocusable(false);
        btnEnd.setPreferredSize(new Dimension(60,40));
        panel_ControlMenu_Center.add(btnEnd);

        panel_ControlMenu_Right.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnMembers = new MyButton();
        btnMembers.setEnabled(false);
        btnMembers.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/members.png")));
        btnMembers.setRadius(40);
        btnMembers.setForeground(new Color(60, 64, 66));
        btnMembers.setFocusable(false);
        btnMembers.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Right.add(btnMembers);

        btnChat = new MyButton();
        btnChat.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(PanelChatBox.isVisible()) {
                    PanelChatBox.setVisible(false);
                }
                else {
                    PanelChatBox.setVisible(true);
                }
            }
        });
        btnChat.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/chat.png")));
        btnChat.setRadius(40);
        btnChat.setForeground(new Color(60, 64, 66));
        btnChat.setFocusable(false);
        btnChat.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Right.add(btnChat);

        btnSetting = new MyButton();
        btnSetting.setEnabled(false);
        btnSetting.setIcon(new ImageIcon(AppModel.class.getResource("/Icon/Function/settings.png")));
        btnSetting.setRadius(40);
        btnSetting.setForeground(new Color(60, 64, 66));
        btnSetting.setFocusable(false);
        btnSetting.setPreferredSize(new Dimension(40,40));
        panel_ControlMenu_Right.add(btnSetting);

        // switching

        btnMicro_Off.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btnMicro_Off.setVisible(false);
                btnMicro_On.setVisible(true);
                startMicrophoneThread();
            }
        });

        btnMicro_On.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btnMicro_On.setVisible(false);
                btnMicro_Off.setVisible(true);
                stopMicrophoneThread();
            }
        });

        btnCamera_On.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btnCamera_On.setVisible(false);
                btnCamera_Off.setVisible(true);

                //TODO turn off camera
                stopWebCamThread();
            }
        });

        btnCamera_Off.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btnCamera_Off.setVisible(false);
                btnCamera_On.setVisible(true);

                startWebCamThread();
            }
        });

        btnEnd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(btnEnd, "Do you really want to quit the meeting?", "Confirm",  JOptionPane.YES_NO_OPTION);
                if(confirm == 0) {
                    dispose();
                    HomeMenu home = new HomeMenu();
                    home.setVisible(true);
                }
            }
        });

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    // Webcam Thread
    private void stopWebCamThread(){
        if(webCamThread != null){
            webCamThread.interrupt();
            System.out.println("Stop webcam thread");
            webCamThread = null;
        }
    }

    private void startWebCamThread(){
        if(webCamThread == null || !webCamThread.isAlive()){
            System.out.println("Starting webcam thread...");
            webCamThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        new PythonConnection.WebCam().start();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            webCamThread.start();
        }
    }

    // Microphone Thread
    private void startMicrophoneThread() {
        if (microphoneThread == null || !microphoneThread.isAlive()) {
            System.out.println("Starting microphone thread...");
            microphoneListener = new MicrophoneListener();
            microphoneThread = new Thread(microphoneListener);
            microphoneThread.start();
        }
    }

    private void stopMicrophoneThread() {
        if (microphoneThread != null) {
            microphoneListener.stop();
            System.out.println("Stop microphone thread");
            try{
                microphoneThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(NullPointerException e){
                e.printStackTrace();
            }

            microphoneListener = null;
            microphoneThread = null;
        }
    }
}
