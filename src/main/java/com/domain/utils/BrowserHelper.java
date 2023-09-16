package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper extends CommonUtils {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BrowserHelper.class);
    public BrowserHelper(WebDriver driver) {
        super();
        BrowserHelper.driver = driver;

    }

    public void goBack() {
        driver.navigate().back();
        logger.info("Go back to previous page...");
    }

    public void goForward() {
        driver.navigate().forward();
        logger.info("Go forward to next page...");
    }

    public void refresh() {
        driver.navigate().refresh();
        logger.info("Refresh the current url...");
    }

    public Set<String> getWindowHandlens() {
        logger.info("Get window handles");
        return driver.getWindowHandles();

    }

    public void SwitchToWindow(int index) {

        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());

        if (index < 0 || index > windowsId.size())
            throw new IllegalArgumentException("Invalid Index : " + index);

        driver.switchTo().window(windowsId.get(index));
        logger.info("Switched to window using index");
    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());
        driver.switchTo().window(windowsId.get(0));
        logger.info("Switched to parent window");
    }

    public void switchToParentWithChildClose() {
        switchToParentWindow();

        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());

        for (int i = 1; i < windowsId.size(); i++) {
            windowsId.get(i);
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
        logger.info("Switched to parent window after closed all child windows");
    }
}
