package com.app;

import com.connection.Connection;

import java.io.IOException;

/**
 * com.app
 * Create by Le Nguyen Tu Van
 * Date 12/10/2021 - 10:22 PM
 * Description: ...
 */
public class app {
    public static void main(String[] args) throws IOException {
        Connection app = new Connection();
        app.start();
    }
}
