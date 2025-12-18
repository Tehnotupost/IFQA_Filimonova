package RandM.api.rickandmortyapi;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class EpisodeApi extends BaseRandMApi {
    private static final String EPISODE_PATH = "/episode";

    public ValidatableResponse getAllEpisodes() {
        return given()
                .when()
                .get(EPISODE_PATH)
                .then();
    }

    public ValidatableResponse getEpisodeById(int id) {
        return given()
                .when()
                .get( EPISODE_PATH + "/" + id)
                .then();
    }

    public ValidatableResponse getMultipleEpisodes(int[] ids) {
        String idsParam = String.join(",",
                java.util.Arrays.stream(ids)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new));

        return given()
                .when()
                .get(EPISODE_PATH + "/" + idsParam)
                .then();
    }

}
