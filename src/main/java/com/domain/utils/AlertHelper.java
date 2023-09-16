package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertHelper extends CommonUtils {
    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AlertHelper.class);

    public AlertHelper(WebDriver driver) {
        AlertHelper.driver = driver;

    }
    public Alert getAlert() {
        logger.info("Switched To alert...");
        return driver.switchTo().alert();
    }
    public void AcceptAlert() {
        getAlert().accept();
        logger.info("Alert Accepted...");
    }
    public void DismissAlert() {
        getAlert().dismiss();
        logger.info("Alert dismissed...");
    }
    public boolean isAlertPresent() {
        logger.info("Checking if Alert Present or not...");
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            // Ignore
            return false;

        }

    }
    public void AcceptAlertIfPresent() {
        if (!isAlertPresent())
            return;
        AcceptAlert();
        logger.info("Accept alert if present...");
    }
    public void DismissAlertIfPresent() {

        if (!isAlertPresent())
            return;
        DismissAlert();
        logger.info("Dismissed alert if present...");
    }
    public void AcceptPrompt(String text) {
        if (!isAlertPresent())
            return;
        Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
        logger.info("Accepted prompt with text value...");
    }
}
