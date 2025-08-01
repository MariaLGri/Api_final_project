package tests.createUserTests;

import models.lombok.CreateUserRequestLombokTehModel;
import models.lombok.CreateUserResponseLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.createUserResponse201Spec;
import static specs.SpecsList.registrationRequestSpec;

public class CreateUserTest extends TestBase {
    @Test
    @DisplayName("Проверка запроса POST на создание пользователя")
    void checkCreateUserTest() {

        // 1. Подготовка тестовых данных
        CreateUserRequestLombokTehModel requestData = new CreateUserRequestLombokTehModel();
        requestData.setName("Mariay Grishina");
        requestData.setJob("engineer");

        // 2. Отправка запроса и получение ответа
        CreateUserResponseLombokTehModel response = step("Создание пользователя", () ->
                given(registrationRequestSpec)
                        .body(requestData)
                        .when()
                        .post("/users")
                        .then()
                        .spec(createUserResponse201Spec)
                        .extract()
                        .as(CreateUserResponseLombokTehModel.class)
        );

        // 3. Проверки ответа
        step("Проверка данных ответа", () -> {
            assertThat(response.getName()).isEqualTo("Mariay Grishina");
            assertThat(response.getJob()).isEqualTo("engineer");
            assertThat(response.getId()).isNotBlank();
            assertThat(response.getCreatedAt()).isNotBlank();
        });

        // Сохраняем ID для последующих тестов
        userId = response.getId();

    }
}
