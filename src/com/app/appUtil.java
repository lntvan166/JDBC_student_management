package com.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * com.connection
 * Create by Le Nguyen Tu Van
 * Date 12/10/2021 - 9:18 PM
 * Description: ...
 */
public class appUtil {
    public static void saveConnectionInformationToTextFile
            (String filename, String db_server, String database, String user, String password) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(db_server);
        writer.newLine();
        writer.write(database);
        writer.newLine();
        writer.write(user);
        writer.newLine();
        writer.write(password);
        writer.flush();
        writer.close();
    }

    public static List<String> readConnectionInformationFromTextFile
            (String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str;
        List<String> result = new ArrayList<String>();
        result.add(reader.readLine());
        result.add(reader.readLine());
        result.add(reader.readLine());
        result.add(reader.readLine());
        reader.close();
        return result;
    }
}
