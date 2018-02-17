package selenide.google;

import com.google.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends WebDriverTestBase {
    @Test
    public void testActions() {
        driver.get("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        WebElement elementSource = driver.findElement(By.xpath("//*[@id=\"sample\"]/div[1]/span[1]/div/div[2]"));
        WebElement element = driver.findElement(By.id("myDiagramDiv"));

        WebElement htmlCheckbox = driver.findElement(By.xpath("//*[@id=\"remove\"]"));
        htmlCheckbox.click();

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(elementSource)
                .moveToElement(element)
                .release(element)
                .build();

        dragAndDrop.perform();
    }

    @Test
    public void testSelenideActions() {

    }

}
