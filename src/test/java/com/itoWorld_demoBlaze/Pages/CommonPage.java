package com.itoWorld_demoBlaze.Pages;

import com.itoWorld_demoBlaze.Utilities.AppTestBase;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {

     public CommonPage() {
          PageFactory.initElements(AppTestBase.getDriver(), this);
     }

     WebDriverWait wait = new WebDriverWait(AppTestBase.getDriver(),30);

}
