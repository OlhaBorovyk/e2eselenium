package com.google.pages;

import com.google.core.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends AbstractPage {

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

//    public void searchFor(String searchData){
//        searchField = driver.findElement(searchFieldLocator);
//        searchField.sendKeys(searchData);
//        searchField.submit();
//    }


}
