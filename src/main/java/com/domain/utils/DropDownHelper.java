package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropDownHelper extends CommonUtils {

    private static final Logger logger = LogManager.getLogger(DropDownHelper.class);
    private WebDriver driver;

    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUsingVisibleValue(WebElement element, String visibleValue) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleValue);
            logger.info("Selected element using visible value: " + visibleValue);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            logger.error("Error while selecting element by visible value: " + e.getMessage());
        }
    }

    public String getSelectedValue(WebElement element) {
        try {
            String value = new Select(element).getFirstSelectedOption().getText();
            logger.info("Retrieved selected value: " + value);
            return value;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            logger.error("Error while getting selected value: " + e.getMessage());
            return null;
        }
    }
}
