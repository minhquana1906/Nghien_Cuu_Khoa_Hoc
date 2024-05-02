package Model;

import Controller.MyButtonController;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

public class MyButton extends JButton {
    private int radius;
    private static final float HOVER_ALPHA = 0.6f; // Độ trong suốt khi hover
    private static final float NORMAL_ALPHA = 1.0f; // Độ trong suốt khi không hover
    private boolean hovering;

    private MyButtonController myButtonController;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

    public MyButton() {
        init();

        myButtonController = new MyButtonController(this);
        this.addMouseListener(myButtonController);
    }

    private void init(){
        radius = 40;
        hovering = false;

        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        if (hovering) {
            g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, HOVER_ALPHA));
        } else {
            g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, NORMAL_ALPHA));
        }
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint border
        g2D.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        // g2D.setColor(getBackground());
        g2D.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(g);
    }
}
