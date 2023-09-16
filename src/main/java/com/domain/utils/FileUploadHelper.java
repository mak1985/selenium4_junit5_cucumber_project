package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FileUploadHelper {

    private static final Logger logger = LogManager.getLogger(FileUploadHelper.class);

    public static void uploadFile(WebDriver driver, WebElement fileInputElement, String filePath) {
        // Specify the file path
        fileInputElement.sendKeys(filePath);
        logger.info("Uploaded file");
    }
}
