package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropDownHelper extends CommonUtils {

    private static final Logger logger = LogManager.getLogger(DropDownHelper.class);
    public static WebDriver driver;

    public DropDownHelper(WebDriver driver) {
        super();
        DropDownHelper.driver = driver;
    }

    public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
        logger.info("Select element using visible value");
    }

    public String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        logger.info("getSelectedValue method");
        return value;
    }
}
