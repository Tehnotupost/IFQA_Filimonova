package edujiraifellow.steps;

import edujiraifellow.pages.CreateTaskTestPage;
import edujiraifellow.pages.OpenTaskTestPage;
import edujiraifellow.utils.CustomProperties;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateBugTaskSteps {
    private final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();
    private final CreateTaskTestPage createTaskTestPage = new CreateTaskTestPage();

    @Когда("пользователь создает баг")
    public void createBug() {
        openTaskTestPage.clickCreateButton();
        createTaskTestPage.longCreate();
    }

    @Тогда("баг отображается в таблице")
    public void bugVisible() {
        assertTrue(openTaskTestPage.waitTaskNameInTableChange(), "Название бага не сменилось");
        assertEquals(
                CustomProperties.getProps().getProperty("BUG_TASK_NAME"),
                openTaskTestPage.getTaskNameInTable(), "Название бага не совпадает");
    }

    @Когда("пользователь закрывает баг")
    public void closeBug() {
        openTaskTestPage.selectTypeOfBug();
        assertTrue(openTaskTestPage.waitStatusOfTaskValueChange(), "Статус бага не сменился");
    }
}