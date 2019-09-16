package io.bestappd.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private Properties properties = new Properties();

    public ReadProperties(String configProperties) {
        try (InputStream input = new FileInputStream(configProperties)) {

            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getValue(String key) {
        String value = properties.getProperty(key);
        return value;
    }

}
