package com.itoWorld_demoBlaze.StepDefinitions;

import com.itoWorld_demoBlaze.Pages.ContactPage;
import io.cucumber.java.en.When;

public class ContactPageStepDefinition {

    private final ContactPage contactPage = new ContactPage();

    @When("the form is completed")
    public void the_form_is_completed() {
        contactPage.fillOutContactForm();
        contactPage.selectSendMessageBtn();
    }
}
