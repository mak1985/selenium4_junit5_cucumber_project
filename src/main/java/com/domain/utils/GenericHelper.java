package com.domain.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.NoSuchElementException;
public class GenericHelper extends CommonUtils {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(GenericHelper.class);

    public GenericHelper(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Check for element is present based on locator
     * If the element is present, return the web element; otherwise, null.
     *
     * @param locator The By locator to find the element.
     * @return WebElement or null
     */
    public WebElement getElementWithNull(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            logger.error("Element not found with locator: " + locator);
            return null;
        }
    }

    /**
     * Check if an element is present based on locator.
     *
     * @param locator The By locator to find the element.
     * @return True if the element is present, false otherwise.
     */
    public boolean isElementPresentQuick(By locator) {
        boolean flag = driver.findElements(locator).size() >= 1;
        logger.info("Is element present quick: " + locator);
        return flag;
    }
}
