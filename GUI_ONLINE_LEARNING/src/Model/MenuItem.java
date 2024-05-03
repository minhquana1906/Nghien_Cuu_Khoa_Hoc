package Model;

import Controller.MenuItemController;
import MyInterface.MenuItemInterface;
import MyInterface.Paths;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MenuItem extends JButton implements Paths, MenuItemInterface {
    private boolean hovering ;
    private Color color;
    private Color pressColor;
    private Color hoverColor;
    private Color borderColor;
    private int radius;
    private boolean isSelected ;
    private MenuItem selectedButton;
    private Color mainColor;
    private MenuItemController controller;

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

    public MenuItem getSelectedButton() {
        return selectedButton;
    }

    public void setSelectedButton(MenuItem selectedButton) {
        this.selectedButton = selectedButton;
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

        controller = new MenuItemController(this);
        this.addMouseListener(controller);
    }

    private void initComponents(){
        setContentAreaFilled(false);
        setBorder(null);
        setFocusPainted(false);

        isSelected = false;
        selectedButton = null;
        radius = 40;
        color = Color.white;
        mainColor = new Color(128, 128, 255);
        pressColor = new Color(224,224,224);
        hoverColor = new Color(240,240,240);
        borderColor = new Color(128,128,255);
        setColor(color);

        if(getText().equals(HOME)){
            ButtonSession.getInstance().setSelectedButton(this);
            selectedButton = ButtonSession.getInstance().getSelectedButton();
            setSelected(true);
            this.setBackground(color);
            this.setForeground(mainColor);
            this.setColoredIcon(homeIconPath, mainColor);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //set default
        g2d.setColor(borderColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        //Paint border
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



