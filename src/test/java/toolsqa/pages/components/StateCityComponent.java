package toolsqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {

    private final SelenideElement stateField;
    private final SelenideElement cityField;
    private final ElementsCollection stateList;
    private final ElementsCollection cityList;

    private StateCityComponent(SelenideElement container) {
        stateField = container.$("#state");
        cityField = container.$("#city");
        stateList = container.$$("[id^=react-select-3-option-]");
        cityList = container.$$("[id^=react-select-4-option-]");
    }

    public static StateCityComponent stateCityBlock(String cssSelector) {
        return new StateCityComponent($(cssSelector));
    }

    public StateCityComponent selectState(String value) {
        stateField
                .click();
        stateList
                .filter(Condition.exactText(value))
                .first()
                .click();
        return this;
    }

    public StateCityComponent selectCity(String value) {
        cityField
                .click();
        cityList
                .filter(Condition.exactText(value))
                .first()
                .click();
        return this;
    }
}
