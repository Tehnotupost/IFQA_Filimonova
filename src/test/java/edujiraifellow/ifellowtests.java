package edujiraifellow;

import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.TestPage;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ifellowtests extends WebHooks {

    private final LoginPage LoginPage = new LoginPage();
    private final MainPage MainPage = new MainPage();
    private final TestPage TestPage = new TestPage();
    private static final String TEST_TASK_NAME = "TestSeleniumATHomework";
    private static final String BUG_TASK_NAME = "Баг багулечка";
    private static final String REGULAR_TASK_NAME = "Задача Задач1";
    private static final String BUG_DESCRIPTION = "Здесь была ошибка";

    @Test
    @DisplayName("Авторизация")
    public void autoriseLoginPageTest(){
        // Шаг 1
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
    }

    @Test
    @DisplayName("Переход на вкладку Тест")
    public void goToTestPageTest(){
        // Шаг 1
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        // Шаг 2
        MainPage.goToTestPage();
    }

    @Test
    @DisplayName("Проверка количества заведенных задач")
    public void checkQualityTaskTest(){
        // Шаг 1
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        // Шаг 2
        MainPage.goToTestPage();
        // Шаг 3
        TestPage.applyFilterAllProjects();
        int lastNumberBefore = TestPage.getCounterValue();
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp(),
                "Окно отображается");
        TestPage.enterNameOfTopic(REGULAR_TASK_NAME);
        TestPage.clickCreateButtonMini();
        int lastNumberAfter = TestPage.getCounterValue();
        assertEquals(lastNumberBefore + 1, lastNumberAfter,
                "Счетчик увеличился на 1");
    }

    @Test
    @DisplayName("Проверка задачи  TestSeleniumATHomework")
    public void checkTestSeleniumATHomeworkTest(){
        // Шаг 1
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        // Шаг 2
        MainPage.goToTestPage();
        // Шаг 3
        TestPage.applyFilterAllProjects();
        int lastNumberBefore = TestPage.getCounterValue();
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp(),
                "Окно отображается");
        TestPage.enterNameOfTopic(REGULAR_TASK_NAME);
        TestPage.clickCreateButtonMini();
        int lastNumberAfter = TestPage.getCounterValue();
        assertEquals(lastNumberBefore + 1, lastNumberAfter,
                "Счетчик увеличился на 1");
        // Шаг 4
        TestPage.initChekAllTaskAndFilters();
        TestPage.enterInputTaskSearch(TEST_TASK_NAME);
        TestPage.clickSearchButton();
        assertEquals("Сделать", TestPage.getStatusOfTaskValue(),
                "Статус 'Сделать'");
        assertEquals("Version 2.0", TestPage.getStatusOfFixVersion(),
                "Версия 'Version 2.0'");
    }

    @Test
    @DisplayName("Создание бага")
    public void createBugTask(){
        // Шаг 1
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        // Шаг 2
        MainPage.goToTestPage();
        // Шаг 3
        TestPage.applyFilterAllProjects();
        int lastNumberBefore = TestPage.getCounterValue();
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp(),
                "Окно отображается");
        TestPage.enterNameOfTopic(REGULAR_TASK_NAME);
        TestPage.clickCreateButtonMini();
        int lastNumberAfter = TestPage.getCounterValue();
        assertEquals(lastNumberBefore + 1, lastNumberAfter,
                "Счетчик увеличился на 1");
        // Шаг 4
        TestPage.initChekAllTaskAndFilters();
        TestPage.enterInputTaskSearch(TEST_TASK_NAME);
        TestPage.clickSearchButton();
        assertEquals("СДЕЛАТЬ", TestPage.getStatusOfTaskValue(),
                "Статус 'Сделать'");
        assertEquals("Version 2.0", TestPage.getStatusOfFixVersion(),
                "Версия 'Version 2.0'");
        // Шаг 5
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp());
        TestPage.checkAndEnableButton();
        TestPage.selectTypeOfTask();
        TestPage.enterNameOfTopic(BUG_TASK_NAME);
//        TestPage.enterHeadInput(BUG_DESCRIPTION); не получается, не знаю, почему
        TestPage.clickCreateButtonMini();
        TestPage.enterInputTaskSearch(BUG_TASK_NAME);
        TestPage.clickSearchButton();
        TestPage.selectTypeOfBug();
    }
}
