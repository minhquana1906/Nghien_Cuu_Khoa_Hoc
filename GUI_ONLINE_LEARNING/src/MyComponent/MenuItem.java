package MyComponent;

import MyInterface.MenuItemInterface;
import MyInterface.Paths;
import View.HomeMenu;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MenuItem extends JButton implements Paths, MenuItemInterface {
    private boolean hovering ;
    private Color color;
    private Color pressColor;
    private Color hoverColor;
    private Color borderColor;
    private int radius = 40;
    private boolean isSelected ;
    private static MenuItem selectedButton = null;
    private Color mainColor;

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

    public static MenuItem getSelectedButton() {
        return selectedButton;
    }

    public static void setSelectedButton(MenuItem selectedButton) {
        MenuItem.selectedButton = selectedButton;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public MenuItem(String text){
        super(text);

        initComponents();
    }

    private void initComponents(){
        setContentAreaFilled(false);
        setBorder(null);
        setFocusPainted(false);

        isSelected = false;
//        selectedButton = null;
        radius = 40;
        color = Color.white;
        mainColor = new Color(128, 128, 255);
        pressColor = new Color(224,224,224);
        hoverColor = new Color(240,240,240);
        borderColor = new Color(128,128,255);
        setColor(color);

        if(getText().equals(HOME)){
            isSelected = true;
            selectedButton = this;
            this.setBackground(color);
            this.setForeground(mainColor);
            this.setColoredIcon(homeIconPath, mainColor);
        }

        addMouseListener(new MouseListener() {



            @Override
            public void mousePressed(MouseEvent e) {

                // If there is a previously selected button, deselect it
                if (selectedButton != null) {
                    selectedButton.isSelected = false;
                    selectedButton.setBackground(selectedButton.color);
                    selectedButton.setForeground(Color.white);

                    //only change color of icon != log out button
                    if(selectedButton.getText().equals(HOME)){
                        selectedButton.setColoredIcon(homeIconPath, Color.white);
                    }
                    else if(selectedButton.getText().equals(COURSES)){
                        selectedButton.setColoredIcon(coursesIconPath, Color.white);
                    }
                    else if(selectedButton.getText().equals(PROFILE)){
                        selectedButton.setColoredIcon(profileIconPath, Color.white);
                    }
                    else if(selectedButton.getText().equals(SETTING)){
                        selectedButton.setColoredIcon(settingIconPath, Color.white);
                    }
                    else if(selectedButton.getText().equals(LOGOUT)){
                        setIcon(new ImageIcon(getClass().getResource(logoutIconPath)));
                    }
                }


                // Select the current button
                isSelected = true;
                setBackground(pressColor);
                setForeground(mainColor);

                if (getText().equals(HOME)) {
                    setColoredIcon(HomeMenu.homeIconPath, mainColor);
                } else if (getText().equals(COURSES)) {
                    setColoredIcon(coursesIconPath, mainColor);
                } else if (getText().equals(PROFILE)) {
                    setColoredIcon(profileIconPath, mainColor);
                } else if (getText().equals(SETTING)) {
                    setColoredIcon(settingIconPath, mainColor);
                }else if(getText().equals(LOGOUT)){
                    setIcon(new ImageIcon(getClass().getResource(logoutIconPath)));
                }

                // Update the selectedButton to the current button
                selectedButton = MenuItem.this;
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



