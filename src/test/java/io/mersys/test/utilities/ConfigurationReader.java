package io.mersys.test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {


    //1- Create the object of Properties
    private static final Properties properties = new Properties();

    static {

        try {
            //2- We need to open the file in java memory: FileInputStream
            String confPath = "src/main/resources/configuration.properties";
            FileInputStream file = new FileInputStream(confPath);

            //3- Load the properties object using FileInputStream object
            properties.load(file);

            //4- Close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

}
