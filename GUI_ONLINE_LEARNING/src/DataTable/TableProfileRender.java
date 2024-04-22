//package DataTable;
//
//import java.awt.Component;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
//
//public class TableProfileRender extends DefaultTableCellRenderer {
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        JLabel label = new JLabel();
//        if (value instanceof ImageIcon) {
//            ImageIcon icon = (ImageIcon) value;
//            // Lấy kích thước của dòng
//            int rowHeight = table.getRowHeight(row);
//            // Thiết lập kích thước mới cho hình ảnh
//            Image img = icon.getImage().getScaledInstance(rowHeight - 5, rowHeight - 5, Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon = new ImageIcon(img);
//            label.setIcon(scaledIcon);
//        }
//        return label;
//    }
//}


package DataTable;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableProfileRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel panel = new JPanel();

        if (value instanceof ImageIcon && table.getValueAt(row, column + 1) instanceof String) {
            ImageIcon icon = (ImageIcon) value;
            // Lấy kích thước của dòng
            int rowHeight = table.getRowHeight(row);
            // Thiết lập kích thước mới cho hình ảnh
            Image img = icon.getImage().getScaledInstance(rowHeight - 5, rowHeight - 5, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            JLabel imageLabel = new JLabel(scaledIcon);
            panel.add(imageLabel);
            panel.setBackground(Color.white);
        }
        return panel;
    }
}
