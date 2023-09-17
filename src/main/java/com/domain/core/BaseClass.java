package com.domain.core;

import com.domain.config.ConfigsReader;
import com.domain.config.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



import java.time.Duration;

public class BaseClass {
    public static final long IMPLICIT_WAIT_TIME = 10;
    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    /**
     * This method will create a driver and return it
     *
     * @return WebDriver driver
     */
    public static WebDriver setUp() {

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        logger.info("Setting up the test environment.");
        switch (ConfigsReader.getProperty("browser").toLowerCase()) {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);      //Selenium4 no longer required webdriver.exe path
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");  // Enable headless mode
                //logger.info("chrome browser is running as headless mode");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                logger.info("chromedriver has been initialized...");
                break;
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);        //Selenium4 no longer required webdriver.exe path
                driver = new FirefoxDriver();
                break;
            case "ie":
//                System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);              //Selenium4 no longer required webdriver.exe path
                driver=new InternetExplorerDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported!...");
        }
        logger.info("Browser has been launched");
        driver.manage().window().maximize();
        logger.info("Browser has been maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        logger.info("Implicitly wait for 10 seconds");
        driver.get(ConfigsReader.getProperty("url"));
        logger.info("Application URL has been launched successfully!");

        // we initialize all the page elements of the classes in package com.automation.pages
        PageInitializer.initialize();

        return driver;
    }
    /**
     *  This method will quit the browser
     */
    public static void tearDown()	{
        if (driver != null ) {
            driver.quit();
            logger.info("Browser has been closed successfully!");
        }
    }
}
