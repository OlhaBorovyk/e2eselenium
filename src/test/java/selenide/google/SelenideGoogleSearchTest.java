package selenide.google;

import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class SelenideGoogleSearchTest extends SelenideTestBase {
    private String searchText = "selenide";
    private SearchPage searchPage = new SearchPage();
    private SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    public void searchTest() {
        open("https://www.google.com.ua/");
        searchPage.searchFor(searchText);
        searchResultPage.searchResults().first()
                .should(text("Selenide: лаконичные и стабильные UI тесты на Java"));
    }
}
