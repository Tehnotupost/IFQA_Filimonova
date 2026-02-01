package RandM.api;

import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import RandM.api.rickandmortyapi.CharacterApi;
import RandM.api.rickandmortyapi.EpisodeApi;
import io.qameta.allure.Step;
import lombok.Data;

@Data

public class TestUtils {
    private static final CharacterApi characterApi = new CharacterApi();
    private static final EpisodeApi episodeApi = new EpisodeApi();

    @Step("Получаем Id из URL")
    public static int extractIdFromUrl(String url) {
        return Integer.parseInt(url.substring(url.lastIndexOf("/") + 1));
    }

    @Step("Получаем информацию о персонаже с Id {0}")
    public static CharacterConst getCharacter(int id) {
        return characterApi.getCharacterInfo(id)
                .extract()
                .as(CharacterConst.class);
    }

    @Step("Получаем информацию об эпизоде {0}")
    public static EpisodeConst getEpisode(int id) {
        return episodeApi.getEpisodeById(id)
                .extract()
                .as(EpisodeConst.class);
    }
}
