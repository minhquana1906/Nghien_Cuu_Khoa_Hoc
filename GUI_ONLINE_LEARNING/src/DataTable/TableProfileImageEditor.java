package DataTable;

import java.awt.*;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableProfileImageEditor extends DefaultCellEditor{

    public TableProfileImageEditor(JCheckBox checkBox) {
        super(checkBox);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();
        action.setBackground(table.getSelectionBackground());
        return action;
    }

}
