package MyComponent;

import java.awt.*;
import javax.swing.*;

public class CircularImageIcon extends ImageIcon {

    public CircularImageIcon(Image image) {
        super(image);
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setClip(new java.awt.geom.Ellipse2D.Double(x, y, getIconWidth(), getIconHeight()));
        super.paintIcon(c, g2, x, y);
        g2.dispose();
    }
}