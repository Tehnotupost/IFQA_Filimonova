package rickandmortyapi;

import api.rickandmortyapi.CharacterApi;
import api.rickandmortyapi.EpisodeApi;
import constants.CharacterConst;
import constants.EpisodeConst;
import constants.LocationConst;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {

    @BeforeAll
    static void setup() {
        CharacterConst characterConst = new CharacterConst();
        EpisodeConst episodeConst = new EpisodeConst();
        LocationConst locationConst = new LocationConst();
    }
    @BeforeEach
    void continuosUp() {
        CharacterApi characterApi = new CharacterApi();
        EpisodeApi episodeApi = new EpisodeApi();
    }
}
