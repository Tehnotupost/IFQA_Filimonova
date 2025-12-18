package LocalHost.api.localhostapi;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LogoutPageApi extends BaseLocalApi {
    private static final String LOGOUT_PATH = "/api/logout";

    public ValidatableResponse logoutUser(String authToken) {
        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalStateException("Токен не найден");
        }
       return given()
                .header("Authorization", authToken)
                .log().headers()
                .when()
                .get(LOGOUT_PATH)
                .then();
    }
}
