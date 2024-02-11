package com.itoWorld_demoBlaze.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
                glue = "com/itoWorld_demoBlaze/StepDefinitions",
                tags = "@test",
                dryRun = false
                )
public class Runner extends AbstractTestNGCucumberTests {
}
