package utils.metods;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class PostCall {
    public static ValidatableResponse callPost(String path, String credentials) {
        var request = given();
        return request
                .when()
                .body(credentials)
                .post(path)
                .then();
    }
}
