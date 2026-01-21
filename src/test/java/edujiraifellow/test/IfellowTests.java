package edujiraifellow.test;

import edujiraifellow.hooks.WebHooks;
import edujiraifellow.pages.CreateTaskTestPage;
import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.OpenTaskTestPage;
import edujiraifellow.utils.CustomProperties;
import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AllureJunit5.class)
public class IfellowTests extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();
    private final CreateTaskTestPage createTaskTestPage = new CreateTaskTestPage();

    @Test
    @DisplayName("Авторизация с валидными данными")
    @Feature("Функционал входа")
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Filimonova")
    public void autoriseLoginPageTest() {
        loginPage.loginAs(CustomProperties.getProps().getProperty("login"),
                CustomProperties.getProps().getProperty("password"));
        mainPage.isOnMainPage();
    }

    @Test
    @DisplayName("Переход на страницу Тест")
    @Feature("Меню в шапке")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Filimonova")
    public void goToTestPageTest() {
        loginPage.loginAs(CustomProperties.getProps().getProperty("login"),
                CustomProperties.getProps().getProperty("password"));
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
    }

    @Test
    @DisplayName("Проверка количества заведенных задач")
    @Feature("Функционал счетчика задач")
    @Story("При заведении новой задачи счетчик увеличился на 1")
    @Owner("Filimonova")
    public void checkQualityTaskTest() {
        loginPage.loginAs(CustomProperties.getProps().getProperty("login"),
                CustomProperties.getProps().getProperty("password"));
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
        openTaskTestPage.applyFilterAllProjects();
        assertTrue(openTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        int difference = openTaskTestPage.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
    }

    @Test
    @DisplayName("Проверка задачи  TestSeleniumATHomework")
    @Feature("Поиск задач по параметрам")
    @Story("Поиск задачи и проверка атрибутов")
    @Flaky
    @Owner("Filimonova")
    public void checkTestSeleniumATHomeworkTest() {
        loginPage.loginAs(CustomProperties.getProps().getProperty("login"),
                CustomProperties.getProps().getProperty("password"));
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
        openTaskTestPage.applyFilterAllProjects();
        assertTrue(openTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        int difference = openTaskTestPage.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
        openTaskTestPage.initChekAllTaskAndFilters();
        openTaskTestPage.searchTask(CustomProperties.getProps().getProperty("TEST_TASK_NAME"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"), openTaskTestPage.getStatusOfTaskValue(),
                "Статус " + CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"), openTaskTestPage.getStatusOfFixVersion(),
                "Версия " + CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"));
    }

    @Test
    @DisplayName("Создание баг-репорта")
    @Feature("Создание задач")
    @Story("Создание и закрытие бага")
    @Owner("Filimonova")
    public void createBugTask() {
        loginPage.loginAs(CustomProperties.getProps().getProperty("login"), CustomProperties.getProps().getProperty("password"));
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
        openTaskTestPage.applyFilterAllProjects();
        assertTrue(openTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        int difference = openTaskTestPage.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
        openTaskTestPage.initChekAllTaskAndFilters();
        openTaskTestPage.searchTask(CustomProperties.getProps().getProperty("TEST_TASK_NAME"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"), openTaskTestPage.getStatusOfTaskValue(),
                "Статус " + CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"));
        assertEquals(CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"), openTaskTestPage.getStatusOfFixVersion(),
                "Версия " + CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"));
        openTaskTestPage.clickCreateButton();
        createTaskTestPage.longCreate();
        openTaskTestPage.searchTask(CustomProperties.getProps().getProperty("BUG_TASK_NAME"));
        assertAll("Чек атрибутов",
                () -> assertTrue(openTaskTestPage.waitTaskNameInTableChange(), "Название сменилось"),
                () -> assertEquals(CustomProperties.getProps().getProperty("BUG_TASK_NAME"), openTaskTestPage.getTaskNameInTable(),
                        "Название совпадает"),
                () -> assertEquals(CustomProperties.getProps().getProperty("EXPECTED_STATUS_VALUE"), openTaskTestPage.getStatusOfTaskValue(),
                        "Статус совпадает"),
                () -> assertEquals(CustomProperties.getProps().getProperty("EXPECTED_VERSION_VALUE"), openTaskTestPage.getStatusOfFixVersion(),
                        "Версия совпадает"));
        openTaskTestPage.selectTypeOfBug();
        assertAll("Баг закрыт",
                () -> assertTrue(openTaskTestPage.waitStatusOfTaskValueChange(), "Статус сменился"),
                () -> assertEquals("ГОТОВО", openTaskTestPage.getStatusOfTaskValue(),
                        "Закрыт"));
    }
}
