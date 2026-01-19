package edujiraifellow.steps;

import edujiraifellow.pages.OpenTaskTestPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckQualityTaskSteps {
    private final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();
    private int diff;

    @Дано("пользователь применяет фильтр Все задачи")
    public void applyFilter() {
        openTaskTestPage.applyFilterAllProjects();
    }

    @Тогда("Фильтр Все задачи применился")
    public void filterChanged() {
        assertTrue(openTaskTestPage.waitCounterValueChange());
    }

    @Когда("пользователь создает быструю задачу")
    public void createFastTask() {
        diff = openTaskTestPage.changeCounter();
    }

    @Тогда("счетчик задач увеличился на {int}")
    public void counterIncreased(int expected) {
        assertEquals(expected, diff);
    }

}
