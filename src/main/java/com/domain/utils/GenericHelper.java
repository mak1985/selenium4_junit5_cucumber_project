package com.domain.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.NoSuchElementException;
public class GenericHelper extends CommonUtils {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(GenericHelper.class);

    public GenericHelper(WebDriver driver) {
        GenericHelper.driver = driver;

    }

    /**
     * Check for element is present based on locator
     * If the element is present return the web element otherwise null
     * @param locator
     * @return WebElement or null
     */

    public WebElement getElementWithNull(By locator) {

        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            // Ignore
        }
        logger.info("Get element with null");
        return null;

    }

    public boolean IsElementPresentQuick(By locator) {
        boolean flag = driver.findElements(locator).size() >= 1;
        logger.info("Is element present quick");
        return flag;
    }

}
