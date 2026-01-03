package rickandmortyapi;

import RandM.api.rickandmortyapi.CharacterApi;
import RandM.api.rickandmortyapi.EpisodeApi;
import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import RandM.api.constants.LocationConst;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.CustomProperties;

public class WebHooks {

    @BeforeAll
    static void setup() {
        CustomProperties.loadProperties();
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
