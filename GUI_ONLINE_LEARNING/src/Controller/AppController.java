package Controller;

import MyInterface.AppInterface;
import SoundProcessing.MicrophoneListener;
import View.App;
import View.HomeMenu;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class AppController implements ActionListener, FocusListener, ComponentListener, AppInterface {
    App app;
    public AppController(App app){
        this.app = app;
        this.app.addComponentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src == app.getBtnMicro_On()){
            app.getBtnMicro_On().setVisible(false);
            app.getBtnMicro_Off().setVisible(true);
            stopMicrophoneThread();
        }
        else if(src == app.getBtnMicro_Off()){
            app.getBtnMicro_Off().setVisible(false);
            app.getBtnMicro_On().setVisible(true);
            startMicrophoneThread();
        }
        else if(src == app.getBtnCamera_On()){
            app.getBtnCamera_On().setVisible(false);
            app.getBtnCamera_Off().setVisible(true);

            stopWebCamThread();
        }
        else if(src == app.getBtnCamera_Off()){
            app.getBtnCamera_Off().setVisible(false);
            app.getBtnCamera_On().setVisible(true);

            startWebCamThread();
        }
        else if(src == app.getBtnEnd()){
            int choice = JOptionPane.showConfirmDialog(app, "Are you sure you want to leave the meeting?", "Leave Meeting", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_NO_OPTION){
                app.dispose();
                HomeMenu home = new HomeMenu();
                home.setVisible(true);
            }
        }
        else if(src == app.getBtnSendMessage()){
            String msg = app.getTxtrSendMessage().getText();

            long currentTime = System.currentTimeMillis();
            app.getTxtrSendMessage().append("You   " + String.format("%tH:%tM:%tS", currentTime, currentTime, currentTime) + "\n" + msg + "\n\n");
            app.getTxtrSendMessage().setText("");
        }
        else if(src == app.getBtnChat()){
            if(app.getPanelChatBox().isVisible()) {
                app.getPanelChatBox().setVisible(false);
            }
            else {
                app.getPanelChatBox().setVisible(true);
            }
        }else if(src == app.getBtnMembers()){
            JOptionPane.showMessageDialog(app, "This feature is under development", "Members", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(src == app.getBtnOption()){
            JOptionPane.showMessageDialog(app, "This feature is under development", "Option", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(src == app.getBtnPresent()){
            JOptionPane.showMessageDialog(app, "This feature is under development", "Present", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(src == app.getBtnSetting()){
            JOptionPane.showMessageDialog(app, "This feature is under development", "Present", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(app.getTxtrSendMessage().getText().equals(PLACEHOLDER)) {
            app.getTxtrSendMessage().setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (app.getTxtrSendMessage().getText().isEmpty()) {
            app.getTxtrSendMessage().setText(PLACEHOLDER);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if (app.getWidth() < 450) {
            app.getCardLayout().show(app.getPanel_UsersDisplay(), SMALL_LAYOUT);
        }
        else if (app.getWidth() < 1200) {
            app.getCardLayout().show(app.getPanel_UsersDisplay(), MEDIUM_LAYOUT);
        }
        else {
            app.getCardLayout().show(app.getPanel_UsersDisplay(), LARGE_LAYOUT);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    private void startWebCamThread(){
        if(app.getWebCamThread() == null || !app.getWebCamThread().isAlive()){
            System.out.println("Starting webcam thread...");
            app.setWebCamThread (new Thread(() -> {
                try {
                    new PythonConnection.WebCam().start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
            app.getWebCamThread().start();
        }
    }

    private void stopWebCamThread(){
        if(app.getWebCamThread() != null){
            app.getWebCamThread().interrupt();
            System.out.println("Stop webcam thread");
            app.setWebCamThread(null);
        }
    }
    // Microphone Thread
    private void startMicrophoneThread() {
        if (app.getMicrophoneThread() == null || !app.getMicrophoneThread().isAlive()) {
            System.out.println("Starting microphone thread...");
            app.setMicrophoneListener(new MicrophoneListener());
            app.setMicrophoneThread(new Thread(app.getMicrophoneListener()));
            app.getMicrophoneThread().start();
        }
    }

    private void stopMicrophoneThread() {
        if (app.getMicrophoneThread() != null) {
            app.getMicrophoneListener().stop();
            System.out.println("Stop microphone thread");
            try{
                app.getMicrophoneThread().join();
            } catch (InterruptedException | NullPointerException e) {
                e.printStackTrace();
            }

            app.setMicrophoneListener(null);
            app.setMicrophoneThread(null);
        }
    }
}

