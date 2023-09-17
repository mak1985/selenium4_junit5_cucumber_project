package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class ButtonHelper extends CommonUtils {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ButtonHelper.class);
    public ButtonHelper(WebDriver driver) {
        this.driver = driver;

    }

    public void click(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
            logger.info("Clicked the web element with locator: " + locator);
        } catch (NoSuchElementException e) {
            logger.error("Element not found with locator: " + locator);
        }
    }
}
