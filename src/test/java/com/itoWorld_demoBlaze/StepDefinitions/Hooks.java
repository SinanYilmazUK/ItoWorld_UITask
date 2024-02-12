package com.itoWorld_demoBlaze.StepDefinitions;

import com.itoWorld_demoBlaze.Utilities.AppTestBase;
import com.itoWorld_demoBlaze.Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = AppTestBase.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        AppTestBase.closeDriver();
    }

}
