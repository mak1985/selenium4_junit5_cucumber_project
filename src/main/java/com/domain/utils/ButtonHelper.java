package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ButtonHelper extends CommonUtils {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ButtonHelper.class);
    public ButtonHelper(WebDriver driver) {
        ButtonHelper.driver = driver;

    }

    public void click(By locator) {
        click(driver.findElement(locator));
        logger.info("Clicked the web element");
    }
}
