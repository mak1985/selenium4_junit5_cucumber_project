package com.domain.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",   // Path to your feature files
        glue = "com.domain.stepdefinitions",                 // Package containing your step definitions
        plugin = {
                "pretty",                               // Standard pretty format console output
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_script.txt"
        },
        monochrome = true,                          // Display console output in a readable format
//        tags = "@smoke",                             // Run scenarios tagged as "@smoke" (customize as needed)
        dryRun = false
)
public class TestRunner {
}
