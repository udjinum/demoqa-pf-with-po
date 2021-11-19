package toolsqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class PracticeFormTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.bothify("????##@vest.ru"),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().streetAddress();

    private static final String
            STATE = "NCR",
            CITY = "Delhi";

    @Test
    @DisplayName("Checking submit registration form")
    public void submitRegistrationFormTest() {
        registrationPage
                .openPage()
                .checkFormTitle()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender("Female")
                .typeMobileNumber(mobileNumber);

        registrationPage.calendar
                .setDate("10", "July", "1950");

        registrationPage
                .typeSubjects("Maths")
                .addHobbies("Music")
                .uploadPicture("ava.jpg")
                .typeCurrentAddress(currentAddress)
                .selectStateAndCity(STATE, CITY)
                .clickSubmitButton();

        registrationPage.resultTable
                .titleTableShouldHave("Thanks for submitting the form")
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", mobileNumber)
                .checkResultsValue("Date of Birth", "10 July,1950")
                .checkResultsValue("Subjects", "Math")
                .checkResultsValue("Hobbies", "Music")
                .checkResultsValue("Picture", "ava.jpg")
                .checkResultsValue("Address", currentAddress)
                .checkResultsValue("State and City", STATE + " " + CITY)
                .closeResultsTable();

        registrationPage
                .checkFormTitle();
    }
}
