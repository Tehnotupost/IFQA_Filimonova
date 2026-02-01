package rickandmortyapi.steps;

import RandM.api.RickAndMortyService;
import RandM.api.constants.EpisodeConst;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import rickandmortyapi.context.ContextStory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static rickandmortyapi.hooks.WebHooks.config;

public class CheckLastEpisodeWithCharacterSteps {
    private ContextStory context;
    private final RickAndMortyService rickAndMortyService = new RickAndMortyService();

    public CheckLastEpisodeWithCharacterSteps(ContextStory context) {
        this.context = context;
    }

    @Когда("ищем последний эпизод персонажа {string}")
    public void checkLastEpisodeWithCharacter(String nameId) {
        int characterId = Integer.parseInt(config.getProperty(nameId + ".id"));
        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(characterId);
        context.setEpisodeConst(lastEpisodeInfo);
        assertNotNull(lastEpisodeInfo);
    }

    @Тогда("эпизод содержит персонажа {string}")
    public void checkLastEpisodeContainsCharacter(String nameId) {
        EpisodeConst episodeInfo = context.getEpisodeConst();
        String characterId = config.getProperty(nameId + ".id");
        Boolean isPresent = episodeInfo.getCharacters().stream()
                .anyMatch(url -> url.endsWith("/" + characterId));
        assertTrue(isPresent, "Персонаж не найден");
    }
}
