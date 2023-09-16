package com.domain.stepdefinitions;

import com.domain.core.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.domain.core.BaseClass.driver;


public class Hooks {
    @Before
    public void start()
    {
        BaseClass.setUp();
    }

    @AfterStep
    public static void takeScreenshots(Scenario scenario) {

        final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    @After
    public void stop() {
        BaseClass.tearDown();
    }
}
