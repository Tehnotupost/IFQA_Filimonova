package rickandmortyapi.steps;

import RandM.api.RickAndMortyService;
import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import rickandmortyapi.context.ContextStory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckLastCharacterOfLastEpisodeSteps {
    private ContextStory context;
    private final RickAndMortyService rickAndMortyService = new RickAndMortyService();

    public CheckLastCharacterOfLastEpisodeSteps(ContextStory context) {
        this.context = context;
    }

    @Когда("ищем последнего персонажа в эпизоде")
    public void checkLastCharacterOfLastEpisodeWithMorty() {
        EpisodeConst lastEpisodeInfo = context.getEpisodeConst();
        CharacterConst lastCharacterInfo = rickAndMortyService.getLastCharacterOfEpisode(lastEpisodeInfo);
        context.setCharacterConst(lastCharacterInfo);
        assertNotNull(lastCharacterInfo);
    }

    @Тогда("персонаж есть в эпизоде")
    public void checkLastEpisodeWithMorty() {
        CharacterConst characterInfo = context.getCharacterConst();
        EpisodeConst episodeInfo = context.getEpisodeConst();
        String episodeId = String.valueOf(episodeInfo.getId());
        Boolean isPresent = characterInfo.getEpisode().stream()
                .anyMatch(url -> url.endsWith("/" + episodeId));
        assertTrue(isPresent, "Эпизод не найден");
    }
}
