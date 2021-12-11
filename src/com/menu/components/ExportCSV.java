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
 * Date 12/11/2021 - 11:58 PM
 * Description: ...
 */
public class ExportCSV {
    private JFrame frameMain;
    private JTextField textField1;
    private JButton button1;
    private JPanel panelMain;

    public ExportCSV() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filepath = textField1.getText();
                try {
                    StudentList.saveIntoFile(filepath, Menu.studentList);
                    JOptionPane.showMessageDialog(null, "Export successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
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
