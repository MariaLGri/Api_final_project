package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfig;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.lesson_16.helpers.TestDataHelper;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    TestDataHelper testDataHelper = new TestDataHelper();
    private static final WebConfig webConfig = ConfigReader.Instance.read();
   public static String userId;

    @BeforeAll
    static void installConfiguration() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        ProjectConfig projectConfiguration = new ProjectConfig(webConfig);
        projectConfiguration.webConfig();
        projectConfiguration.apiConfig();
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

    }

    @BeforeEach
    void setUp() {
        if (userId == null) {
            userId = testDataHelper.createDefaultTestUser();
        }
    }

    @AfterEach
    void shutDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        // Добавляем логи и видео только для удалённого запуска
        if (Configuration.remote != null) {
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
        closeWebDriver();
    }

}

