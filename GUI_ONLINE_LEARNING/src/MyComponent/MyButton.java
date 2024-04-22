package MyComponent;

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
    private int radius = 40;
    private static final float HOVER_ALPHA = 0.6f; // Độ trong suốt khi hover
    private static final float NORMAL_ALPHA = 1.0f; // Độ trong suốt khi không hover
    private boolean hovering = false;

    public MyButton() {
        setContentAreaFilled(false);
        setBorder(null);
        setOpaque(false);
        if(!isEnabled()) {
            setForeground(new Color(250,250,250));
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(!isEnabled()) {
                    return;
                }
                hovering = true;
                repaint(); // Khi di chuột vào, vẽ lại nút để áp dụng hiệu ứng làm mờ
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint(); // Khi di chuột ra, vẽ lại nút để áp dụng hiệu ứng làm mờ
            }
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(new Color(244,244,244));
                repaint();
                super.mousePressed(e);
            }
        });
    }



    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
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
