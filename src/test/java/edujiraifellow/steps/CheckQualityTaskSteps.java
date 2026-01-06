package edujiraifellow.steps;

import edujiraifellow.motion.ChangeCounter;
import edujiraifellow.motion.CreateTask;
import edujiraifellow.pages.OpenTaskTestPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckQualityTaskSteps {
    private final OpenTaskTestPage OpenTaskTestPage = new OpenTaskTestPage();
    private final CreateTask createTask = new CreateTask();
    private int diff;

    @Дано("пользователь применяет фильтр Все задачи")
    public void applyFilter() {
        OpenTaskTestPage.applyFilterAllProjects();
    }

    @Тогда("Фильтр Все задачи применился")
    public void filterChanged() {
        assertTrue(OpenTaskTestPage.waitCounterValueChange());
    }

    @Когда("пользователь создает быструю задачу")
    public void createFastTask() {
        diff = new ChangeCounter().changeCounter();
    }

    @Тогда("счетчик задач увеличился на {int}")
    public void counterIncreased(int expected) {
        assertEquals(expected, diff);
    }

}
