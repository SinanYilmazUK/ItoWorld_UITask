package com.itoWorld_demoBlaze.Pages;

import com.github.javafaker.Faker;
import com.itoWorld_demoBlaze.Utilities.CommonMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends CommonPage {

    @FindBy(id = "recipient-email")
    private WebElement email;

    @FindBy(id = "recipient-name")
    private WebElement name;

    @FindBy(id = "message-text")
    private WebElement message;

    @FindBy(xpath = "//button[@onclick='send()']")
    private WebElement selectSendMessageBtn;

    public void fillOutContactForm() {
        Faker faker = new Faker();
        email.sendKeys(faker.internet().emailAddress());
        name.sendKeys(faker.name().fullName());
        message.sendKeys(faker.lorem().paragraph());
    }

    public void selectSendMessageBtn() {
        CommonMethod.clickWithJS(selectSendMessageBtn);
    }
}
