package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import java.net.URL;

public class NavigationHelper extends CommonUtils {

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(NavigationHelper.class);

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;

    }

    public void navigateTo(String url) {
        try {
            driver.get(url);
            logger.info("Navigated to: " + url);
        } catch (Exception e) {
            logger.error("Error while navigating to: " + url + "\n" + e.getMessage());
        }
    }

    public void navigateTo(URL url) {
        try {
            driver.get(url.toString());
            logger.info("Navigated to: " + url);
        } catch (Exception e) {
            logger.error("Error while navigating to: " + url + "\n" + e.getMessage());
        }
    }

    public String getTitle() {
        try {
            String title = driver.getTitle();
            logger.info("Retrieved page title: " + title);
            return title;
        } catch (Exception e) {
            logger.error("Error while getting page title: " + e.getMessage());
            return null;
        }
    }

    public String getCurrentUrl() {
        try {
            String currentUrl = driver.getCurrentUrl();
            logger.info("Retrieved current URL: " + currentUrl);
            return currentUrl;
        } catch (Exception e) {
            logger.error("Error while getting current URL: " + e.getMessage());
            return null;
        }
    }
}
