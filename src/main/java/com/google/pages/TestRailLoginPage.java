package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRailLoginPage {
    private WebDriver driver;
    private By emailFieldLocator = By.xpath("//*[@id=\"name\"]");
    private By passwordFieldLocator = By.xpath("//*[@id=\"password\"]");
    private By loginButtonLocator = By.xpath("//*[@id=\"content\"]/form/div[4]/butto");
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;

    public TestRailLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(email);
        passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

}
