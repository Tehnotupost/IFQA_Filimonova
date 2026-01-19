package edujiraifellow.steps;

import edujiraifellow.pages.OpenTaskTestPage;
import edujiraifellow.utils.CustomProperties;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckTestSeleniumATHomeworkSteps {
    private final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();

    @Когда("пользователь ищет задачу {string}")
    public void fyndeTask(String nametask) {
        openTaskTestPage.initChekAllTaskAndFilters();
        openTaskTestPage.searchTask(CustomProperties.getProps().getProperty(nametask));
    }

    @Тогда("статус задачи {string}")
    public void checkTaskStatus(String expected) {
        assertEquals(CustomProperties.getProps().getProperty(expected), openTaskTestPage.getStatusOfTaskValue(), "Статус задачи не совпадает");
    }

    @Тогда("версия фикса {string}")
    public void checkFixVersion(String expected) {
        assertEquals(CustomProperties.getProps().getProperty(expected), openTaskTestPage.getStatusOfFixVersion(), "Версия фикса не совпадает");
    }
}
