package RandM.api;

import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import io.qameta.allure.Step;

public class RickAndMortyService {

    @Step("Получаем последний эпизод персонажа")
    public EpisodeConst getLastEpisodeOfCharacter(int characterId) {
        CharacterConst character = TestUtils.getCharacter(characterId);
        String lastEpisodeUrl = character.getEpisode().get(character.getEpisode().size() - 1);
        int lastEpisodeId = TestUtils.extractIdFromUrl(lastEpisodeUrl);
        return TestUtils.getEpisode(lastEpisodeId);
    }

    @Step("Получаем последний персонаж эпизода")
    public CharacterConst getLastCharacterOfEpisode(EpisodeConst episode) {
        String lastCharacterUrl = episode.getCharacters().get(episode.getCharacters().size() - 1);
        int lastCharacterId = TestUtils.extractIdFromUrl(lastCharacterUrl);
        return TestUtils.getCharacter(lastCharacterId);
    }
}

