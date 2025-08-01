package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;


public class SpecsList {
    public static RequestSpecification registrationRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(System.getProperty("baseURI", "https://reqres.in"))
            .basePath(System.getProperty("basePath", "/api"))
            .header("x-api-key", "reqres-free-v1")
            .contentType(JSON)
            .log().uri();

    public static ResponseSpecification registrationResponse200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();


    public static ResponseSpecification createUserResponse201Spec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();
    public static ResponseSpecification deleteUserResponse204Spec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();

}
