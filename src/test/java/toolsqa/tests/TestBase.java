package toolsqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import toolsqa.config.CredentialsConfig;
import toolsqa.helpers.Attach;
import toolsqa.pages.RegistrationPage;

import static java.lang.String.format;

public class TestBase {

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = format("https://%s:%s@%s",
                credentials.login(),
                credentials.password(),
                System.getProperty("selenoidUrl"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    RegistrationPage registrationPage = new RegistrationPage();
}