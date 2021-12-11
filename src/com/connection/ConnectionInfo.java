package com.connection;

import com.app.appUtil;
import com.manager.Student;
import com.manager.StudentList;
import com.menu.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * com.connection
 * Create by Le Nguyen Tu Van
 * Date 12/10/2021 - 8:26 PM
 * Description: ...
 */
public class ConnectionInfo {
    public static Connection con;

    private final JFrame frameMain;
    private JPanel panelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton submitButton;

    public ConnectionInfo() {
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
                StudentList studentList = connect(db_server, database, user, password);


                // Close connection frame
                frameMain.setVisible(false);

                // Show menu
                Menu menu = new Menu(studentList);
                menu.start();
            }
        });

        // set frame
        frameMain = new JFrame("Connection Information");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setLocationRelativeTo(null);
        frameMain.pack();
    }

    public void start() {
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

        // show frame
        frameMain.setVisible(true);
    }

    public StudentList connect(String db_server, String database, String user, String password) {
        StudentList studentList = new StudentList();
        Student temp;

        String connect_url = db_server + ";databaseName=" + database + ";user=" + user + ";password=" + password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connect_url);
            if (con!=null) System.out.println("Connected to database!");

            assert con != null;
            Statement st = con.createStatement();
            String str_sql = "select * from student";
            ResultSet rs = st.executeQuery(str_sql);

            while (rs.next())
            {
                temp = new Student(rs.getString(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));

                studentList.addStudent(temp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return studentList;
    }

    public static void main(String[] args) {
    }
}
