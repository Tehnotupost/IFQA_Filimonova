package api.rickandmortyapi;

import io.restassured.response.ValidatableResponse;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class CharacterApi extends BaseRandMApi{
    private static final String CHARACTER_PATH = "/character";

    public ValidatableResponse getAllCharacters() {
        return given()
                .when()
                .get(CHARACTER_PATH)
                .then();
    }

    public ValidatableResponse getCharacterInfo(int characterId) {
        return given()
                .when()
                .get(CHARACTER_PATH + "/" + characterId)
                .then();
    }

    public ValidatableResponse getMultipleCharacters(int[] ids) {
        String idsParam = String.join(",",
                java.util.Arrays.stream(ids)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new));

        return given()
                .when()
                .get(CHARACTER_PATH + "/" + idsParam)
                .then();
    }

    public ValidatableResponse filterCharacters(Map<String, Object> filters) {
        return given()
                .queryParams(filters)
                .when()
                .get(CHARACTER_PATH)
                .then();
    }
}
