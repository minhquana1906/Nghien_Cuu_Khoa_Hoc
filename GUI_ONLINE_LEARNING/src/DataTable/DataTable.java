package DataTable;

import javax.swing.JPanel;
import javax.swing.JTable;

public class DataTable extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Create the panel.
     */
    public DataTable() {

        table = new JTable();
        add(table);
        table.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());

    }

}
