package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckBoxOrRadioButtonHelper extends CommonUtils {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(CheckBoxOrRadioButtonHelper.class);
    public CheckBoxOrRadioButtonHelper(WebDriver driver) {
        this.driver = driver;

    }

    public boolean isIselected(WebElement element) {
        try {
            logger.info("Checked if web element is selected");
            return element.isSelected();
        } catch (NoSuchElementException e) {
            logger.error("Element not found while checking if selected.");
            return false;
        }
    }

    public boolean isIselected(By locator) {
        try {
            logger.info("Checked if web element is selected");
            return isIselected(driver.findElement(locator));
        } catch (NoSuchElementException e) {
            logger.error("Element not found with locator while checking if selected: " + locator);
            return false;
        }
    }
}
