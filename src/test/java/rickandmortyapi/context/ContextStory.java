package rickandmortyapi.context;

import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import RandM.api.constants.LocationConst;
import RandM.api.rickandmortyapi.CharacterApi;
import RandM.api.rickandmortyapi.EpisodeApi;
import io.restassured.response.ValidatableResponse;
import lombok.Data;

@Data
public class ContextStory {
    private ValidatableResponse response;
    private CharacterConst characterConst;
    private EpisodeConst episodeConst;
    private LocationConst locationConst;
    private CharacterApi characterApi;
    private EpisodeApi episodeApi;
    private String characterLocation;
    private String characterSpecies;
}
