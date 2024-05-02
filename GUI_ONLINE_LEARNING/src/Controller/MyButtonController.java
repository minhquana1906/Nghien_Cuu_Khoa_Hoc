package Controller;

import Model.MyButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButtonController implements MouseListener {
    MyButton myButton;
    public MyButtonController(MyButton myButton){
        this.myButton = myButton;
        this.myButton.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        myButton.setBackground(new Color(244,244,244));
        myButton.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!myButton.isEnabled()) {
            return;
        }
        myButton.setHovering(true);
        myButton.repaint(); // Khi di chuột vào, vẽ lại nút để áp dụng hiệu ứng làm mờ
    }

    @Override
    public void mouseExited(MouseEvent e) {
        myButton.setHovering(false);
        myButton.repaint(); // Khi di chuột ra, vẽ lại nút để áp dụng hiệu ứng làm mờ
    }
}
