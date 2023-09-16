package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkHelper extends CommonUtils {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LinkHelper.class);
    public LinkHelper(WebDriver driver) {
        super();
        LinkHelper.driver = driver;

    }

    public String getHyperLink(WebElement element) {
        String link = element.getAttribute("hreg");
        logger.info("Clicked hyperlink");
        return link;
    }
}
