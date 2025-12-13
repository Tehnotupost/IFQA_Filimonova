package edujiraifellow;

import com.codeborne.selenide.Selenide;
import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.TestPage;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ifellowtests extends WebHooks {

    private final LoginPage LoginPage = new LoginPage();
    private final MainPage MainPage = new MainPage();
    private final TestPage TestPage = new TestPage();
    private static final String TEST_TASK_NAME = "TestSeleniumATHomework";
    private static final String EXPECTED_STATUS_VALUE = "СДЕЛАТЬ";
    private static final String EXPECTED_VERSION_VALUE = "Version 2.0";
    private static final String NAME_OF_PROJECT = "Test";
    private static final String TYPE_OF_TASK = "Ошибка";
    private static final String BUG_TASK_NAME = "Баг багулечка";
    private static final String REGULAR_TASK_NAME = "Задача Задач1";
    private static final String BUG_DESCRIPTION = "Здесь была ошибка";
    private static final String LABELS_oF_TASK_VALUE = "Test";

    @Test
    @DisplayName("Авторизация")
    public void autoriseLoginPageTest(){
        // Шаг 1
        assertTrue(LoginPage.isOnLoginPage(),
                "На странице авторизации");
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
    }

    @Test
    @DisplayName("Переход на вкладку Тест")
    public void goToTestPageTest(){
        // Шаг 1
        assertTrue(LoginPage.isOnLoginPage(),
                "На странице авторизации");
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        // Шаг 2
        MainPage.goToTestPage();
        assertTrue(TestPage.isOnTestPage(),
                "На тестовой странице");
    }

    @Test
    @DisplayName("Проверка количества заведенных задач")
    public void checkQualityTaskTest(){
        // Шаг 1
        assertTrue(LoginPage.isOnLoginPage(),
                "На странице авторизации");
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        // Шаг 2
        MainPage.goToTestPage();
        assertTrue(TestPage.isOnTestPage(),
                "На тестовой странице");
        // Шаг 3
        TestPage.applyFilterAllProjects();
        assertEquals("Все задачи", TestPage.checkSubnavigationTitle(),
                "Фильтр применился");
        assertTrue(TestPage.waitCounterValueChange(), "каунтер сменился");
        int lastNumberBefore = TestPage.getCounterValue();
        assertEquals(TestPage.getCounterValue(), lastNumberBefore,
                "Нужное");
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp(),
                "Окно отображается");
        TestPage.enterNameOfTopic(REGULAR_TASK_NAME);
        assertTrue( TestPage.getEnteredTopicName(REGULAR_TASK_NAME),
                "Ввелось то, что ввели");
        TestPage.clickCreateButtonMini();
        assertTrue(TestPage.isSuccessNotificationDisplayed(),
                "Нотиф об успешном создании");
        Selenide.refresh();
        int lastNumberAfter = TestPage.getCounterValue();
        assertEquals(lastNumberBefore + 1, lastNumberAfter,
                "Счетчик увеличился на 1");
    }

    @Test
    @DisplayName("Проверка задачи  TestSeleniumATHomework")
    public void checkTestSeleniumATHomeworkTest(){
        // Шаг 1
        assertTrue(LoginPage.isOnLoginPage(),
                "На странице авторизации");
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        // Шаг 2
        MainPage.goToTestPage();
        assertTrue(TestPage.isOnTestPage(),
                "На тестовой странице");
        // Шаг 3
        TestPage.applyFilterAllProjects();
        assertEquals("Все задачи", TestPage.checkSubnavigationTitle(),
                "Фильтр применился");
        assertTrue(TestPage.waitCounterValueChange(), "каунтер сменился");
        int lastNumberBefore = TestPage.getCounterValue();
        assertEquals(TestPage.getCounterValue(), lastNumberBefore,
                "Нужное");
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp(),
                "Окно отображается");
        TestPage.enterNameOfTopic(REGULAR_TASK_NAME);
        assertTrue( TestPage.getEnteredTopicName(REGULAR_TASK_NAME),
                "Ввелось то, что ввели");
        TestPage.clickCreateButtonMini();
        assertTrue(TestPage.isSuccessNotificationDisplayed(),
                "Нотиф об успешном создании");
        Selenide.refresh();
        int lastNumberAfter = TestPage.getCounterValue();
        assertEquals(lastNumberBefore + 1, lastNumberAfter,
                "Счетчик увеличился на 1");
        // Шаг 4
        TestPage.initChekAllTaskAndFilters();
        assertTrue(TestPage.inputTaskSearchExists(),
                "Строка поиска есть");
        TestPage.enterInputTaskSearch(TEST_TASK_NAME);
        TestPage.clickSearchButton();
        assertEquals(EXPECTED_STATUS_VALUE, TestPage.getStatusOfTaskValue(),
                "Статус " + EXPECTED_STATUS_VALUE);
        assertEquals(EXPECTED_VERSION_VALUE, TestPage.getStatusOfFixVersion(),
                "Версия " + EXPECTED_VERSION_VALUE);
    }

    @Test
    @DisplayName("Создание бага")
    public void createBugTask(){
        // Шаг 1
        assertTrue(LoginPage.isOnLoginPage(),
                "На странице авторизации");
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        assertTrue(MainPage.isOnMainPage(),
                "На главной странице");
        // Шаг 2
        MainPage.goToTestPage();
        assertTrue(TestPage.isOnTestPage(),
                "На тестовой странице");
        // Шаг 3
        TestPage.applyFilterAllProjects();
        assertEquals("Все задачи", TestPage.checkSubnavigationTitle(),
                "Фильтр применился");
        assertTrue(TestPage.waitCounterValueChange(), "каунтер сменился");
        int lastNumberBefore = TestPage.getCounterValue();
        assertEquals(TestPage.getCounterValue(), lastNumberBefore,
                "Нужное");
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp(),
                "Окно отображается");
        TestPage.enterNameOfTopic(REGULAR_TASK_NAME);
        assertTrue( TestPage.getEnteredTopicName(REGULAR_TASK_NAME),
                "Ввелось то, что ввели");
        TestPage.clickCreateButtonMini();
        assertTrue(TestPage.isSuccessNotificationDisplayed(),
                "Нотиф об успешном создании");
        Selenide.refresh();
        int lastNumberAfter = TestPage.getCounterValue();
        assertEquals(lastNumberBefore + 1, lastNumberAfter,
                "Счетчик увеличился на 1");
        // Шаг 4
        TestPage.initChekAllTaskAndFilters();
        assertTrue(TestPage.inputTaskSearchExists(),
                "Строка поиска есть");
        TestPage.enterInputTaskSearch(TEST_TASK_NAME);
        TestPage.clickSearchButton();
        assertEquals(EXPECTED_STATUS_VALUE, TestPage.getStatusOfTaskValue(),
                "Статус " + EXPECTED_STATUS_VALUE);
        assertEquals(EXPECTED_VERSION_VALUE, TestPage.getStatusOfFixVersion(),
                "Версия " + EXPECTED_VERSION_VALUE);
        // Шаг 5
        TestPage.clickCreateButton();
        assertTrue(TestPage.isOnCreateTaskPopAp());
        TestPage.checkAndEnableButton();
        TestPage.selectProjectName(NAME_OF_PROJECT);
        assertTrue(TestPage.isProjectSelected(NAME_OF_PROJECT),
                "Проект тот");
        TestPage.selectTypeOfTask(TYPE_OF_TASK);
        assertTrue( TestPage.getSelectedTaskType(TYPE_OF_TASK),
                "Тип задачи "+ TYPE_OF_TASK);
        TestPage.enterNameOfTopic(BUG_TASK_NAME);
        assertTrue( TestPage.getEnteredTopicName(BUG_TASK_NAME),
                "Название бага есть");
        TestPage.enterHeadInput(BUG_DESCRIPTION);
        TestPage.clickFixInVersion2p0();
        TestPage.setPriorityDropDown();
        TestPage.putLabelsOfTask(LABELS_oF_TASK_VALUE);
        assertTrue(TestPage.hasLabels(LABELS_oF_TASK_VALUE),
                "Метки есть");
        TestPage.clickCreateButtonMini();
        assertTrue(TestPage.isSuccessNotificationDisplayed(),
                "Нотиф об успешном создании");
        TestPage.enterInputTaskSearch(BUG_TASK_NAME);
        TestPage.clickSearchButton();
        assertAll("Чек атрибутов",
                () -> assertEquals(BUG_TASK_NAME, TestPage.getTaskNameInTable(),
                        "Название совпадает"),
                () -> assertEquals(EXPECTED_STATUS_VALUE, TestPage.getStatusOfTaskValue(),
                        "Статус совпадает"),
                () -> assertEquals(EXPECTED_VERSION_VALUE, TestPage.getStatusOfFixVersion(),
                        "Версия совпадает")
        );
        TestPage.selectTypeOfBug();
        assertEquals("Готово", TestPage.getStatusOfTaskValue(),
                "Закрыт");
    }
}
