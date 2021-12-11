package com.menu.components;

import com.manager.Student;
import com.menu.Menu;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * com.menu.components
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 9:46 PM
 * Description: ...
 */
public class View {
    private JFrame frameMain;
    private JPanel panelMain;
    private JComboBox comboBox1;
    private JButton goBackButton;
    private JTable studentTable;

    public View() {
        String method = (String) comboBox1.getSelectedItem();

        showTable(method);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String method = (String) comboBox1.getSelectedItem();

                showTable(method);
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.frameMain.setVisible(true);
                frameMain.dispose();
            }
        });
    }

    public void start() {
        frameMain = new JFrame("View Student List");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frameMain.dispose();
                Menu.frameMain.setVisible(true);
            }
        });
        frameMain.setLocationRelativeTo(null);
        frameMain.pack();
        frameMain.setVisible(true);
    }

    public void showTable(String method) {
        if(Objects.equals(method, "With the student id in ascending order")) {
            Menu.studentList.ascendingById();
        } else {
            Menu.studentList.ascendingByGPA();
        }

        ArrayList<Student> list = (ArrayList<Student>) Menu.studentList.getList();

        studentTable.setModel(new DefaultTableModel(null, new String[]{"ID", "Name", "GPA", "Image", "Address", "Notes"}));

        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();

        Object[] row = new Object[6];
        for (Student student : list) {
            row[0] = student.getId();
            row[1] = student.getName();
            row[2] = String.format("%.2g%n", student.getGpa());
            row[3] = student.getImg();
            row[4] = student.getAddress();
            row[5] = student.getNote();
            model.addRow(row);
        }

        TableColumnModel columns = studentTable.getColumnModel();
        columns.getColumn(0).setMinWidth(50);
        columns.getColumn(1).setMinWidth(150);
        columns.getColumn(3).setMinWidth(150);
        columns.getColumn(4).setMinWidth(150);
        columns.getColumn(5).setMinWidth(150);

        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRender);
        columns.getColumn(2).setCellRenderer(centerRender);

    }
}
