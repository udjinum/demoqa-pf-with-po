package toolsqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {

    private final ElementsCollection label;

    private HobbiesComponent(SelenideElement container) {
        label = container.$$(".custom-control-label");
    }

    public static HobbiesComponent hobbiesBlock(String cssSelector) {
        return new HobbiesComponent($(cssSelector));
    }

    public HobbiesComponent selectHobby(String value) {
        label
                .filter(Condition.exactText(value))
                .first()
                .click();
        return this;
    }
}
