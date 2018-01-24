package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;
    private By searchFieldLocator = By.xpath("//*[@id=\"lst-ib\"]");
    private WebElement searchField;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String searchData) {
        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchData);
        searchField.submit();
    }
}
