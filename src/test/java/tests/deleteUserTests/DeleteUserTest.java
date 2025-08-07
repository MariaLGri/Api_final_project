package tests.deleteUserTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static specs.SpecsList.deleteUserResponse204Spec;
import static specs.SpecsList.registrationRequestSpec;
@Epic("API Tests")
@Feature("Работа с пользователями")
@DisplayName("Удаление пользователя")
@Owner("Гришина М.Л.")
public class DeleteUserTest extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка запроса на удаление пользователя")
    void checkDeleteUserTest() {
        step("Удаление пользователя", () ->
                given(registrationRequestSpec)
                        .pathParam("userId", userId)
                        .when()
                        .delete("/users/{userId}")
                        .then()
                        .spec(deleteUserResponse204Spec)
                        .body(equalTo(""))
        );

        step("Проверка что пользователь удален", () -> {
            given(registrationRequestSpec)
                    .when()
                    .get("/users/" + userId)
                    .then()
                    .statusCode(404);
        });
    }
}
