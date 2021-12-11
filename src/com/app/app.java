package com.app;

import com.connection.ConnectionInfo;
import com.menu.*;
import com.menu.components.AddStudent;

import java.io.IOException;

/**
 * com.app
 * Create by Le Nguyen Tu Van
 * Date 12/10/2021 - 10:22 PM
 * Description: ...
 */
public class app {
    public static void main(String[] args) throws IOException {
//        ConnectionInfo app = new ConnectionInfo();
//        app.start();

        AddStudent addStudent = new AddStudent();
        addStudent.start();
    }
}
