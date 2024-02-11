package com.itoWorld_demoBlaze.StepDefinitions;

import com.itoWorld_demoBlaze.Pages.HomePage;
import com.itoWorld_demoBlaze.Pages.ProductPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductPageStepDefinition {

    private final ProductPage productPage = new ProductPage();

    @When("the user adds the item to the cart")
    public void the_user_adds_the_item_to_the_cart() {
        Assert.assertEquals(HomePage.itemName, productPage.itemName.getText());
        productPage.addToCart();
    }
}
