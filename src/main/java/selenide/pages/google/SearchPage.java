package selenide.pages.google;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private SelenideElement search = $(By.xpath("q78"));

    @Step("Searches for {0} text")
    public SearchPage searchFor(String searchText) {
        search.val(searchText).submit();
        return this;
    }
}
