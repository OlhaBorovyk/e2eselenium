package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RozetkaResultPage {
    private WebDriver driver;
    private By linkResultLocator = By.xpath("//*[@id=\"block_with_search\"]/div/div[2]/div[1]/div[3]/div[2]/div[1]");
    private WebElement linkResult;

    public RozetkaResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement linkResult() {
        linkResult = driver.findElement(linkResultLocator);
        return linkResult;
    }
}
