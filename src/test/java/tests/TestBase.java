package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigReader;
import config.ProjectConfig;
import config.WebConfig;
import helpers.TestDataHelper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    private static final WebConfig webConfig = ConfigReader.Instance.read();
    public static String userId;

    @BeforeAll
    static void installConfiguration() {
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

    @AfterEach
    void cleanup() {
        RestAssured.reset();
    }

}