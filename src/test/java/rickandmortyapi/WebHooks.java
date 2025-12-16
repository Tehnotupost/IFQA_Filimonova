package rickandmortyapi;

import constants.CharacterConst;
import constants.EpisodeConst;
import constants.LocationConst;
import org.junit.jupiter.api.BeforeAll;

public class WebHooks {

    @BeforeAll
    static void setup() {
        CharacterConst characterConst = new CharacterConst();
        EpisodeConst episodeConst = new EpisodeConst();
        LocationConst locationConst = new LocationConst();
    }
}
