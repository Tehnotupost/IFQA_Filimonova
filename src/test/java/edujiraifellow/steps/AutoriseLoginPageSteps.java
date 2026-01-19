package edujiraifellow.steps;

import edujiraifellow.pages.LoginPage;
import edujiraifellow.pages.MainPage;
import edujiraifellow.utils.CustomProperties;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoriseLoginPageSteps {
    private final LoginPage LoginPage = new LoginPage();
    private final MainPage MainPage = new MainPage();

    @Когда("пользователь авторизован")
    public void userIsAuthorized() {
        LoginPage.loginAs(
                CustomProperties.getProps().getProperty("login"),
                CustomProperties.getProps().getProperty("password"));
    }

    @Тогда("открыта главная страница")
    public void mainPageIsOpen() {
        assertTrue(MainPage.isOnMainPage());
    }
}
