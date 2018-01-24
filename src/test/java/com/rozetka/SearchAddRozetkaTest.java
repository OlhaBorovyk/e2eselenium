package com.rozetka;

import com.rozetka.core.WebDriverTestBase;
import com.rozetka.pages.RozetkaAddToCartPage;
import com.rozetka.pages.RozetkaCartPage;
import com.rozetka.pages.RozetkaResultPage;
import com.rozetka.pages.RozetkaSearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchAddRozetkaTest extends WebDriverTestBase {
    private String searchData = "iphone 7 plus 128 silver";
    private String resultData = "iPhone 7 Plus 128GB Silver";

    @Test
    public void searchAddTest() {
        driver.get("https://rozetka.com.ua");
        RozetkaSearchPage rozetkaSearchPage = new RozetkaSearchPage(driver);
        rozetkaSearchPage.searchFor(searchData);
        RozetkaResultPage rozetkaResultPage = new RozetkaResultPage(driver);
        assertTrue(rozetkaResultPage.linkResult().getText().contains(resultData));
        RozetkaAddToCartPage rozetkaAddToCartPage = new RozetkaAddToCartPage(driver);
        rozetkaAddToCartPage.addToCart();
        RozetkaCartPage rozetkaCartPage = new RozetkaCartPage(driver);
        assertTrue(rozetkaCartPage.getCart().getText().contains(resultData));
    }
}
