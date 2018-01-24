package com.google;

import com.google.core.WebDriverTestBase;
import com.google.pages.GoogleLoginPage;
import org.testng.annotations.Test;

public class LoginGoogleTest extends WebDriverTestBase {
    private String emailData = "cloud.pocketbook@gmail.com";
    private String passwordData = "test1234567";

    @Test
    public void loginGoogleTest() {
        driver.get("https://www.google.com.ua");
        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);
        googleLoginPage.login(emailData, passwordData);

    }

}
