package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper extends CommonUtils {

    public static WebDriver driver;

    private static final Logger logger = LogManager.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver) {
        JavaScriptHelper.driver = driver;

    }

    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        logger.info("JavascriptExecutor method");
        return exe.executeScript(script);

    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        logger.info("JavascriptExecutor method");
        return exe.executeScript(script, args);
    }

    public void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])",
                element.getLocation().x, element.getLocation().y);
        logger.info("scrolled to element");
    }

    public void scrollToElemet(By locator) {
        scrollToElemet(driver.findElement(locator));
        logger.info("scrolled to element");
    }

    public void scrollToElemetAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        scrollToElemet(element);
        element.click();
        logger.info("scrolled to element and clicked");
    }

    public void scrollToElemetAndClick(WebElement element) {
        scrollToElemet(element);
        element.click();
        logger.info("scrolled to element and clicked");
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
        logger.info("scrolled into view");
    }

    public void scrollIntoView(By locator) {
        scrollIntoView(driver.findElement(locator));
        logger.info("scrolled into view");
    }

    public void scrollIntoViewAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        scrollIntoView(element);
        element.click();
        logger.info("scrolled into view and clicked");
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
        logger.info("scrolled into view and clicked");
    }
}
