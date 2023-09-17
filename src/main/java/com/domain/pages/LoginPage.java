package com.domain.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.domain.core.BaseClass.driver;


public class LoginPage {
    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    public WebElement validateErrorMsg;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }
}
