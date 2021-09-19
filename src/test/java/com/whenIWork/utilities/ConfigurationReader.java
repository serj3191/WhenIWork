package com.whenIWork.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        String path = "configuration.properties";
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("problem with opening config file");
        }
        try {
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("problem with loading from config file");
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
