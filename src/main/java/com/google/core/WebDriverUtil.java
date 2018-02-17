package com.google.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebDriverUtil(WebDriver driver) {
        this.webDriver = driver;
        webDriverWait = new WebDriverWait(this.webDriver, 20);
    }

    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {
        return webDriverWait.until(expectedCondition);
    }

}
