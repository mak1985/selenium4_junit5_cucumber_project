package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import java.net.URL;

public class NavigationHelper extends CommonUtils {

    public static WebDriver driver;

    private static final Logger logger = LogManager.getLogger(NavigationHelper.class);

    public NavigationHelper(WebDriver driver) {
        NavigationHelper.driver = driver;

    }

    public void navigateTo(String url) {
        driver.get(url);
        logger.info("Navigated to...");
    }

    public void naviagteTo(URL url) {
        driver.get(url.getPath());
        logger.info("Navigated to...");
    }

    public String getTitle() {
        driver.getTitle();
        logger.info("Get title...");
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        driver.getCurrentUrl();
        logger.info("Get current url...");
        return driver.getCurrentUrl();
    }
}
