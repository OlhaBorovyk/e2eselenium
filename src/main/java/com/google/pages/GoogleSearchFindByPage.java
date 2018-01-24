package com.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchFindByPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"lst-ib\"]")
    private WebElement searchBox;

    public void searchFor(String text) {
        searchBox.sendKeys(text);
        searchBox.submit();
    }
}
