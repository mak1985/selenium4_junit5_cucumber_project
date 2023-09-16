package com.domain.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    private static Properties prop;
    private static final Logger logger = LogManager.getLogger(ConfigsReader.class);
    /**
     *  This method will read the properties file
     *
     * @param String filePath
     */
    public static void readProperties(String filePath)  {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Reading properties file...");
    }
    /**
     *  This method will return the value for a specific key
     *
     * @param String key
     * @return String value
     */
    public static String getProperty(String key) {
        logger.info("Getting properties file...");
        return prop.getProperty(key);

    }
}
