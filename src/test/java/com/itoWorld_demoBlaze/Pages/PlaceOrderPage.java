package com.itoWorld_demoBlaze.Pages;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.itoWorld_demoBlaze.Utilities.AppTestBase;
import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaceOrderPage extends CommonPage {

    private static final Logger log = LogManager.getLogger(PlaceOrderPage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    private WebElement purchaseBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement checkoutConfirmationText;

    public void fillOutTheCheckoutForm() {
        Faker faker = new Faker();
        AppTestBase.getDriver().findElement(By.id("name")).sendKeys(faker.name().fullName());
        AppTestBase.getDriver().findElement(By.id("country")).sendKeys(faker.country().name());
        AppTestBase.getDriver().findElement(By.id("city")).sendKeys(faker.address().city());
        AppTestBase.getDriver().findElement(By.id("card")).sendKeys(faker.finance().creditCard(CreditCardType.VISA));
        AppTestBase.getDriver().findElement(By.id("month")).sendKeys("Feb");
        AppTestBase.getDriver().findElement(By.id("year")).sendKeys("2024");
    }

    public void selectPurchaseBtn() {
        CommonMethod.clickWithJS(purchaseBtn);
    }

    public void verifyCheckoutConfirmationText() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[text()='Thank you for your purchase!']")));
        Assert.assertTrue(checkoutConfirmationText.isDisplayed());
        log.info("The place order has been completed successfully");
    }
}
