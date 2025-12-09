package edujiraifellow;

import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.TestPage;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edujiraifellow.pages.TestPage.getStatusOfTaskValue;

public class ifellowTests extends WebHooks {

    private final LoginPage LoginPage = new LoginPage();
    private final MainPage MainPage = new MainPage();

    @Test
    @DisplayName("Авторизация")
    public void autoriseLoginPageTest(){
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
    }

    @Test
    @DisplayName("Переход на вкладку Тест")
    public void goToTestPageTest(){
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        MainPage.goToTestPage();
    }

    @Test
    @DisplayName("Проверка количества заведенных задач")
    public void checkQualityTaskTest(){
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        MainPage.goToTestPage();
        TestPage.applyFilterAllProjects();
        int lastNumberBefore = TestPage.getCounterValue();
        TestPage.clickCreateButton();  //чето с этим сделать
        TestPage.isOnCreateTaskPopAp();
        TestPage.enterNameOfTopic("Задача Задач1");
        TestPage.clickCreateButtonMini();
        int lastNumberAfter = TestPage.getCounterValue();
        if (lastNumberAfter - lastNumberBefore == 1) {
            System.out.println(1);
        }else System.out.println(lastNumberBefore);
    }

    @Test
    @DisplayName("Проверка задачи  TestSeleniumATHomework")
    public void checkTestSeleniumATHomeworkTest(){
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        MainPage.goToTestPage();
        TestPage.applyFilterAllProjects();
        int lastNumberBefore = TestPage.getCounterValue();
        TestPage.clickCreateButton();  //чето с этим сделать
        TestPage.isOnCreateTaskPopAp();
        TestPage.enterNameOfTopic("Задача Задач1");
        TestPage.clickCreateButtonMini();
        int lastNumberAfter = TestPage.getCounterValue();
        if (lastNumberAfter - lastNumberBefore == 1) {
            System.out.println(1);
        }else System.out.println(lastNumberBefore);
        TestPage.initChekAllTaskAndFilters();
        TestPage.enterInputTaskSearch("TestSeleniumATHomework");
        TestPage.clickSearchButton();
        TestPage.getStatusOfTaskValue();
        TestPage.getStatusOfFixVersion();
    }

    @Test
    @DisplayName("Создание бага")
    public void createBugTask(){
        LoginPage.isOnLoginPage();
        LoginPage.loginAs(CustomProperties.getProps().getProperty("login"),CustomProperties.getProps().getProperty("password"));
        MainPage.isOnMainPage();
        MainPage.goToTestPage();
        TestPage.applyFilterAllProjects();
        int lastNumberBefore = TestPage.getCounterValue();
        TestPage.clickCreateButton();  //чето с этим сделать
        TestPage.isOnCreateTaskPopAp();
        TestPage.enterNameOfTopic("Задача Задач1");
        TestPage.clickCreateButtonMini();
        int lastNumberAfter = TestPage.getCounterValue();
        if (lastNumberAfter - lastNumberBefore == 1) {
            System.out.println(1);
        }else System.out.println(lastNumberBefore);
        TestPage.initChekAllTaskAndFilters();
        TestPage.enterInputTaskSearch("TestSeleniumATHomework");
        TestPage.clickSearchButton();
        TestPage.getStatusOfTaskValue();
        TestPage.getStatusOfFixVersion();
        TestPage.clickCreateButton();
        TestPage.checkAndEnableButton();
        TestPage.selectTypeOfTask();
        TestPage.enterNameOfTopic("Баг багулечка");
//        TestPage.enterHeadInput("Здесь была ошибка");
        TestPage.clickCreateButtonMini();

    }
}
