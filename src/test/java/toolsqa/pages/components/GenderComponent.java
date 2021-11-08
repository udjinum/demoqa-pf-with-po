package toolsqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GenderComponent {

    private final ElementsCollection label;

    private GenderComponent(SelenideElement container) {
        label = container.$$(".custom-control-label");
    }

    public static GenderComponent genderBlock(String cssSelector) {
        return new GenderComponent($(cssSelector));
    }

    public GenderComponent selectGender(String value) {
        label
                .filter(Condition.exactText(value))
                .first()
                .click();
        return this;
    }
}
