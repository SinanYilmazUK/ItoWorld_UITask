package com.itoWorld_demoBlaze.Pages;

import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CommonPage{

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(css = ".name:nth-child(1)")
    public WebElement itemName;

    @FindBy(css = ".btn-success")
    private WebElement addToCartBtn;

    public void addToCart(){
        CommonMethod.clickWithJS(addToCartBtn);
        CommonMethod.waitForPageToLoad();
        log.info(itemName.getText() + " has been added to the Cart");
        CommonMethod.waitForPageToLoad();
    }
}
