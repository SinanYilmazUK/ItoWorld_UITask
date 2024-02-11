package com.itoWorld_demoBlaze.StepDefinitions;

import com.itoWorld_demoBlaze.Pages.CartPage;
import com.itoWorld_demoBlaze.Pages.HomePage;
import com.itoWorld_demoBlaze.Pages.ProductPage;
import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CartPageStepDefinition {

    private final HomePage homePage = new HomePage();
    private final CartPage cartPage = new CartPage();
    private final ProductPage productPage = new ProductPage();

    //GIVENS
    @Given("the user has items in the cart")
    public void the_user_has_items_in_the_cart() {
        homePage.selectItem("Laptops", "MacBook Pro");
        productPage.addToCart();
        CommonMethod.selectButton("Home");
        homePage.selectItem("Monitors", "Apple monitor 24");
        productPage.addToCart();
    }

    //WHENS
    @When("the user removes an item from the cart")
    public void the_user_removes_an_item_from_the_cart() {
        CommonMethod.selectButton("Cart");
        cartPage.removeAnItem("Apple monitor 24");
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        CommonMethod.selectButton("Cart");
        cartPage.selectPlaceOrderBtn();
    }

    //THENS
    @Then("the item should be added to the cart")
    public void the_should_be_added_to_the_cart() {
        CommonMethod.selectButton("Cart");
        CommonMethod.waitForPageToLoad();
        cartPage.verifyProductIntoCart();
    }

    @Then("the item should be removed from the cart")
    public void the_item_should_be_removed_from_the_cart() {
        Assert.assertTrue(cartPage.isItemRemoved());
    }
}
