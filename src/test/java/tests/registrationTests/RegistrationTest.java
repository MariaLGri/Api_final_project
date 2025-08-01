package tests.registrationTests;

import models.lombok.RegistrationRequestLombokTehModel;
import models.lombok.RegistrationResponseLombokTehModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecsList.registrationRequestSpec;
import static specs.SpecsList.registrationResponse200Spec;

public class RegistrationTest extends TestBase {
    @Test
    @DisplayName("Проверка запроса на регистрацию")
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
}
