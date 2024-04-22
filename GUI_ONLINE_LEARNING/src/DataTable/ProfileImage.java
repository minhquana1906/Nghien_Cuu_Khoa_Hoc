package DataTable;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;

public class ProfileImage extends JLabel{
    public  ProfileImage() {
        setBackground(Color.white);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);

        int x = (width - size) / 2;
        int y = (height - size) / 2;

        g2d.fill(new Ellipse2D.Double(width, height, size, size));
        g2d.dispose();
    }
}
