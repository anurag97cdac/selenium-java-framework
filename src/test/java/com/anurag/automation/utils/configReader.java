package com.anurag.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static Properties prop;

    static{
        try{
            InputStream fis = configReader.class.getClassLoader().getResourceAsStream("config.properties");
            prop = new Properties();
            prop.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}
