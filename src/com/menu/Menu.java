package com.menu;

import com.manager.*;
import com.menu.components.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * com.menu
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 2:41 PM
 * Description: ...
 */
public class Menu {
    public static JFrame frameMain;

    private JPanel panelMain;
    private JButton viewStudentListButton;
    private JButton addStudentButton;
    private JButton removeStudentButton;
    private JButton updateStudentButton;
    private JButton saveStudentListIntoButton;
    private JButton importStudentListFromButton;
    private JButton exportStudentListToButton;

    public static StudentList studentList;


    public Menu(StudentList list) {

        studentList = list;

        frameMain = new JFrame("Student Management");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();

        viewStudentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMain.setVisible(false);
                AddStudent addStudent = new AddStudent();
                addStudent.start();
            }
        });
        removeStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveStudentListIntoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        importStudentListFromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exportStudentListToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void start() {
        frameMain.setVisible(true);
    }
}
