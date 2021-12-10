package com.connection;

import com.app.appUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * com.connection
 * Create by Le Nguyen Tu Van
 * Date 12/10/2021 - 8:26 PM
 * Description: ...
 */
public class Connection {
    private final JFrame frameMain;
    private JPanel panelMain;
    private JLabel title;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton submitButton;

    public Connection() {
        // Get database config from text file
        String db_server, database, user, password;
        List<String> connectInfo;
        try {
            connectInfo= appUtil.readConnectionInformationFromTextFile("databaseConfig.txt");
            db_server = connectInfo.get(0);
            database = connectInfo.get(1);
            user = connectInfo.get(2);
            password = connectInfo.get(3);
        } catch (IOException ex) {
            db_server = "";
            database = "";
            user = "";
            password = "";
        }

        // set default config database
        textField1.setText(db_server);
        textField2.setText(database);
        textField3.setText(user);
        textField4.setText(password);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String db_server = textField1.getText();
                String database = textField2.getText();
                String user = textField3.getText();
                String password = textField4.getText();
                try {
                    appUtil.saveConnectionInformationToTextFile("databaseConfig.txt", db_server, database, user, password);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Saved!!");
                // Connect db



                // Close connection frame
                frameMain.setVisible(false);
            }
        });

        // set frame
        frameMain = new JFrame("Connection Information");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setVisible(true);
    }

    public static void main(String[] args) {
    }
}
