package com.itoWorld_demoBlaze.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AppTestBase {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser");

        if (driver == null) {
            switch (browserName) {
                case "Chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "Edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

