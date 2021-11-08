package toolsqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import toolsqa.pages.RegistrationPage;

public class TestBase {

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.startMaximized = true;
    }

    RegistrationPage registrationPage = new RegistrationPage();
}
