package tests.changeUserTests;

import models.lombok.ChangeUserResponseLombokTehModel;
import models.lombok.СhangeUserRequestLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.registrationRequestSpec;
import static specs.SpecsList.registrationResponse200Spec;

public class СhangeUserTest extends TestBase {
    @Test
    @DisplayName("Проверка запроса PUT на редактирование пользователя")
    void checkUpdateUserTest() {
        СhangeUserRequestLombokTehModel upData = new СhangeUserRequestLombokTehModel();
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
        СhangeUserRequestLombokTehModel upData = new СhangeUserRequestLombokTehModel();
        upData.setName("morpheusТЕСТ22изменен");
        upData.setJob("zion residentТЕСТ22изменен");
        ChangeUserResponseLombokTehModel response = step("Отправка Patch запроса", () ->
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
                assertThat(response.getName()).isEqualTo("morpheusТЕСТ22изменен")
        );

        step("Проверка должности в ответе", () ->
                assertThat(response.getJob()).isEqualTo("zion residentТЕСТ22изменен")
        );
    }
}
