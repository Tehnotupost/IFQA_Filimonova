package RandM.api.rickandmortyapi;

import io.restassured.response.ValidatableResponse;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class LocationApi extends BaseRandMApi {
    private static final String LOCATION_PATH = "/location";

    public ValidatableResponse getAllLocations() {
        return given()
                .when()
                .get(LOCATION_PATH)
                .then();
    }

    public ValidatableResponse getLocationById(int id) {
        return given()
                .when()
                .get(LOCATION_PATH + "/" + id)
                .then();
    }

    public ValidatableResponse getMultipleLocations(int[] ids) {
        String idsParam = String.join(",",
                java.util.Arrays.stream(ids)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new));

        return given()
                .when()
                .get(LOCATION_PATH + "/" + idsParam)
                .then();
    }

    public ValidatableResponse filterLocations(Map<String, Object> filters) {
        return given()
                .queryParams(filters)
                .when()
                .get(LOCATION_PATH)
                .then();
    }
}
