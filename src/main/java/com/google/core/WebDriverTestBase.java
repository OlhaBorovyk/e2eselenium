package com.google.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners(com.google.core.TestListener.class)
public class WebDriverTestBase {
    protected WebDriver driver;
    protected BrowserEnum browser = BrowserEnum.valueOf(System.getProperty("browser", "CHROME"));

    private DesiredCapabilities setDesiredCapabilities(String platform, String remoteBrowser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase(Platform.WIN8_1.name())) {
            caps.setPlatform(Platform.WIN8_1);
            caps.setBrowserName(remoteBrowser);
        }
        return caps;
    }

    @Parameters({"platform", "remoteBrowser"})
    @BeforeClass
    public void SetUp(@Optional String platform, @Optional String remoteBrowser) throws MalformedURLException {
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
            case REMOTE:
                DesiredCapabilities caps = setDesiredCapabilities(platform, remoteBrowser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
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
