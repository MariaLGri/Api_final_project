package tests.registrationTests;

import io.qameta.allure.*;
import models.lombok.RegistrationRequestLombokTehModel;
import models.lombok.RegistrationResponseLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.registrationRequestSpec;
import static specs.SpecsList.registrationResponse200Spec;
@Severity(SeverityLevel.CRITICAL)
@Epic("API Tests")
@Feature("Регистрация пользователей")
@Story("Позитивные сценарии регистрации")
@Owner("Гришина М.Л.")
public class RegistrationTest extends TestBase {
    @Test
    @DisplayName("Успешная регистрация пользователя с валидными данными")
    void checkTokenObjectTest() {
        RegistrationRequestLombokTehModel authData = new RegistrationRequestLombokTehModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        RegistrationResponseLombokTehModel responseModel = step("Выполнение запроса на регистрацию", () ->
                given(registrationRequestSpec)
                        .body(authData)
                        .when()
                        .post("/register")
                        .then()
                        .spec(registrationResponse200Spec)
                        .extract()
                        .as(RegistrationResponseLombokTehModel.class)
        );

        step("Проверка токена в ответе", () ->
                assertThat(responseModel.getToken())
                        .as("Токен не должен быть null или пустым")
                        .isNotNull()
                        .isNotEmpty()
        );

        step("Проверка ID в ответе", () ->
                assertThat(responseModel.getId())
                        .as("ID не должен быть равен нулю")
                        .isNotZero()
        );
    }


    @ParameterizedTest(name = "Регистрация с email: {0}")
    @MethodSource("validEmailsProvider")
    @DisplayName("Параметризованная проверка валидных email")
    void testRegistrationWithDifferentEmails(String email) {
        RegistrationRequestLombokTehModel authData = new RegistrationRequestLombokTehModel();
        authData.setEmail(email);
        authData.setPassword("cityslicka");

    }

    static Stream<String> validEmailsProvider() {
        return Stream.of(
                "eve.holt@reqres.in",
                "test+123@example.com"
        );
    }
}

