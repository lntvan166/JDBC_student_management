package com.menu;

import com.connection.ConnectionInfo;
import com.manager.*;
import com.menu.components.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.List;

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
    private JButton cancelButton;

    public static StudentList studentList;


    public Menu(StudentList list) {

        studentList = list;

        viewStudentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMain.setVisible(false);
                View view = new View();
                view.start();
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
                frameMain.setVisible(false);
                RemoveStudent removeStudent = new RemoveStudent();
                removeStudent.start();
            }
        });
        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMain.setVisible(false);
                UpdateStudent updateStudent = new UpdateStudent();
                updateStudent.start();
            }
        });
        saveStudentListIntoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder str_sql = new StringBuilder("truncate table Student;");

                List<Student> newList = studentList.getList();
                for(Student student : newList) {
                    str_sql.append("insert into Student values('");
                    str_sql.append(student.getId());
                    str_sql.append("', '");
                    str_sql.append(student.getName());
                    str_sql.append("', ");
                    str_sql.append(student.getGpa());
                    str_sql.append(", '");
                    str_sql.append(student.getImg());
                    str_sql.append("', '");
                    str_sql.append(student.getAddress());
                    str_sql.append("', '");
                    str_sql.append(student.getNote());
                    str_sql.append("'); ");
                }

                String sql = str_sql.toString();

                Connection con = null;
                String connect_url = ConnectionInfo.db_server + ";databaseName=" + ConnectionInfo.database
                        + ";user=" + ConnectionInfo.user + ";password=" + ConnectionInfo.password;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connect_url);
                    if (con!=null) System.out.println("Connected to database!");

                    assert con != null;
                    Statement st = con.createStatement();

                    int iAffectedRecord = st.executeUpdate(sql);


                    con.close();

                    JOptionPane.showMessageDialog(null, "Saved to database!!");
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        importStudentListFromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMain.setVisible(false);
                ImportCSV importCSV = new ImportCSV();
                importCSV.start();
            }
        });
        exportStudentListToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMain.setVisible(false);
                ExportCSV exportCSV = new ExportCSV();
                exportCSV.start();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cancelFrame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(cancelFrame, "Confirm if you want to exit", "EXIT",
                        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void start() {
        frameMain = new JFrame("Student Management");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrame cancelFrame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(cancelFrame, "Confirm if you want to exit", "EXIT",
                        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        frameMain.setLocationRelativeTo(null);
        frameMain.pack();
        frameMain.setVisible(true);
    }
}
