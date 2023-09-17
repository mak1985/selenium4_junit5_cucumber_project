package com.domain.stepdefinitions;


import com.domain.utils.CommonUtils;
import com.domain.config.ConfigsReader;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginTest extends CommonUtils {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    @Given("User is on SauceLabs login page")
    public void user_is_on_sauce_labs_login_page() {
        getPageTitle();
        logger.info("Application title verified");


    }
    @When("User enters username and password")
    public void user_enters_username_and_password() {
        enterText(loginPage.userName, ConfigsReader.getProperty("username"));
        logger.info("User enters username");
        enterText(loginPage.password, ConfigsReader.getProperty("password"));
        logger.info("User enters password");
    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
        logger.info("User clicks on login button");

    }
    @Then("User should navigated to product home page")
    public void user_should_navigated_to_product_home_page() {
        logger.info("User should navigated to product home page");

    }
}
