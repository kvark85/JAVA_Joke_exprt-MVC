package com.example.logger;

import java.io.*;

/**
 * Created by kvark85 on 24.12.2016.
 */
public class FileLogger {
    public static void log (String file, String text) {
        try {
            FileWriter writer = null;
            writer = new FileWriter(file, true);
            writer.write(text);
            writer.close();
        } catch(IOException e ) {
            System.out.print(e.getMessage());
        }
    }
}