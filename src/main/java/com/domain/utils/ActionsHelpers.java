package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelpers {
    private WebDriver driver;
    private Actions actions;
    private static final Logger logger = LogManager.getLogger(AlertHelper.class);

    public ActionsHelpers(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void moveToElementAndClick(WebElement element) {
        // Move to the specified element and then click it.
        actions.moveToElement(element).click().perform();
    }

    public void doubleClickElement(WebElement element) {
        // Double-click the specified element.
        actions.doubleClick(element).perform();
    }

    public void rightClickElement(WebElement element) {
        // Right-click (context-click) the specified element.
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        // Drag the source element and drop it onto the target element.
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    public void sendKeysToElement(WebElement element, CharSequence keys) {
        // Send keys to the specified element.
        actions.click(element).sendKeys(keys).perform();
    }

    public void keyDown(CharSequence key) {
        // Simulate pressing a keyboard key down.
        actions.keyDown(key).perform();
    }

    public void keyUp(CharSequence key) {
        // Simulate releasing a keyboard key.
        actions.keyUp(key).perform();
    }

    public void performActions() {
        // Perform all queued actions.
        actions.perform();
    }
    public void clickAndHold(WebElement element) {
        // Click and hold the specified element.
        actions.clickAndHold(element).perform();
    }
    public void release(WebElement element) {
        // Release the mouse button on the specified element.
        actions.release(element).perform();
    }
    public void moveToElementAndHover(WebElement element) {
        // Move to the specified element and hover over it.
        actions.moveToElement(element).perform();
    }
}
