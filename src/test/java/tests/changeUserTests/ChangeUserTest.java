package tests.changeUserTests;

import io.qameta.allure.*;
import models.lombok.ChangeUserResponseLombokTehModel;
import models.lombok.ChangeUserRequestLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.registrationRequestSpec;
import static specs.SpecsList.registrationResponse200Spec;
@Epic("API Tests")
@Feature("Управление пользователями")
@Story("Редактирование пользователей")
@DisplayName("Тесты на редактирование пользователей")
public class ChangeUserTest extends TestBase {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Гришина М.Л.")
    @DisplayName("Проверка запроса на редактирование пользователя")
    void checkUpdateUserTest() {
        ChangeUserRequestLombokTehModel upData = new ChangeUserRequestLombokTehModel();
        upData.setName("morpheusТЕСТ");
        upData.setJob("zion residentТЕСТ");
        ChangeUserResponseLombokTehModel response = step("Отправка PUT запроса", () ->
                given(registrationRequestSpec)
                        .body(upData)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(registrationResponse200Spec)
                        .extract()
                        .as(ChangeUserResponseLombokTehModel.class)
        );

        // Проверяем ответ
        step("Проверка имени в ответе", () ->
                assertThat(response.getName()).isEqualTo("morpheusТЕСТ")
        );

        step("Проверка должности в ответе", () ->
                assertThat(response.getJob()).isEqualTo("zion residentТЕСТ")
        );
    }

    @Test
    @DisplayName("Проверка запроса Patch на редактирование пользователя")
    void checkPatchUpdateUserTest() {
        ChangeUserRequestLombokTehModel upData = new ChangeUserRequestLombokTehModel();
        upData.setName("morpheusТЕСТ22изменен");
        upData.setJob("zion residentТЕСТ22изменен");
        ChangeUserResponseLombokTehModel response = step("Отправка Patch запроса", () ->
                given(registrationRequestSpec)
                        .body(upData)
                        .when()
                        .patch("/users/2")
                        .then()
                        .spec(registrationResponse200Spec)
                        .extract()
                        .as(ChangeUserResponseLombokTehModel.class)
        );

        // Проверяем ответ
        step("Проверка имени в ответе", () ->
                assertThat(response.getName()).isEqualTo("morpheusТЕСТ22изменен")
        );

        step("Проверка должности в ответе", () ->
                assertThat(response.getJob()).isEqualTo("zion residentТЕСТ22изменен")
        );
    }
}
