package com.itoWorld_demoBlaze.StepDefinitions;

import com.itoWorld_demoBlaze.Pages.PlaceOrderPage;
import io.cucumber.java.en.Then;

public class PlaceOrderStepDefinition {

    private final PlaceOrderPage placeOrderPage = new PlaceOrderPage();

    @Then("a successful checkout confirmation should be displayed")
    public void a_successful_checkout_confirmation_should_be_displayed() {
        placeOrderPage.fillOutTheCheckoutForm();
        placeOrderPage.selectPurchaseBtn();
        placeOrderPage.verifyCheckoutConfirmationText();
    }
}
