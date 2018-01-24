package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleLoginPage {
    private WebDriver driver;
    private By searchButtonLocator = By.xpath("//*[@id=\"gb_70\"]");
    private By emailFieldLocator = By.name("identifier");
    private By nextButtonLocator = By.xpath("R//*[@id=\"identifierNext\"]/content/spanc");
    private By passwordFieldLocator = By.name("password");
    private By nextLocator = By.xpath("//*[@id=\"passwordNext\"]/content/span");

    private WebElement searchButton;
    private WebElement emailField;
    private WebElement nextButton;
    private WebElement passwordField;
    private WebElement next;

    public GoogleLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(email);
        emailField.submit();
//        nextButton = driver.findElement(nextButtonLocator);
//        nextButton.click();
        passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        passwordField.submit();
//        next = driver.findElement(nextLocator);
//        next.click();
    }
}
