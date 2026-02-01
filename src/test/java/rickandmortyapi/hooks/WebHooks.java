package rickandmortyapi.hooks;

import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import RandM.api.constants.LocationConst;
import RandM.api.rickandmortyapi.CharacterApi;
import RandM.api.rickandmortyapi.EpisodeApi;
import io.cucumber.java.Before;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import rickandmortyapi.context.ContextStory;
import utils.CustomProperties;

public class WebHooks {
    private ContextStory context;
    public static CustomProperties config;

    public WebHooks(ContextStory context) {
        this.context = context;
    }

    @Before
    public void setup() {
        config = CustomProperties.getInstance();
        RestAssured.filters(new AllureRestAssured());
        context.setCharacterConst(new CharacterConst());
        context.setEpisodeConst(new EpisodeConst());
        context.setLocationConst(new LocationConst());
        context.setCharacterApi(new CharacterApi());
        context.setEpisodeApi(new EpisodeApi());
    }
}
