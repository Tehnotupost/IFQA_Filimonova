package RandM.api.rickandmortyapi;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static utils.metods.GetCall.callGet;

public class CharacterApi extends BaseRandMApi {

    @Step("Отправляем GET запрос с id персонажа")
    public ValidatableResponse getCharacterInfo(int characterId) {
        String path = config.characterPath() + "/" + characterId;
        return callGet(path, null);
    }
}
