package RandM.api.rickandmortyapi;

import io.restassured.response.ValidatableResponse;
import utils.CustomProperties;
import static utils.metods.GetCall.callGet;

public class EpisodeApi extends BaseRandMApi {
    public ValidatableResponse getEpisodeById(int id) {
    String path = CustomProperties.getProps()
            .getProperty("EPISODE_PATH") + "/" + id;
        return callGet(path, null);
    }
}
