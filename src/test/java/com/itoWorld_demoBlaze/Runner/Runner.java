package com.itoWorld_demoBlaze.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = "com/itoWorld_demoBlaze/StepDefinitions",
        plugin = { "pretty", "html:target/cucumber-html-reports.html" },
        tags = "@homepage",
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {
}
