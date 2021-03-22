package com.swaglabs.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;
    public static void readProperties(String filePath){
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
       return properties.getProperty(key);
    }
}
