package toolsqa.pages;

import com.codeborne.selenide.SelenideElement;
import toolsqa.pages.components.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final SelenideElement
            formTitle = $("h5"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit");

    public CalendarComponent calendar = new CalendarComponent();
    public ResultsTableComponent resultTable = new ResultsTableComponent();

    protected final GenderComponent genderComponent = GenderComponent.genderBlock("#genterWrapper");
    protected final HobbiesComponent hobbiesComponent = HobbiesComponent.hobbiesBlock("#hobbiesWrapper");
    protected final StateCityComponent stateCityComponent = StateCityComponent.stateCityBlock("#stateCity-wrapper");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage checkFormTitle() {
        formTitle.shouldHave(exactText("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.val(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.val(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.val(value);
        return this;
    }

    public RegistrationPage selectGender(String value) {
        genderComponent.selectGender(value);
        return this;
    }

    public RegistrationPage typeMobileNumber(String value) {
        mobileNumberInput.val(value);
        return this;
    }

    public RegistrationPage typeSubjects(String value) {
        subjectsInput
                .val(value)
                .pressEnter();
        return this;
    }

    public RegistrationPage addHobbies(String value) {
        hobbiesComponent.selectHobby(value);
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath("img/" + value);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.val(value);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city) {
        stateCityComponent
                .selectState(state)
                .selectCity(city);
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }


}
