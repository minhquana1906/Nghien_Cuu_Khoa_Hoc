package Controller;

import DataAccessObject.DAO_StudentTable;
import DataTable.TableActionCellEditor;
import DataTable.TableActionCellRender;
import DataTable.TableProfileRender;
import Model.Student;
import Model.StudentTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TableController {
    private StudentTableModel tableModel;
    private DAO_StudentTable dao;
    private TableActionEvent event;

    public TableActionEvent getEvent() {
        return event;
    }

    public void setEvent(TableActionEvent event) {
        this.event = event;
    }

    public TableController(){
        dao = new DAO_StudentTable();
        List<Student> students = dao.selectAll();
        this.tableModel = new StudentTableModel(students, this);

        this.event = new TableActionEvent() {

            @Override
            public void onEdit(int row) {
                JOptionPane.showInputDialog("Edit student: " , JOptionPane.INPUT_VALUE_PROPERTY);
            }

            @Override
            public void onDelete(int row) {
                int option = JOptionPane.showOptionDialog(null, "Do you want to delete this student?", "Delete Student", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (option == JOptionPane.YES_NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Delete successful", null, JOptionPane.INFORMATION_MESSAGE);
                    if(tableModel.getTable().isEditing()) {
                        tableModel.getTable().getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel)tableModel.getTable().getModel();
                    model.removeRow(row);
                    dao.delete(students.get(row));
                }
            }
        };
        this.tableModel = new StudentTableModel(students, this);
    }
    public StudentTableModel getTableModel() {
        return tableModel;
    }



}
