package com.menu.components;

import com.menu.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * com.menu.components
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 5:57 PM
 * Description: ...
 */
public class AddStudent {
    private final JFrame frameMain;

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
        frameMain = new JFrame("Add Student");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.pack();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        frameMain.setVisible(true);

    }}
