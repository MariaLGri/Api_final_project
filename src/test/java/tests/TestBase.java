package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfig;
import config.WebConfig;
import helpers.TestDataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
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
            userId = TestDataHelper.createDefaultTestUser();
        }
    }



}