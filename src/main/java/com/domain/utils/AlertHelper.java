package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


public class AlertHelper extends CommonUtils {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AlertHelper.class);

    public AlertHelper(WebDriver driver) {
        this.driver = driver;

    }

    public Alert getAlert() {
        logger.info("Switched To alert...");
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        try {
            getAlert().accept();
            logger.info("Alert Accepted...");
        } catch (NoAlertPresentException e) {
            logger.warn("No alert is present to accept.");
        } catch (WebDriverException e) {
            logger.error("An error occurred while accepting the alert: " + e.getMessage());
        }
    }

    public void dismissAlert() {
        try {
            getAlert().dismiss();
            logger.info("Alert dismissed...");
        } catch (NoAlertPresentException e) {
            logger.warn("No alert is present to dismiss.");
        } catch (WebDriverException e) {
            logger.error("An error occurred while dismissing the alert: " + e.getMessage());
        }
    }

    public boolean isAlertPresent() {
        logger.info("Checking if Alert Present or not...");
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            logger.info("No alert present.");
            return false;
        } catch (WebDriverException e) {
            logger.error("An error occurred while checking for alert presence: " + e.getMessage());
            return false;
        }
    }

    public void acceptPrompt(String text) {
        if (isAlertPresent()) {
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
            logger.info("Accepted prompt with text value: " + text);
        } else {
            logger.warn("No prompt alert is present to accept.");
        }
    }



}
