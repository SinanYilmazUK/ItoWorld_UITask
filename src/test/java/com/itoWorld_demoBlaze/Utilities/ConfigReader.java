package com.itoWorld_demoBlaze.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;
    static {
        String path = "config.properties";
        FileInputStream file;
        try {
            file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
