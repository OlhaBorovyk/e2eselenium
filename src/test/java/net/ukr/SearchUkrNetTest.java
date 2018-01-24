package net.ukr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchUkrNetTest {
    private WebDriver driver;
    private By searchFieldLocator = By.name("q");
    private WebElement searchField;
    private String searchData = "Selenium";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchUkrNetTest() {
        driver.get("https://www.google.com.ua");
        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchData);
        searchField.submit();
    }

}
