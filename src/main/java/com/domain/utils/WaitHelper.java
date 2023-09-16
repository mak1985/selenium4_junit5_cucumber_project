package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WaitHelper extends CommonUtils {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(WaitHelper.class);

    public WaitHelper(WebDriver driver) {
        super();
        WaitHelper.driver = driver;
    }

    public void hardWait(int timeOutInMiliSec) throws InterruptedException {
        Thread.sleep(timeOutInMiliSec);
        logger.info("Hard wait...");
    }

    public WebElement handleStaleElement(By locator, int retryCount, int delayInSeconds) throws InterruptedException {

        WebElement element = null;

        while (retryCount >= 0) {
            try {
                element = driver.findElement(locator);
                logger.info("Handled stale element...");
                return element;
            } catch (StaleElementReferenceException e) {
                hardWait(delayInSeconds);
                retryCount--;
            }
        }
        throw new StaleElementReferenceException("Element cannot be recovered");
    }
}
