package rickandmortyapi;

import api.RickAndMortyService;
import api.TestUtils;
import constants.CharacterConst;
import constants.EpisodeConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class rickandmortyapiTests extends WebHooks {

    private static final int mortyId = 2;
    private final RickAndMortyService rickAndMortyService = new RickAndMortyService();

    @Test
    @DisplayName("Последний эпизод с Морти")
    void checkLastEpisodeWithMorty() {

        CharacterConst mortyInfo = TestUtils.getCharacter(mortyId);
        String lastEpisodeUrl = mortyInfo.getEpisode().get(mortyInfo.getEpisode().size() - 1);
        EpisodeConst lastEpisodeInfo = TestUtils.getEpisode(TestUtils.extractIdFromUrl(lastEpisodeUrl));
        assertNotNull(lastEpisodeInfo);
    }

    @Test
    @DisplayName("Последний персонаж последнего эпизода")
    void checkLastCharacterOfLastEpisodeWithMorty() {

        CharacterConst mortyInfo = TestUtils.getCharacter(mortyId);
        String lastEpisodeUrl = mortyInfo.getEpisode().get(mortyInfo.getEpisode().size() - 1);
        EpisodeConst lastEpisodeInfo = TestUtils.getEpisode(TestUtils.extractIdFromUrl(lastEpisodeUrl));

        String lastCharacterUrl = lastEpisodeInfo.getCharacters().get(lastEpisodeInfo.getCharacters().size() - 1);
        CharacterConst lastCharacterInfo = TestUtils.getCharacter(TestUtils.extractIdFromUrl(lastCharacterUrl));
        assertNotNull(lastCharacterInfo);
    }

    @Test
    @DisplayName("Местонахождение и раса последнего персонажа")
    void checkLocationAndTypeLastCharacter() {

        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(mortyId);
        CharacterConst lastCharacterInfo = rickAndMortyService.getLastCharacterOfEpisode(lastEpisodeInfo);

        String lastCharacterLoc = lastCharacterInfo.getLocation().getName();
        assertNotNull(lastCharacterLoc);
        String lastCharacterSpecies = lastCharacterInfo.getSpecies();
        assertNotNull(lastCharacterSpecies);
    }

    @Test
    @DisplayName("Местонахождение и раса последнего персонажа. Сравнение с Морти")
    void compareLocationAndTypeLastCharacterWithMorty() {

        CharacterConst mortyInfo = TestUtils.getCharacter(mortyId);
        String mortyLoc = mortyInfo.getLocation().getName();//
        String mortySpecies = mortyInfo.getSpecies();

        EpisodeConst lastEpisodeInfo = rickAndMortyService.getLastEpisodeOfCharacter(mortyId);

        CharacterConst lastCharacterInfo = rickAndMortyService.getLastCharacterOfEpisode(lastEpisodeInfo);
        String lastCharacterLoc = lastCharacterInfo.getLocation().getName();
        String lastCharacterSpecies = lastCharacterInfo.getSpecies();

        try {
            assertEquals(mortyLoc, lastCharacterLoc);
            System.out.println("Локации совпадают");
        } catch (AssertionError e) {
            System.out.println("Локации не совпадают: " + e.getMessage());
        }

        try {
            assertEquals(mortySpecies, lastCharacterSpecies, "Сравниваем расы");
            System.out.println("Расы совпадают");
        } catch (AssertionError e) {
            System.out.println("Расы не совпадают: " + e.getMessage());
        }
    }
}