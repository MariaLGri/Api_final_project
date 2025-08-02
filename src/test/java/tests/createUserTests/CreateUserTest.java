package tests.createUserTests;

import io.qameta.allure.*;
import models.lombok.CreateUserRequestLombokTehModel;
import models.lombok.CreateUserResponseLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;
import java.util.stream.Stream;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.createUserResponse201Spec;
import static specs.SpecsList.registrationRequestSpec;
@Epic("API Tests")
@Feature("Управление пользователями")
@Story("Создание пользователей")
@DisplayName("Параметризированные тесты создания пользователей")
class CreateUserTest extends TestBase {

    @ParameterizedTest(name = "Создание пользователя: имя={0}, должность={1}")
    @MethodSource("userDataProvider")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Гришина М.Л.")
    @Description("Проверка создания пользователя с разными валидными данными")
    void checkCreateUserTest(String name, String job) {
        // 1. Подготовка тестовых данных
        CreateUserRequestLombokTehModel requestData = new CreateUserRequestLombokTehModel();
        requestData.setName(name);
        requestData.setJob(job);

        // 2. Отправка запроса и получение ответа
        CreateUserResponseLombokTehModel response = step("Создание пользователя " + name, () ->
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
        step("Проверка данных ответа для " + name, () -> {
            assertThat(response.getName())
                    .as("Имя пользователя должно соответствовать отправленному")
                    .isEqualTo(name);

            assertThat(response.getJob())
                    .as("Должность должна соответствовать отправленной")
                    .isEqualTo(job);

            assertThat(response.getId())
                    .as("ID пользователя не должен быть пустым")
                    .isNotBlank();

            assertThat(response.getCreatedAt())
                    .as("Дата создания должна быть заполнена")
                    .isNotBlank();
        });

        // Сохраняем ID для последующих тестов
        userId = response.getId();
    }

    static Stream<Arguments> userDataProvider() {
        return Stream.of(
                Arguments.of("Mariay Grishina", "engineer"),
                Arguments.of("Иван Петров", "developer")

        );
    }
}
