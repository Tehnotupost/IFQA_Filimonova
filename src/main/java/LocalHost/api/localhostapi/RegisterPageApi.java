package LocalHost.api.localhostapi;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RegisterPageApi extends BaseLocalApi {
    private static final String REGISTER_PATH = "/api/register";

    public ValidatableResponse registrationUser(String credentials) {
        return given()
                .when()
                .body(credentials)
                .post(REGISTER_PATH)
                .then();
    }
}
