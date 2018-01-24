package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaSearchPage {
    private WebDriver driver;
    private By searchFieldLocator = By.xpath("//*[@id=\"rz-search\"]/form/div[1]/div[2]/input");
    private By searchButtonLocator = By.xpath("//*[@id=\"rz-search\"]/form/span/span/button");
    private WebElement searchField;
    private WebElement searchButton;

    public RozetkaSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String searchData) {
        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchData);
        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
    }

}
