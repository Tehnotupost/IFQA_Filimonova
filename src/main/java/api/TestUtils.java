package api;

import api.rickandmortyapi.CharacterApi;
import api.rickandmortyapi.EpisodeApi;
import constants.CharacterConst;
import constants.EpisodeConst;

import lombok.Data;
@Data

public class TestUtils {

    private static final CharacterApi characterApi = new CharacterApi();
    private static final EpisodeApi episodeApi = new EpisodeApi();

    public static int extractIdFromUrl(String url) {
        return Integer.parseInt(url.substring(url.lastIndexOf("/") + 1));
    }

    public static CharacterConst getCharacter(int id) {
        return characterApi.getCharacterInfo(id)
                .extract()
                .as(CharacterConst.class);
    }

    public static EpisodeConst getEpisode(int id) {
        return episodeApi.getEpisodeById(id)
                .extract()
                .as(EpisodeConst.class);
    }
}
