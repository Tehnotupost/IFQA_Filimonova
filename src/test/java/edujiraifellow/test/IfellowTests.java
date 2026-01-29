package edujiraifellow.test;

import edujiraifellow.hooks.WebHooks;
import edujiraifellow.pages.CreateTaskTestPage;
import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.OpenTaskTestPage;
import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AllureJunit5.class)
@DisplayName("Smoke tests")
public class IfellowTests extends WebHooks {
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();
    private final CreateTaskTestPage createTaskTestPage = new CreateTaskTestPage();

    @Test
    @DisplayName("Авторизация с валидными данными")
    @Description("Проверяем, что юзер успешно логинится на сайт")
    @Feature("Функционал входа")
    @Story("Успешный вход")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Filimonova")
    @Tag("smoke")
    @AllureId("1")
    public void autoriseLoginPageTest() {
        loginPage.loginAs(config.login(), config.myPassword());
        mainPage.isOnMainPage();
    }

    @Test
    @DisplayName("Переход на страницу Тест")
    @Description("Проверяем, что можно перейти на страницу Тест из шапки")
    @Feature("Меню в шапке")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Filimonova")
    @Tag("smoke")
    @AllureId("2")
    public void goToTestPageTest() {
        loginPage.loginAs(config.login(),
                config.myPassword());
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
    }

    @Test
    @DisplayName("Проверка количества заведенных задач")
    @Description("Проверяем, что при создании задачи счетчик увеличивается на 1")
    @Feature("Функционал счетчика задач")
    @Story("При заведении новой задачи счетчик увеличился на 1")
    @Owner("Filimonova")
    @Tag("smoke")
    @AllureId("3")
    public void checkQualityTaskTest() {
        loginPage.loginAs(config.login(),
                config.myPassword());
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
    @Description("Проверяем, что задача с заданными параметрами находится в поиске")
    @Feature("Поиск задач по параметрам")
    @Story("Поиск задачи и проверка атрибутов")
    @Flaky
    @Owner("Filimonova")
    @Tag("smoke")
    @AllureId("4")
    public void checkTestSeleniumATHomeworkTest() {
        loginPage.loginAs(config.login(),
                config.myPassword());
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
        openTaskTestPage.applyFilterAllProjects();
        assertTrue(openTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        int difference = openTaskTestPage.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
        openTaskTestPage.initChekAllTaskAndFilters();
        openTaskTestPage.searchTask(config.testTaskName());
        assertEquals(config.statusOfTask(), openTaskTestPage.getStatusOfTaskValue(),
                "Статус не " + config.statusOfTask());
        assertEquals(config.fixVersion(), openTaskTestPage.getStatusOfFixVersion(),
                "Версия не" + config.fixVersion());
    }

    @Test
    @DisplayName("Создание баг-репорта")
    @Description("Проверяем корректное создание и закрытие багрепорта")
    @Feature("Создание задач")
    @Story("Создание и закрытие бага")
    @Owner("Filimonova")
    @Tag("smoke")
    @AllureId("5")
    public void createBugTask() {
        loginPage.loginAs(config.login(), config.myPassword());
        mainPage.isOnMainPage();
        mainPage.goToTestPage();
        openTaskTestPage.isOnTestPage();
        openTaskTestPage.applyFilterAllProjects();
        assertTrue(openTaskTestPage.waitCounterValueChange(), "каунтер сменился");
        int difference = openTaskTestPage.changeCounter();
        assertEquals(1, difference,
                "Счетчик увеличился на 1");
        openTaskTestPage.initChekAllTaskAndFilters();
        openTaskTestPage.searchTask(config.testTaskName());
        assertEquals(config.statusOfTask(), openTaskTestPage.getStatusOfTaskValue(),
                "Статус не " + config.statusOfTask());
        assertEquals(config.fixVersion(), openTaskTestPage.getStatusOfFixVersion(),
                "Версия не" + config.fixVersion());
        openTaskTestPage.clickCreateButton();
        createTaskTestPage.longCreate();
        openTaskTestPage.searchTask(config.bugTaskName());
        assertAll("Чек атрибутов",
                () -> assertTrue(openTaskTestPage.waitTaskNameInTableChange(), "Название сменилось"),
                () -> assertEquals(config.bugTaskName(), openTaskTestPage.getTaskNameInTable(),
                        "Название не совпадает"),
                () -> assertEquals(config.statusOfTask(), openTaskTestPage.getStatusOfTaskValue(),
                        "Статус не совпадает"),
                () -> assertEquals(config.fixVersion(), openTaskTestPage.getStatusOfFixVersion(),
                        "Версия не совпадает"));
        openTaskTestPage.selectTypeOfBug();
        assertAll("Баг закрыт",
                () -> assertTrue(openTaskTestPage.waitStatusOfTaskValueChange(), "Статус не сменился"),
                () -> assertEquals(config.statusDone(), openTaskTestPage.getStatusOfTaskValue(),
                        "Не закрыт"));
    }
}
