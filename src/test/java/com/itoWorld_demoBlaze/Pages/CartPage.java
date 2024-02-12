package com.itoWorld_demoBlaze.Pages;

import com.itoWorld_demoBlaze.Utilities.AppTestBase;
import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CartPage extends CommonPage {

    private static final Logger log = LogManager.getLogger(CartPage.class);
    private static String removedItem;

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    private WebElement placeOrderBtn;

    @FindBy(css = "#tbodyid td:nth-child(2)")
    public List<WebElement> listOfProduct;

    public void verifyProductIntoCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#tbodyid td:nth-child(2)")));
        Assert.assertTrue(listOfProduct.size() > 0);
        for (WebElement product : listOfProduct) {
            if ((product.getText()).equalsIgnoreCase(HomePage.itemName)) {
                log.info("The selected " + HomePage.itemName + " has been listed in the Cart");
                break;
            } else {
                return;
            }
        }
    }

    public void removeAnItem(String itemName) {
        for (int i = 0; i < listOfProduct.size(); i++) {
            if (listOfProduct.get(i).getText().equalsIgnoreCase(itemName)) {
                AppTestBase.getDriver().findElement(By.xpath("(//a[contains(text(), 'Delete')])[" + (i + 1) + "]")).click();
                removedItem = listOfProduct.get(i).getText();
            }
        }
    }

    public boolean isItemRemoved() {
        CommonMethod.waitFor(2);
        for (WebElement element : listOfProduct) {
            if (element.getText().equals(removedItem)) {
                return false;
            }
        }
        log.info(removedItem + " has been removed from the cart");
        return true;
    }

    public void selectPlaceOrderBtn() {
        CommonMethod.waitFor(2);
        if (listOfProduct.size() > 0) {
            CommonMethod.clickWithJS(placeOrderBtn);
        } else {
            log.info("No product in your Cart");
        }
    }
}
