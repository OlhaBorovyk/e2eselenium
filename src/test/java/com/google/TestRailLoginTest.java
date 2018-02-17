package com.google;

import com.google.core.WebDriverTestBase;
import com.google.pages.TestRailLoginPage;
import org.testng.annotations.Test;

public class TestRailLoginTest extends WebDriverTestBase {
    private String email = "kswiridenko@gmail.com";
    private String password = "1234qwer!@#$QWER";

    @Test
    public void loginTest() {
        driver.get("https://openeducation.testrail.net/index.php?/auth/login");
        TestRailLoginPage testRailLoginPage = new TestRailLoginPage(driver);
        testRailLoginPage.login(email, password);
    }

}
