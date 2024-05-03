package Model;

import MyInterface.MenuItemInterface;
import MyInterface.Paths;

import javax.swing.*;
import java.awt.*;

public class ButtonSession implements Paths, MenuItemInterface {
    private static ButtonSession instance = null;
    private MenuItem selectedButton;

    private ButtonSession() {
    }

    public static ButtonSession getInstance() {
        if (instance == null) {
            instance = new ButtonSession();
        }
        return instance;
    }

    public MenuItem getSelectedButton() {
        if (selectedButton == null) {
            selectedButton = new MenuItem(HOME);
            selectedButton.setSelected(true);
            selectedButton.setBackground(selectedButton.getColor());
            selectedButton.setForeground(selectedButton.getMainColor());
            selectedButton.setColoredIcon(homeIconPath, selectedButton.getMainColor());
        }
        return selectedButton;
    }

    public void setSelectedButton(MenuItem selectedButton) {
        if (this.selectedButton != null) {
            this.selectedButton.setSelected(false);
            this.selectedButton.setBackground(this.selectedButton.getColor());
            this.selectedButton.setForeground(Color.white);

            if (this.selectedButton.getText().equals(HOME)) {
                this.selectedButton.setColoredIcon(homeIconPath, Color.white);
            } else if (this.selectedButton.getText().equals(COURSES)) {
                this.selectedButton.setColoredIcon(coursesIconPath, Color.white);
            } else if (this.selectedButton.getText().equals(PROFILE)) {
                this.selectedButton.setColoredIcon(profileIconPath, Color.white);
            } else if (this.selectedButton.getText().equals(SETTING)) {
                this.selectedButton.setColoredIcon(settingIconPath, Color.white);
            } else if (this.selectedButton.getText().equals(LOGOUT)) {
                this.selectedButton.setIcon(new ImageIcon(getClass().getResource(logoutIconPath)));
            }
        }

        this.selectedButton = selectedButton;
        this.selectedButton.setSelected(true);
        this.selectedButton.setBackground(this.selectedButton.getPressColor());
        this.selectedButton.setForeground(this.selectedButton.getMainColor());

        if (this.selectedButton.getText().equals(HOME)) {
            this.selectedButton.setColoredIcon(homeIconPath, this.selectedButton.getMainColor());
        } else if (this.selectedButton.getText().equals(COURSES)) {
            this.selectedButton.setColoredIcon(coursesIconPath, this.selectedButton.getMainColor());
        } else if (this.selectedButton.getText().equals(PROFILE)) {
            this.selectedButton.setColoredIcon(profileIconPath, this.selectedButton.getMainColor());
        } else if (this.selectedButton.getText().equals(SETTING)) {
            this.selectedButton.setColoredIcon(settingIconPath, this.selectedButton.getMainColor());
        } else if (this.selectedButton.getText().equals(LOGOUT)) {
            this.selectedButton.setIcon(new ImageIcon(getClass().getResource(logoutIconPath)));
        }
    }
}