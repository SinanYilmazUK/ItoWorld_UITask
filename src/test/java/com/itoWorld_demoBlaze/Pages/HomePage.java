package com.itoWorld_demoBlaze.Pages;

import com.itoWorld_demoBlaze.StepDefinitions.User;
import com.itoWorld_demoBlaze.Utilities.AppTestBase;
import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class HomePage extends CommonPage {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    public static String itemName;

    @FindBy(id = "sign-username")
    private WebElement signUsername;

    @FindBy(id = "sign-password")
    private WebElement signPassword;

    @FindBy(xpath = "//button[contains(text(), 'Sign up')]")
    private WebElement signupBtn;

    @FindBy(id = "loginusername")
    private WebElement loginUsername;

    @FindBy(id = "loginpassword")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    private WebElement loginBtn;

    @FindBy(id = "nameofuser")
    private WebElement nameOfUser;

    @FindBy(id = "logout2")
    private WebElement logoutBtn;

    @FindBy(css = ".hrefch")
    private List<WebElement> listOfItems;

    @FindBy(css = ".list-group-item")
    private List<WebElement> categories;

    public User createUserCredentials() {
        return new User();
    }

    public void fillOutSigninForm(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(signUsername));
        signUsername.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(signPassword));
        signPassword.sendKeys(password);
    }

    public void fillOutLoginForm(String username, String password) {
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
    }

    public void selectSignupBtn() {
        signupBtn.click();
    }

    public void selectLoginBtn() {
        loginBtn.click();
    }

    public void verifyMessage(String expectedMessage) {
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = AppTestBase.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        AppTestBase.getDriver().switchTo().alert().accept();
    }

    public void verifyLoginMessage(String username) {
        CommonMethod.waitFor(2);
        wait.until(ExpectedConditions.visibilityOf(nameOfUser));
        Assert.assertTrue(nameOfUser.getText().contains(username));
    }

    public void logout() {
        logoutBtn.click();
    }

    public void selectItem(String category, String product) {
        for (WebElement cat : categories) {
            if (cat.getText().equalsIgnoreCase(category)) {
                CommonMethod.clickWithJS(cat);
                break;
            }
        }
        CommonMethod.waitFor(2);
        for (WebElement item : listOfItems) {
            CommonMethod.scrollToElement(item);
            if (item.getText().equalsIgnoreCase(product)) {
                itemName = item.getText();
                log.info("Selected item: " + itemName);
                CommonMethod.clickWithJS(item);
                break;
            }
        }
    }

    public void selectCategory(String category) {
        for (WebElement cat : categories) {
            if (cat.getText().equalsIgnoreCase(category)) {
                CommonMethod.clickWithJS(cat);
                break;
            }
        }
    }

    public List<String> getRespectiveListOfProducts() {
        CommonMethod.waitFor(2);
        return CommonMethod.getElementsText(listOfItems);
    }
}
