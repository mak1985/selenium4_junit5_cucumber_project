package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkHelper extends CommonUtils {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LinkHelper.class);
    public LinkHelper(WebDriver driver) {
        super();
        this.driver = driver;

    }

    public String getHyperLink(WebElement element) {
        try {
            String link = element.getAttribute("href");
            logger.info("Retrieved hyperlink: " + link);
            return link;
        } catch (Exception e) {
            logger.error("Error while getting hyperlink: " + e.getMessage());
            return null;
        }
    }
}
