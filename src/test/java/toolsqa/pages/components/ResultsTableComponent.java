package toolsqa.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ResultsTableComponent {

    private final SelenideElement title = $(".modal-title");
    private final ElementsCollection cells = $$x(".//td");
    private final SelenideElement closeButton = $("#closeLargeModal");

    public ResultsTableComponent titleTableShouldHave(String value) {
        title.shouldHave(exactText(value));
        return this;
    }

    public ResultsTableComponent checkResultsValue(String key, String value) {
        cells.findBy(text(key)).parent().shouldHave(text(value));
        return this;
    }

    public ResultsTableComponent closeResultsTable() {
        closeButton.click();
        return this;
    }
}
