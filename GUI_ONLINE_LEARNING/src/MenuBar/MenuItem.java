package MenuBar;

import View.HomeMenu;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MenuItem extends JButton {


    private boolean hovering ;
    private Color color;
    private Color pressColor;
    private Color hoverColor;
    private Color borderColor;
    private int radius = 40;
    private boolean isSelected = false;
    private static MenuItem selectedButton = null;
    private Color mainColor = new Color(128, 128, 255);

    public String getCurrentIconPath(){
        switch (getText()){
            case "Home":
                return HomeMenu.getHomeIconPath();
            case "courses":
                return HomeMenu.getCoursesIconPath();
            case "Profile":
                return HomeMenu.getProfileIconPath();
            case "Setting":
                return HomeMenu.getSettingIconPath();
            default:
                return null;
        }
    }


    public boolean isHovering() {
        return hovering;
    }
    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    public Color getPressColor() {
        return pressColor;
    }
    public void setPressColor(Color pressColor) {
        this.pressColor = pressColor;
    }
    public Color getHoverColor() {
        return hoverColor;
    }
    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }
    public Color getBorderColor() {
        return borderColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }


    public MenuItem(){
        setContentAreaFilled(false);
        setBorder(null);
        setFocusPainted(false);
        color = Color.white;
        pressColor = new Color(224,224,224);
        hoverColor = new Color(240,240,240);
        borderColor = new Color(128,128,255);
        setColor(color);


        addMouseListener(new MouseListener() {



            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
//                isSelected = true;
//                setBackground(pressColor);

                // If there is a previously selected button, deselect it
                if (MenuItem.selectedButton != null) {
                    MenuItem.selectedButton.isSelected = false;
                    MenuItem.selectedButton.setBackground(MenuItem.selectedButton.color);
                    MenuItem.selectedButton.setForeground(Color.white);

                    String currentIconPath = getCurrentIconPath();
                    MenuItem.selectedButton.setColoredIcon(currentIconPath, Color.white);
                    System.out.println("currentIconPath: " + currentIconPath);


                }

                // Select the current button
                isSelected = true;
                setBackground(pressColor);
                setForeground(mainColor);




                if (getText().equals("Home")) {
                    setColoredIcon(HomeMenu.getHomeIconPath(), mainColor);
                } else if (getText().equals("Courses")) {
                    setColoredIcon(HomeMenu.getCoursesIconPath(), mainColor);
                } else if (getText().equals("Profile")) {
                    setColoredIcon(HomeMenu.getProfileIconPath(), mainColor);
                } else if (getText().equals("Setting")) {
                    setColoredIcon(HomeMenu.getSettingIconPath(), mainColor);
                }

                // Update the selectedButton to the current button
                MenuItem.selectedButton = MenuItem.this;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                setBackground(color);
                hovering = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                setBackground(hoverColor);
                hovering = true;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
//                setBackground(pressColor);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                if(hovering) {
                    setBackground(hoverColor);

                }else {
                    setBackground(color);
                }
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //set default
        g2d.setColor(borderColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
//        g2d.setColor(getBackground()); //chi paint border

        //Pait border
        if(isSelected) {
            g2d.setColor(borderColor);
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2d.setColor(getBackground()); //chi paint border

        }

        g2d.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        super.paintComponent(g);
    }

    // Change the color of the icon
    public void setColoredIcon(String iconPath, Color newColor) {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(iconPath));
        ImageIcon coloredIcon = changeIconColor(originalIcon, newColor);
        setIcon(coloredIcon);
    }

    public ImageIcon changeIconColor(ImageIcon icon, Color newColor) {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int rgba = bufferedImage.getRGB(x, y);
                Color color = new Color(rgba, true);
                if (color.getAlpha() != 0) { // if the pixel is not transparent
                    bufferedImage.setRGB(x, y, newColor.getRGB()); // set the pixel to the new color
                }
            }
        }

        return new ImageIcon(bufferedImage);
    }
}
