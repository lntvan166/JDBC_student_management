package com.menu.components;

import com.manager.StudentList;
import com.menu.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * com.menu.components
 * Create by Le Nguyen Tu Van
 * Date 12/11/2021 - 11:42 PM
 * Description: ...
 */
public class ImportCSV {
    private JFrame frameMain;
    private JPanel panelMain;
    private JTextField textField1;
    private JButton button1;

    public ImportCSV() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filepath = textField1.getText();
                try {
                    Menu.studentList = StudentList.importFromFile(filepath);
                    JOptionPane.showMessageDialog(null, "Import successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Cannot open file");
                }

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
}
