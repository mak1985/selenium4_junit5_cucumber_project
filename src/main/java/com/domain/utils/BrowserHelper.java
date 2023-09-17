package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper extends CommonUtils {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BrowserHelper.class);
    public BrowserHelper(WebDriver driver) {
        super();
        this.driver = driver;

    }

    public void goBack() {
        driver.navigate().back();
        logger.info("Go back to the previous page...");
    }

    public void goForward() {
        driver.navigate().forward();
        logger.info("Go forward to the next page...");
    }

    public void refresh() {
        driver.navigate().refresh();
        logger.info("Refresh the current URL...");
    }

    public Set<String> getWindowHandles() {
        logger.info("Get window handles");
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index) {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        if (index >= 0 && index <= windowsId.size() - 1) {
            driver.switchTo().window(windowsId.get(index));
            logger.info("Switched to window using index");
        } else {
            logger.error("Invalid index provided: " + index);
        }
    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        if (windowsId.size() > 0) {
            driver.switchTo().window(windowsId.get(0));
            logger.info("Switched to parent window");
        } else {
            logger.error("No parent window available.");
        }
    }

    public void switchToParentWithChildClose() {
        switchToParentWindow();
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        for (int i = 1; i < windowsId.size(); i++) {
            try {
                driver.switchTo().window(windowsId.get(i));
                driver.close();
            } catch (Exception e) {
                logger.error("Error while closing child window: " + e.getMessage());
            }
        }

        switchToParentWindow();
        logger.info("Switched to parent window after closing all child windows");
    }
}
