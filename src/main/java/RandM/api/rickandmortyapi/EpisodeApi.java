package RandM.api.rickandmortyapi;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static utils.metods.GetCall.callGet;

public class EpisodeApi extends BaseRandMApi {
    @Step("Отправляем GET запрос с id эпизода")
    public ValidatableResponse getEpisodeById(int id) {
        String path = config.episodePath() + "/" + id;
        return callGet(path, null);
    }
}
