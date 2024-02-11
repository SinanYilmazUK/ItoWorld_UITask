package com.itoWorld_demoBlaze.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethod {

    /***
     * Select the common header buttons using JavaScript
     * @param buttonName
     */
    public static void selectButton(String buttonName) {
        WebElement element = AppTestBase.getDriver().findElement(By.xpath("//a[contains(text(),'" + buttonName + "')]"));
        ((JavascriptExecutor) AppTestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) AppTestBase.getDriver()).executeScript("arguments[0].click();", element);
    }

    /***
     * Clicks on an element using JavaScript
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) AppTestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) AppTestBase.getDriver()).executeScript("arguments[0].click();", element);
    }

    /***
     * Scrolls down to an element using JavaScript
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) AppTestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /***
     * Perform a pause
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * waits for backgrounds processes on the browser to complete
     */
    public static void waitForPageToLoad() {
        AppTestBase.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /***
     * return a list of string from a list of elements
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
}
