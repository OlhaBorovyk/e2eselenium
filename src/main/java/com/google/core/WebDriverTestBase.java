package com.google.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(com.google.core.TestListener.class)
public class WebDriverTestBase {
    protected WebDriver driver;
    protected BrowserEnum browser = BrowserEnum.valueOf(System.getProperty("browser", "CHROME"));

    @BeforeClass
    public void SetUp() {
        switch (browser) {
            case CHROME:
                //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
                WebDriverManager.chromedriver().setup();  //with latest version of driver
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
                WebDriverManager.firefoxdriver().setup();  //with latest version of driver
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //timeout for page load
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS); //timeout for load scripts
    }

//    @AfterClass
//    public void tearDown() {
//        //driver.close(); //current tab
//
//        driver.quit(); //close at all
//    }

//    @BeforeClass
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

}
