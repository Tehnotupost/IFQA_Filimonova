package rickandmortyapi.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import rickandmortyapi.context.ContextStory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckLocationAndTypeLastCharacterSteps {
    private ContextStory context;

    public CheckLocationAndTypeLastCharacterSteps(ContextStory context) {
        this.context = context;
    }

    @Когда("определяем местонахождение последнего персонажа")
    public void checkLocationLastCharacter() {
        String lastCharacterLoc = context.getCharacterConst().getLocation().getName();
        context.setCharacterLocation(lastCharacterLoc);
        assertNotNull(lastCharacterLoc);
    }

    @Когда("определяем расу последнего персонажа")
    public void checkTypeLastCharacter() {
        String lastCharacterSpecies = context.getCharacterConst().getSpecies();
        context.setCharacterSpecies(lastCharacterSpecies);
        assertNotNull(lastCharacterSpecies);
    }

    @Тогда("местонахождение персонажа найдено")
    public void trueLocationLastCharacter() {
        String lastCharacterLocation = context.getCharacterLocation();
        assertNotNull(lastCharacterLocation);
    }

    @Тогда("расса персонажа найдена")
    public void trueTypeLastCharacter() {
        String lastCharacterSpecies = context.getCharacterSpecies();
        assertNotNull(lastCharacterSpecies);
    }
}