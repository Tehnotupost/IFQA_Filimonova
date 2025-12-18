package LocalHost.api.localhostapi;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class LoginPageApi extends BaseLocalApi {
    private static final String LOGIN_PATH = "/api/login";

    public ValidatableResponse loginUser(String credentials) {

        return given()
                .when()
                .body(credentials)
                .post(LOGIN_PATH)
                .then();
    }
}