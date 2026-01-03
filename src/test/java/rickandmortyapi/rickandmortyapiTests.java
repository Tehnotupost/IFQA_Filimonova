package rickandmortyapi;

import RandM.api.RickAndMortyService;
import RandM.api.TestUtils;
import RandM.api.constants.CharacterConst;
import RandM.api.constants.EpisodeConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.CustomProperties;
import static org.junit.jupiter.api.Assertions.*;

public class rickandmortyapiTests extends WebHooks {
    private final RickAndMortyService rickAndMortyService = new RickAndMortyService();

    @Test
    @DisplayName("Последний эпизод с Морти")
    void checkLastEpisodeWithMorty() {
        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(Integer.parseInt(CustomProperties.getProps()
                .getProperty("mortyId")));
        assertNotNull(lastEpisodeInfo);
    }

    @Test
    @DisplayName("Последний персонаж последнего эпизода")
    void checkLastCharacterOfLastEpisodeWithMorty() {
        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(Integer.parseInt(CustomProperties.getProps()
                .getProperty("mortyId")));
        CharacterConst lastCharacterInfo = rickAndMortyService.getLastCharacterOfEpisode(lastEpisodeInfo);
        assertNotNull(lastCharacterInfo);
    }

    @Test
    @DisplayName("Местонахождение и раса последнего персонажа")
    void checkLocationAndTypeLastCharacter() {
        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(Integer.parseInt(CustomProperties.getProps()
                .getProperty("mortyId")));
        CharacterConst lastCharacterInfo = rickAndMortyService.getLastCharacterOfEpisode(lastEpisodeInfo);
        String lastCharacterLoc = lastCharacterInfo.getLocation().getName();
        assertNotNull(lastCharacterLoc);
        String lastCharacterSpecies = lastCharacterInfo.getSpecies();
        assertNotNull(lastCharacterSpecies);
    }

    @Test
    @DisplayName("Местонахождение и раса последнего персонажа. Сравнение с Морти")
    void compareLocationAndTypeLastCharacterWithMorty() {
        CharacterConst mortyInfo = TestUtils.getCharacter(Integer.parseInt(CustomProperties.getProps()
                .getProperty("mortyId")));
        String mortyLoc = mortyInfo.getLocation().getName();
        String mortySpecies = mortyInfo.getSpecies();
        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(Integer.parseInt(CustomProperties.getProps()
                .getProperty("mortyId")));
        CharacterConst lastCharacterInfo = rickAndMortyService.getLastCharacterOfEpisode(lastEpisodeInfo);
        String lastCharacterLoc = lastCharacterInfo.getLocation().getName();
        String lastCharacterSpecies = lastCharacterInfo.getSpecies();
        assertEquals(mortySpecies,lastCharacterSpecies);
        assertNotEquals(mortyLoc,lastCharacterLoc);
    }
}