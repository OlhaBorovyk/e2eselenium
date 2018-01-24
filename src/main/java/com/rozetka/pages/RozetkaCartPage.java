package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaCartPage {
    private WebDriver driver;
    private By cartLocator = By.xpath("//*[@id=\"cart_block31042\"]/a");
    private By productLinkLocator = By.xpath("//*[@id=\"cart-popup\"]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/a");
    private WebElement cart;
    private WebElement productLink;

    public RozetkaCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCart() {
        cart = driver.findElement(cartLocator);
        cart.click();
        productLink = driver.findElement(productLinkLocator);
        return productLink;
    }
}
