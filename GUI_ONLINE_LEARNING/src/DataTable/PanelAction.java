package DataTable;

import javax.swing.JPanel;

import Model.MyButton;

import java.awt.Dimension;

import MyInterface.TableActionEvent;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class PanelAction extends JPanel {

    private static final long serialVersionUID = 1L;
    public MyButton btnEdit;
    public MyButton btnDelete;



    public MyButton getBtnEdit() {
        return btnEdit;
    }
    public void setBtnEdit(MyButton btnEdit) {
        this.btnEdit = btnEdit;
    }
    public MyButton getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(MyButton btnDelete) {
        this.btnDelete = btnDelete;
    }


    public PanelAction() {
        setBackground(new Color(255, 255, 255));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setPreferredSize(new Dimension(90,50));
        initComponent();


    }
    public void initComponent() {
        btnEdit = new MyButton();
        btnEdit.setFocusPainted(false);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setPreferredSize(new Dimension(40,40));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Function/edit.png")));
        add(btnEdit);

        btnDelete = new MyButton();
        btnDelete.setFocusPainted(false);
        btnDelete.setPreferredSize(new Dimension(40, 40));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Function/delete.png")));
        add(btnDelete);
    }

    public void initEvent(TableActionEvent event, int row) {
        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                event.onEdit(row);
            }
        });
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                event.onDelete(row);
            }
        });
    }

}
