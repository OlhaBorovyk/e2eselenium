package selenide.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selenide.util.PropertiesCache;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.*;

public class SelenideTestBase {
    private String browser = System.getProperty("browser", CHROME);
    private Long waitImplicit = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    private Long waitPage = Long.parseLong(PropertiesCache.getProperty("wait.page"));
    private Long waitScript = Long.parseLong(PropertiesCache.getProperty("wait.script"));
    private Long timeout = Long.parseLong(PropertiesCache.getProperty("timeout"));

    @BeforeClass
    public void SetUp() throws InterruptedException {
        Configuration.browser = browser;
        //Configuration.holdBrowserOpen = true;
        switch (browser) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();  //with latest version of driver
                break;
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();  //with latest version of driver
                break;
        }
        getWebDriver().manage().timeouts().implicitlyWait(waitImplicit, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().pageLoadTimeout(waitPage, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().setScriptTimeout(waitScript, TimeUnit.SECONDS);
        // getWebDriver().manage().timeouts().wait(timeout);
    }

    @AfterClass
    public void tearDown() {
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        webDriver.quit();
    }
}
