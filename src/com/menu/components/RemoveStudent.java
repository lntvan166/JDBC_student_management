package com.menu.components;

import com.manager.Student;
import com.menu.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * com.menu.components
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 9:03 PM
 * Description: ...
 */
public class RemoveStudent {
    private JFrame frameMain;
    private JComboBox comboBox1;
    private JButton removeButton;
    private JButton goBackButton;
    private JPanel panelMain;
    private JLabel labelID;
    private JLabel labelName;
    private JLabel labelGPA;
    private JLabel labelImage;
    private JLabel labelAddress;
    private JLabel labelNotes;

    public RemoveStudent() {
        String[] idList = Menu.studentList.idList();
        for (String str : idList) {
            comboBox1.addItem(str);
        }
        String id = (String) comboBox1.getSelectedItem();
        Student selectedStudent = Menu.studentList.findById(id);
        labelID.setText(selectedStudent.getId());
        labelName.setText(selectedStudent.getName());
        labelGPA.setText(String.format("%.2g%n", selectedStudent.getGpa()));
        labelImage.setText(selectedStudent.getImg());
        labelAddress.setText(selectedStudent.getAddress());
        labelNotes.setText(selectedStudent.getNote());


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = (String) comboBox1.getSelectedItem();
                Student selectedStudent = Menu.studentList.findById(id);
                labelID.setText(selectedStudent.getId());
                labelName.setText(selectedStudent.getName());
                labelGPA.setText(String.format("%.2g%n", selectedStudent.getGpa()));
                labelImage.setText(selectedStudent.getImg());
                labelAddress.setText(selectedStudent.getAddress());
                labelNotes.setText(selectedStudent.getNote());
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = (String) comboBox1.getSelectedItem();

                Menu.studentList.removeStudent(id);

                JOptionPane.showMessageDialog(null, "Remove successfully!");

                Menu.frameMain.setVisible(true);
                frameMain.dispose();
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
        frameMain = new JFrame("Update Student");
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
}
