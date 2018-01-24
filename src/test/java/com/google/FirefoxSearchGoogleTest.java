package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FirefoxSearchGoogleTest {
    private WebDriver driver;
    private By searchFieldLocator = By.xpath("//*[@id=\"lst-ib\"]");
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private By searchButtonLocator = By.xpath("//*[@id=\"sbtc\"]/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input");
    private WebElement searchField;
    private WebElement linkField;
    private WebElement searchButton;
    private String searchData = "Selenium";


    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //поиск элемента
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //загрузка страницы
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //ожидание срабатывания скрипта
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }

    @Test
    public void searchGoogleTest() {
        driver.get("https://www.google.com.ua");
        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchData);
        //searchField.submit();
        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        linkField = driver.findElement(linkLocator);
        assertTrue(linkField.getText().contains(searchData));
    }

}
