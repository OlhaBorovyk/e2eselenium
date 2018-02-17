package com.google;

import com.google.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CarsSelectorTest extends WebDriverTestBase {
    @Test
    public void testDropDown() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(iFrame);

        Select select = new Select(driver.findElement(By.xpath("/html/body/select")));
        select.selectByValue("Volvo");
    }


}
