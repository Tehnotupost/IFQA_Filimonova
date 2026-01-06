package edujiraifellow;

import edujiraifellow.motion.ChangeCounter;
import edujiraifellow.motion.CreateTask;
import edujiraifellow.motion.SearchTask;
import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.OpenTaskTestPage;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ifellowtests extends WebHooks {
    private final LoginPage LoginPage = new LoginPage();
    private final MainPage MainPage = new MainPage();
    private final OpenTaskTestPage OpenTaskTestPage = new OpenTaskTestPage();

    @Test
    @DisplayName("Авторизация")
    public void autoriseLoginPageTest() {
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"), CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
    }

    @Test
    @DisplayName("Переход на вкладку Тест")
    public void goToTestPageTest() {
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"), CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        MainPage.goToTestPage();
        assertTrue(OpenTaskTestPage.isOnTestPage(),
                "На тестовой странице");
    }

    @Test
    @DisplayName("Проверка количества заведенных задач")
    public void checkQualityTaskTest() {
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"), CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        MainPage.goToTestPage();
        assertTrue(OpenTaskTestPage.isOnTestPage(),
                "На тестовой странице");
        OpenTaskTestPage.applyFilterAllProjects();
        assertTrue(OpenTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        ChangeCounter ChangeCounter = new ChangeCounter();
        int difference = ChangeCounter.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
    }

    @Test
    @DisplayName("Проверка задачи  TestSeleniumATHomework")
    public void checkTestSeleniumATHomeworkTest() {
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"), CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        MainPage.goToTestPage();
        assertTrue(OpenTaskTestPage.isOnTestPage(),
                "На тестовой странице");
        OpenTaskTestPage.applyFilterAllProjects();
        assertTrue(OpenTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        ChangeCounter ChangeCounter = new ChangeCounter();
        int difference = ChangeCounter.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
        OpenTaskTestPage.initChekAllTaskAndFilters();
        SearchTask searchTask = new SearchTask();
        searchTask.searchTask(CustomProperties.getProps().getProperty("TEST_TASK_NAME"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"), OpenTaskTestPage.getStatusOfTaskValue(),
                "Статус " + CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"), OpenTaskTestPage.getStatusOfFixVersion(),
                "Версия " + CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"));
    }

    @Test
    @DisplayName("Создание бага")
    public void createBugTask() {
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"), CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        MainPage.goToTestPage();
        assertTrue(OpenTaskTestPage.isOnTestPage(),
                "На тестовой странице");
        OpenTaskTestPage.applyFilterAllProjects();
        assertTrue(OpenTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        ChangeCounter ChangeCounter = new ChangeCounter();
        int difference = ChangeCounter.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
        OpenTaskTestPage.initChekAllTaskAndFilters();
        SearchTask searchTask = new SearchTask();
        searchTask.searchTask(CustomProperties.getProps().getProperty("TEST_TASK_NAME"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"), OpenTaskTestPage.getStatusOfTaskValue(),
                "Статус " + CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"), OpenTaskTestPage.getStatusOfFixVersion(),
                "Версия " + CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"));
        CreateTask CreateTask = new CreateTask();
        CreateTask.longCreate();
        assertAll("Чек атрибутов",
                () -> assertTrue(OpenTaskTestPage.waitTaskNameInTableChange(), "Название сменилось"),
                () -> assertEquals(CustomProperties.getProps().getProperty("BUG_TASK_NAME"), OpenTaskTestPage.getTaskNameInTable(),
                        "Название совпадает"),
                () -> assertEquals(CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"), OpenTaskTestPage.getStatusOfTaskValue(),
                        "Статус совпадает"),
                () -> assertEquals(CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"), OpenTaskTestPage.getStatusOfFixVersion(),
                        "Версия совпадает"));
        OpenTaskTestPage.selectTypeOfBug();
        assertAll("Баг закрыт",
                () -> assertTrue(OpenTaskTestPage.waitStatusOfTaskValueChange(), "Статус сменился"),
                () -> assertEquals("ГОТОВО", OpenTaskTestPage.getStatusOfTaskValue(),
                        "Закрыт"));
    }
}
