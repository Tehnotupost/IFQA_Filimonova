package utils.metods;

import io.restassured.response.ValidatableResponse;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class GetCall {
    public static ValidatableResponse callGet(String path, Map<String, String> headers) {
            var request = given();
            if (headers != null && !headers.isEmpty()) {
                request.headers(headers);
            }
            return request
                    .when()
                    .get(path)
                    .then();
        }
}