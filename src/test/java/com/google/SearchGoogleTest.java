package com.google;

import com.google.core.WebDriverTestBase;
import com.google.pages.GoogleResultPage;
import com.google.pages.GoogleSearchFindByPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchGoogleTest extends WebDriverTestBase {

    private By searchFieldLocator = By.xpath("//*[@id=\"lst-ib\"]");
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private WebElement searchField;
    private WebElement linkField;
    private String searchData = "Selenium";

//    @Test
//    public void searchGoogleTest() {
//        driver.get("https://www.google.com.ua");
//        searchField = driver.findElement(searchFieldLocator);
//        searchField.sendKeys(searchData);
//        searchField.submit();
//        linkField = driver.findElement(linkLocator);
//        assertTrue(linkField.getText().contains(searchData));
//    }

    @Test
    public void searchGooglePageObjectPage() {
        driver.get("https://www.google.com.ua");
        GoogleSearchFindByPage searchPage = PageFactory.initElements(driver, GoogleSearchFindByPage.class);
        searchPage.searchFor(searchData);
//        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
//        googleSearchPage.searchFor(searchData);
        GoogleResultPage googleResultPage = new GoogleResultPage(driver);
        assertTrue(googleResultPage.findLink().getText().contains(searchData));
    }
}