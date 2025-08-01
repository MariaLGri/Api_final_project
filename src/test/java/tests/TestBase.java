package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.lesson_16.helpers.TestDataHelper;


public class TestBase {
    TestDataHelper testDataHelper = new TestDataHelper();
   public static String userId;

    @BeforeAll
    static void installConfiguration() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }

    @BeforeEach
    void setUp() {
        if (userId == null) {
            userId = testDataHelper.createDefaultTestUser();
        }
    }

}

