package Controller;

import Model.ButtonSession;
import Model.MenuItem;
import MyInterface.MenuItemInterface;
import MyInterface.Paths;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuItemController implements Paths, MenuItemInterface, MouseListener {
    private MenuItem menuItem;

    public MenuItemController(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.menuItem.addMouseListener(this);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Object src = e.getSource();
        if (src instanceof MenuItem) {
            MenuItem item = (MenuItem) src;
            ButtonSession.getInstance().setSelectedButton(item);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        menuItem.setBackground(menuItem.getColor());
        menuItem.setHovering(false);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        menuItem.setBackground(menuItem.getHoverColor());
        menuItem.setHovering(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        menuItem.setBackground(menuItem.getPressColor());
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (menuItem.isHovering()) {
            menuItem.setBackground(menuItem.getHoverColor());
        } else {
            menuItem.setBackground(menuItem.getColor());
        }
    }
}
