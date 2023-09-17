package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WaitHelper extends CommonUtils {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(WaitHelper.class);

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void hardWait(int timeOutInMilliseconds) throws InterruptedException {
        Thread.sleep(timeOutInMilliseconds);
        logger.info("Hard wait for " + timeOutInMilliseconds + " milliseconds...");
    }

    public WebElement handleStaleElement(By locator, int retryCount, int delayInSeconds) throws InterruptedException {
        WebElement element = null;

        while (retryCount >= 0) {
            try {
                element = driver.findElement(locator);
                logger.info("Handled stale element...");
                return element;
            } catch (StaleElementReferenceException e) {
                logger.warn("StaleElementReferenceException encountered. Retries remaining: " + retryCount);
                if (retryCount == 0) {
                    logger.error("Element cannot be recovered after retries.");
                    throw e;
                }
                hardWait(delayInSeconds * 1000); // Convert seconds to milliseconds
                retryCount--;
            }
        }
        return null; // This point should not be reached, as it throws an exception earlier
    }
}
