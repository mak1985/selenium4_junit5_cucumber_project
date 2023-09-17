package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FileUploadHelper extends CommonUtils{

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(FileUploadHelper.class);

    public static void uploadFile(WebDriver driver, WebElement fileInputElement, String filePath) {
        try {
            // Specify the file path in the file input element
            fileInputElement.sendKeys(filePath);
            logger.info("Uploaded file: " + filePath);
        } catch (Exception e) {
            logger.error("Error while uploading file: " + e.getMessage());
        }
    }
}
