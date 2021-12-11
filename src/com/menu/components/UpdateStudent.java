package com.menu.components;

import com.manager.Student;
import com.menu.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * com.menu.components
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 8:03 PM
 * Description: ...
 */
public class UpdateStudent {
    private final JFrame frameMain;
    private JPanel panelMain;
    private JButton updateButton;
    private JButton goBackButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox<String> comboBox1;

    public UpdateStudent() {
        frameMain = new JFrame("Update Student");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setLocationRelativeTo(null);
        frameMain.pack();


        String[] idList = Menu.studentList.idList();
        for (String str : idList) {
            comboBox1.addItem(str);
        }
        String id = (String) comboBox1.getSelectedItem();
        Student selectedStudent = Menu.studentList.findById(id);
        textField1.setText(selectedStudent.getId());
        textField2.setText(selectedStudent.getName());
        textField3.setText(String.format("%.2g%n", selectedStudent.getGpa()));
        textField4.setText(selectedStudent.getImg());
        textField5.setText(selectedStudent.getAddress());
        textField6.setText(selectedStudent.getNote());

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String name = textField2.getText();
                float gpa;
                try {
                    gpa = Float.parseFloat(textField3.getText());
                } catch (Exception ex) {
                    gpa = -1;
                    JOptionPane.showMessageDialog(null, "GPA must be a float number!");
                }
                String img = textField4.getText();
                String address = textField5.getText();
                String note = textField6.getText();

                Student newStudent = new Student(id, name, gpa, img, address, note);
                Menu.studentList.updateStudent(id, newStudent);
                JOptionPane.showMessageDialog(null, "Student updated!");

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

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = (String) comboBox1.getSelectedItem();
                Student selectedStudent = Menu.studentList.findById(id);
                textField1.setText(selectedStudent.getId());
                textField2.setText(selectedStudent.getName());
                textField3.setText(String.format("%.2g%n", selectedStudent.getGpa()));
                textField4.setText(selectedStudent.getImg());
                textField5.setText(selectedStudent.getAddress());
                textField6.setText(selectedStudent.getNote());
            }
        });
    }

    public void start() {
        frameMain.setVisible(true);
    }
}
