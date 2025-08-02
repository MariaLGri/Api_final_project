package tests.listUserTests;

import io.qameta.allure.*;
import models.lombok.ListUserResponseLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.registrationRequestSpec;
import static specs.SpecsList.registrationResponse200Spec;
@Epic("API Tests")
@Feature("Работа с пользователями")
@DisplayName("Получение списка пользователей")
public class ListUserTest extends TestBase {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("Гришина М.Л.")
    @DisplayName("Проверка запроса на получение списка пользователей")
    void checkListUsersTest() {
        ListUserResponseLombokTehModel response = step("Выполнение запроса списка пользователей", () ->
                given(registrationRequestSpec)
                        .when()
                        .queryParam("page", "2")
                        .get("/users")
                        .then()
                        .spec(registrationResponse200Spec)
                        .extract()
                        .as(ListUserResponseLombokTehModel.class)
        );

        step("Проверка per_page в ответе", () ->
                assertThat(response.getPerPage())
                        .as("Параметр per_page должен быть равен 6")
                        .isEqualTo(6)
        );

        step("Проверка текста в support.text", () ->
                assertThat(response.getSupport().getText())
                        .as("Текст поддержки должен содержать 'Content Caddy'")
                        .contains("Content Caddy")
        );
    }

}
