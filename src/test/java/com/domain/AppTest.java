package com.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppTest {
    private static void writeTextToPropertiesFile(String text) {
        try {
            Properties properties = new Properties();
            properties.setProperty("web_element_text", text);

            // Specify the path where you want to save the .properties file
            FileOutputStream output = new FileOutputStream("output.properties");

            // Write the properties to the file
            properties.store(output, "Web Element Text");

            // Close the output stream
            output.close();

            System.out.println("Text written to output.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (you'll need to download it)
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Optional: Configure Chrome options (e.g., disable notifications)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enable headless mode
        options.addArguments("--disable-notifications");

        // Create a WebDriver instance (in this case, for Chrome)
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the desired URL
        String url = "https://www.google.co.in/"; // Replace with your desired URL
        driver.get(url);


        // Perform your actions on the website here

        // Close the WebDriver when done
        driver.quit();
    }

}
