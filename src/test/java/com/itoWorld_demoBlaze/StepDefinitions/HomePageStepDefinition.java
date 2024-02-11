package com.itoWorld_demoBlaze.StepDefinitions;

import com.itoWorld_demoBlaze.Pages.HomePage;
import com.itoWorld_demoBlaze.Utilities.AppTestBase;
import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;

public class HomePageStepDefinition {

    private final HomePage homePage = new HomePage();
    private static String username;
    private static String password;

    //GIVENS
    @Given("a demoBlaze home page is open")
    public void a_demo_blaze_home_page_is_opened() {
        Assert.assertEquals(AppTestBase.getDriver().getCurrentUrl(), "https://www.demoblaze.com/index.html");
    }

    @Given("an unrecognized user")
    public void an_unrecognized_user() {
        User unrecognizedUser = homePage.createUserCredentials();
        username = unrecognizedUser.getUsername();
        password = unrecognizedUser.getPassword();
    }

    @Given("a recognized user")
    public void a_recognized_user() {
        an_unrecognized_user();
        the_user_wants_to_sign_up();
        message_should_be_appear("Sign up successful.");
    }

    @Given("the user selects a item")
    public void the_user_selects_a_item() {
        homePage.selectItem("Laptops", "MacBook Pro");
    }

    @Given("the user selects {string} button")
    public void the_user_selects_button(String buttonName) {
        CommonMethod.selectButton(buttonName);
    }

    //WHENS
    @When("the user wants to sign up")
    public void the_user_wants_to_sign_up() {
        AppTestBase.getDriver().navigate().refresh();
        CommonMethod.selectButton("Sign up");
        homePage.fillOutSigninForm(username, password);
        homePage.selectSignupBtn();
    }

    @When("the user wants to log in")
    public void the_user_wants_to_log_in() {
        CommonMethod.selectButton("Log in");
        homePage.fillOutLoginForm(username, password);
        homePage.selectLoginBtn();
    }

    @When("the user wants to sign up without a password")
    public void the_user_wants_to_sign_up_without_a_password() {
        AppTestBase.getDriver().navigate().refresh();
        CommonMethod.selectButton("Sign up");
        homePage.fillOutSigninForm(username, "");
        homePage.selectSignupBtn();
    }

    @When("the user select the {string} category")
    public void the_user_select_the_category(String categoryName) {
        homePage.selectCategory(categoryName);
    }

    //THENS
    @Then("{string} message should appear")
    public void message_should_be_appear(String expectedMessage) {
        homePage.verifyMessage(expectedMessage);
    }

    @Then("the user should log in")
    public void the_user_should_log_in() {
        homePage.verifyLoginMessage(username);
        homePage.logout();
    }

    @Then("the list of product should be displayed as below:")
    public void the_list_of_product_should_be_displayed_as_below(List<String> expectedListOfProduct) {
        List<String> actualListOfProduct = homePage.getRespectiveListOfProducts();
        Assert.assertEquals(actualListOfProduct, expectedListOfProduct);
    }
}
