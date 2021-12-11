package com.menu.components;

import com.manager.Student;
import com.menu.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 * com.menu.components
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 5:57 PM
 * Description: ...
 */
public class AddStudent {
    private JFrame frameMain;

    private JPanel panelMain;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton addButton;
    private JButton goBackButton;

    public AddStudent() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String name = textField2.getText();
                float gpa = 0;
                try {
                    gpa = Float.parseFloat(textField3.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "GPA must be a float number!");
                }
                String img = textField4.getText();
                String address = textField5.getText();
                String note = textField6.getText();

                if(Objects.equals(id, "") || Objects.equals(name, "")
                        || Objects.equals(img, "") || Objects.equals(address, "") || Objects.equals(note, "")) {
                    JOptionPane.showMessageDialog(null, "Cannot add empty information!");
                }  else if(Menu.studentList.checkIdExist(id)) {
                    JOptionPane.showMessageDialog(null, "Student id exist already!");
                } else {
                    Student newStudent = new Student(id, name, gpa, img, address, note);

                    Menu.studentList.addStudent(newStudent);

                    JOptionPane.showMessageDialog(null, "Student added!");

                    Menu.frameMain.setVisible(true);
                    frameMain.dispose();
                }

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
        frameMain = new JFrame("Add Student");
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

    }}
