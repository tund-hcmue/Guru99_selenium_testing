package com.example.core.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import net.bytebuddy.asm.Advice.Return;

public class ConfigurationReader {

    public static String getDriverFromPropertiesFile(String propertyName) throws IOException {
        String browser = "";
        try (FileInputStream input = new FileInputStream("src/test/java/com/example/core/configuration/config.properties")) { //"src\\test\\java\\com\\example\\core\\configuration\\config.properties"
            Properties prop = new Properties();

            prop.load(input);

            // get the property value and print it out
            browser = prop.getProperty(propertyName);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return browser;
    }

    public static Integer getTimeoutFromPropertiesFile(String propertyName) throws IOException{
        int timeout = 0;
        try (FileInputStream input = new FileInputStream("src/test/java/com/example/core/configuration/config.properties")){
            Properties prop = new Properties();
            prop.load(input);
            timeout = Integer.parseInt(prop.getProperty(propertyName));
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        return timeout;
    }
}

