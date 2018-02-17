package selenide.google;

import com.google.core.WebDriverTestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllertTest extends WebDriverTestBase {

    @Test
    public void testAllert() {
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(iFrame);

        WebElement tryButton = driver.findElement(By.xpath("/html/body/button"));
        tryButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"demo\"]")).isDisplayed());
    }
}
