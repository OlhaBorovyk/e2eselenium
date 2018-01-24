package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaAddToCartPage {
    private WebDriver driver;
    private By goByLinkLocator = By.xpath("//*[@id=\"block_with_search\"]/div/div[2]/div[1]/div[3]/div[2]/div[1]");
    private By addToCartButtonLocator = By.xpath("//*[@id=\"detail_buy_label\"]/div[4]/div[1]/div/form/span/span/button");
    private By closeTheWindowLocator = By.xpath("//*[@id=\"cart-popup\"]/a/img");
    private WebElement goByLink;
    private WebElement addToCartButton;
    private WebElement closeTheWindow;

    public RozetkaAddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        goByLink = driver.findElement(goByLinkLocator);
        goByLink.click();
        addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        closeTheWindow = driver.findElement(closeTheWindowLocator);
        closeTheWindow.click();
    }
}
