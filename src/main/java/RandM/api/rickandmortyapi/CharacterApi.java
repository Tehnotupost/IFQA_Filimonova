package RandM.api.rickandmortyapi;

import io.restassured.response.ValidatableResponse;
import utils.CustomProperties;
import static utils.metods.GetCall.callGet;

public class CharacterApi extends BaseRandMApi{
    public ValidatableResponse getCharacterInfo(int characterId) {
        String path = CustomProperties.getProps()
                .getProperty("CHARACTER_PATH") + "/" + characterId;
        return callGet(path, null);
    }
}
