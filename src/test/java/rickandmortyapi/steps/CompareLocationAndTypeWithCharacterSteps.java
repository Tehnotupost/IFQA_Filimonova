package rickandmortyapi.steps;

import RandM.api.TestUtils;
import RandM.api.constants.CharacterConst;
import io.cucumber.java.ru.Тогда;
import rickandmortyapi.context.ContextStory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static rickandmortyapi.hooks.WebHooks.config;

public class CompareLocationAndTypeWithCharacterSteps {
    private ContextStory context;

    public CompareLocationAndTypeWithCharacterSteps(ContextStory context) {
        this.context = context;
    }

    @Тогда("местонахождение не совпадает с {string}")
    public void compareLocationWithMorty(String nameId) {
        int characterId = Integer.parseInt(config.getProperty(nameId + ".id"));
        CharacterConst mortyInfo = TestUtils.getCharacter(characterId);
        String mortyLoc = mortyInfo.getLocation().getName();
        CharacterConst lastCharacterInfo = context.getCharacterConst();
        String lastCharacterLoc = lastCharacterInfo.getLocation().getName();
        assertNotEquals(mortyLoc, lastCharacterLoc);
    }

    @Тогда("раса совпадает с {string}")
    public void compareTypeWithMorty(String nameId) {
        int characterId = Integer.parseInt(config.getProperty(nameId + ".id"));
        CharacterConst mortyInfo = TestUtils.getCharacter(characterId);
        String mortySpecies = mortyInfo.getSpecies();
        CharacterConst lastCharacterInfo = context.getCharacterConst();
        String lastCharacterSpecies = lastCharacterInfo.getSpecies();
        assertEquals(mortySpecies, lastCharacterSpecies);
    }
}