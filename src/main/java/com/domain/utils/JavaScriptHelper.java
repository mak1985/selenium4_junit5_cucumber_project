package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper extends CommonUtils {

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;

    }


    public Object executeScript(String script) {
        try {
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            logger.info("Executing JavaScript: " + script);
            return exe.executeScript(script);
        } catch (Exception e) {
            logger.error("Error executing JavaScript: " + e.getMessage());
            return null;
        }
    }
    public Object executeScript(String script, Object... args) {
        try {
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            logger.info("Executing JavaScript: " + script);
            return exe.executeScript(script, args);
        } catch (Exception e) {
            logger.error("Error executing JavaScript: " + e.getMessage());
            return null;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element");
        } catch (Exception e) {
            logger.error("Error scrolling to element: " + e.getMessage());
        }
    }

    public void scrollToElement(By locator) {
        try {
            scrollToElement(driver.findElement(locator));
        } catch (Exception e) {
            logger.error("Error scrolling to element: " + e.getMessage());
        }
    }

    public void scrollToElementAndClick(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            scrollToElement(element);
            element.click();
            logger.info("Scrolled to element and clicked");
        } catch (Exception e) {
            logger.error("Error scrolling to element and clicking: " + e.getMessage());
        }
    }

    public void scrollToElementAndClick(WebElement element) {
        try {
            scrollToElement(element);
            element.click();
            logger.info("Scrolled to element and clicked");
        } catch (Exception e) {
            logger.error("Error scrolling to element and clicking: " + e.getMessage());
        }
    }

    public void scrollIntoView(WebElement element) {
        try {
            executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element");
        } catch (Exception e) {
            logger.error("Error scrolling to element: " + e.getMessage());
        }
    }

    public void scrollIntoView(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            scrollIntoView(element);
            logger.info("Scrolled into view");
        } catch (Exception e) {
            logger.error("Error scrolling to element by locator: " + e.getMessage());
        }
    }

    public void scrollIntoViewAndClick(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            scrollIntoView(element);
            element.click();
            logger.info("Scrolled into view and clicked");
        } catch (Exception e) {
            logger.error("Error scrolling to element and clicking by locator: " + e.getMessage());
        }
    }

    public void scrollIntoViewAndClick(WebElement element) {
        try {
            scrollIntoView(element);
            element.click();
            logger.info("Scrolled into view and clicked");
        } catch (Exception e) {
            logger.error("Error scrolling to element and clicking: " + e.getMessage());
        }
    }
}
