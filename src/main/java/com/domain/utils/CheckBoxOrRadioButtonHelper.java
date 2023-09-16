package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckBoxOrRadioButtonHelper extends CommonUtils {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(CheckBoxOrRadioButtonHelper.class);
    public CheckBoxOrRadioButtonHelper(WebDriver driver) {
        CheckBoxOrRadioButtonHelper.driver = driver;

    }

    public boolean isIselected(WebElement element) {
        logger.info("Checked if webelement is selected");
        boolean flag = element.isSelected();
        return flag;
    }

    public boolean isIselected(By locator)
    {
        logger.info("Checked if webelement is selected");
        return isIselected(driver.findElement(locator));

    }
}
