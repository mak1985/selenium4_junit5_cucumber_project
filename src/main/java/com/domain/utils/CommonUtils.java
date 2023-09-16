package com.domain.utils;

import com.domain.config.Constants;
import com.domain.core.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonUtils extends PageInitializer {
    /**
     * This method clears the textbox and sends another text
     *
     * @param element
     * @param text
     */
    private static final Logger logger = LogManager.getLogger(CommonUtils.class);
    private WebDriverWait wait;
    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        logger.info("Entered text to the text field");
    }
    /**
     * This method checks if radio/checkbox is enabled and then clicks on the
     * element that has the value we want
     *
     *
     * @param listElement
     * @param value
     */
    public static void clickRadioOrCheckbox(List<WebElement> listElement, String value) {
        String actualValue;

        for (WebElement el : listElement) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) ;
            {
                el.click();
                break;
            }
        }
        logger.info("Clicked radio button or checkbox...");
    }
    /**
     * This method checks if the text is found in the dropdown element and only then
     * it selects it
     *
     * @param element
     * @param textToSelect
     */
    public static void selectDropdown(WebElement element, String textToSelect) {
        try {
            Select select = new Select(element);

            List<WebElement> options = select.getOptions();

            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
        logger.info("Selected dropdown...");
    }
    /**
     * This method checks if the index is valid and only then selects it
     *
     * @param element
     * @param index
     */
    public static void selectDropdown(WebElement element, int index) {

        try {
            Select select = new Select(element);
            int size = select.getOptions().size();
            if (size > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
        logger.info("Selected dropdown...");
    }
    /**
     * This method accepts alerts and catches exception if alert in not present
     *
     */
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        logger.info("Accepted alert...");
    }
    /**
     * This method will dismiss the alert after checking if alert is present
     *
     */
    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        logger.info("Dismissed alert...");
    }
    /**
     * This method returns the alert text. If no alert is present exception is
     * caught and null is returned.
     *
     * @return
     */
    public static String getAlertText() {
        String alertText = null;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        logger.info("Get alert text...");
        return alertText;

    }
    /**
     * This method send text to the alert. NoAlertPresentException is handled.
     *
     * @param text
     */
    public static void sendAlertText(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        logger.info("Sent alert text...");
    }
    /**
     * This method switches to a frame by using name or id
     *
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
        logger.info("switched to frame by nameOrId...");
    }
    /**
     * This method switches to a frame by using an index
     *
     * @param index
     */
    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
        logger.info("switched to frame by index...");
    }
    /**
     * This method switches to a frame by using a WebElement
     *
     * @param element
     */
    public static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
        logger.info("switched to frame by element...");
    }
    /**
     * This method switches focus to a child window
     *
     */
    public static void switchToChildWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }
        logger.info("switched to child window...");
    }
    /**
     * This method click in an element
     *
     * @param element
     */
    public static void click(WebElement element) {
        element.click();
        logger.info("Clicked to element...");
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Waited for element...");
    }
    /**
     * This methods casts the driver to a JavascriptExecutor and returns it
     *
     * @return
     */
    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        logger.info("JavascriptExecutor method");
        return js;

    }
    /**
     * This method will click in the element passed to it using JavascriptExecutor
     *
     * @param element
     */
    public static void jsClick(WebElement element) {
        getJSObject().executeScript("arguments[0].click()", element);
        logger.info("Clicked to element...");
    }
    /**
     * This method will scroll the page until the element passed to it becomes
     * visible
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
        logger.info("Scrolled to element...");
    }
    /**
     * This method will scroll the page down based on the passed pixel parameter
     *
     * @param pixel
     */
    public static void scrollDown(int pixel) {
        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
        logger.info("Scrolled down...");
    }

    public void ZoomBy100percentage() {
        getJSObject().executeScript("document.body.style.zoom='100%'");
        logger.info("Zoom out the screen...");
    }

    public void ZoomInBypercentage() {
        getJSObject().executeScript("document.body.style.zoom='40%'");
        logger.info("Zoom in the screen...");
    }

    public void scrollUpByPixel() {
        getJSObject().executeScript("window.scrollBy(0,-1500)");
        logger.info("Scrolled up by pixel...");
    }

    public void scrollDownByPixel() {
        getJSObject().executeScript("window.scrollBy(0,1500)");
        logger.info("Scrolled down by pixel...");
    }

    public void scrollIntoView(WebElement element) {
        getJSObject().executeScript("arguments[0].scrollIntoView()", element);
        logger.info("Scrolled into view...");
    }
    /**
     * This method will scroll the page up based on the passed pixel parameter
     *
     * @param pixel
     */
    public static void scrollUp(int pixel) {
        getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
        logger.info("Scrolled up to top...");
    }


    /**
     * This method will select a date from the calendar
     *
     * @param elements
     * @param text
     */
    public static void selectCalenderDate(List<WebElement> elements, String text) {
        for (WebElement day : elements) {
            if (day.isEnabled()) {
                if (day.getText().equals(text)) {
                    day.click();
                    break;
                }
            }
        }
        logger.info("Selected calender date...");
    }

    /**
     * Method to return the current time stamp in a String
     *
     * @return
     */
    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        logger.info("Get time stamp...");
        return simpleDateFormat.format(date.getTime());

    }
    /**
     * Method to get title of the web page
     *
     * @return
     */
    public String getPageTitle() {
        logger.info("Verified page title...");
        return driver.getTitle();
    }

    /**
     * Sample action code
     */
    public void pressEnter() {
        try {
            Thread.sleep(5000l);
            Actions ac = new Actions(driver);
            ac.sendKeys(Keys.ENTER).perform();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        logger.info("Hit enter key...");
    }

    public void scrollToElemet(WebElement element) {
        getJSObject().executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        logger.info("Scrolled to element...");
    }
    public void scrollToElemetAndClick(WebElement element) {
        scrollToElemet(element);
        element.click();
        logger.info("Scrolled to element and clicked...");
    }

    public void goBack() {
        driver.navigate().back();
        logger.info("Navigated back...");
    }
    public void goForward() {
        driver.navigate().forward();
        logger.info("Navigated forword...");
    }
    public void refresh() {
        driver.navigate().refresh();
        logger.info("Browser refreshed...");
    }
    /**
     * helper method to wait for element
     *
     * @param ele - WebElement
     * @return - boolean
     */
    public boolean waitForElement(WebElement ele) {
        logger.info("Waiting for element...");
        return wait.until(ExpectedConditions.elementToBeClickable(ele)) != null;
    }


    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // create destination as : filepath + filename + timestamp + .png
        String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() +  System.currentTimeMillis()+ ".png";

        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Taken screenshot...");
        return picBytes;

    }
}
