//package Controller;
//
//import MyComponent.MenuItem;
//import MyInterface.MenuItemInterface;
//import MyInterface.Paths;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//public class MenuItemController implements Paths, MenuItemInterface, MouseListener {
//    private MenuItem menuItem;
//    public MenuItemController(MenuItem menuItem){
//        this.menuItem = menuItem;
//        this.menuItem.addMouseListener(this);
//
//        if(menuItem.getText().equals(HOME)){
//            menuItem.setSelected(true);
//            menuItem.setSelectedButton(menuItem);
//            menuItem.setBackground(menuItem.getPressColor());
//            menuItem.setForeground(menuItem.getMainColor());
//            menuItem.setColoredIcon(homeIconPath, menuItem.getMainColor());
////            System.out.println(menuItem.getSelectedButton().getText()+" " );
//
//        }
//        if(menuItem.getSelectedButton() != null){
//            System.out.println(menuItem.getSelectedButton().getText());
//        }
//        else{
//            System.out.println("null");
//        }
//    }
//
//
//
//    public void mousePressed(MouseEvent e) {
//        // If there is a previously selected button, deselect it
//        if (menuItem.getSelectedButton() != null) {
//            menuItem.getSelectedButton().setSelected(false);
//            System.out.println(menuItem.getSelectedButton().getText() + " "+ menuItem.getSelectedButton().isSelected());
//            menuItem.getSelectedButton().setBackground(menuItem.getSelectedButton().getColor());
//            menuItem.getSelectedButton().setForeground(Color.white);
//
//            if(menuItem.getSelectedButton().getText().equals(HOME)){
//                menuItem.getSelectedButton().setColoredIcon(homeIconPath, Color.white);
//            }
//            else if(menuItem.getSelectedButton().getText().equals(COURSES)){
//                menuItem.getSelectedButton().setColoredIcon(coursesIconPath, Color.white);
//            }
//            else if(menuItem.getSelectedButton().getText().equals(PROFILE)){
//                menuItem.getSelectedButton().setColoredIcon(profileIconPath, Color.white);
//            }
//            else if(menuItem.getSelectedButton().getText().equals(SETTING)){
//                menuItem.getSelectedButton().setColoredIcon(settingIconPath, Color.white);
//            }
//            else if(menuItem.getSelectedButton().getText().equals(LOGOUT)){
//                menuItem.setIcon(new ImageIcon(getClass().getResource(logoutIconPath)));
//            }
//
//        }
//
//        // Select the current button
//        menuItem.setSelected(true);
//        menuItem.setBackground(menuItem.getPressColor());
//        menuItem.setForeground(menuItem.getMainColor());
//
//        if (menuItem.getText().equals(HOME)) {
//            menuItem.setColoredIcon(homeIconPath, menuItem.getMainColor());
//        } else if (menuItem.getText().equals(COURSES)) {
//            menuItem.setColoredIcon(coursesIconPath, menuItem.getMainColor());
//        } else if (menuItem.getText().equals(PROFILE)) {
//            menuItem.setColoredIcon(profileIconPath, menuItem.getMainColor());
//        } else if (menuItem.getText().equals(SETTING)) {
//            menuItem.setColoredIcon(settingIconPath, menuItem.getMainColor());
//        }else if(menuItem.getText().equals(LOGOUT)){
//            menuItem.setIcon(new ImageIcon(getClass().getResource(logoutIconPath)));
//        }
//
//        // Update the selectedButton to the current button
//        menuItem.setSelectedButton(menuItem);
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//}
