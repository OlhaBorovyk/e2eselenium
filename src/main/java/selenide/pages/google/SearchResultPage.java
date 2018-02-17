package selenide.pages.google;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private ElementsCollection results = $$(By.xpath("//*[@id=\"rso\"]/div/div"));

    public ElementsCollection searchResults() {
        return results;
    }
}
