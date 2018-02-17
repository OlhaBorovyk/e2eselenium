package com.google.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {
    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;
    private By searchFieldLocator = By.xpath("//*[@id=\"lst-ib\"]");
    private WebElement searchField;

    public AbstractPage(WebDriver driver) {
        this.webDriver = driver;
        webDriverUtil = new WebDriverUtil(driver);
    }


}
