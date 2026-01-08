package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']").as("Строка ввода логина");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Строка ввода пароля");
    private final SelenideElement loginButton = $x("//input[@value='Войти']").as("Кнопка Войти");

    public boolean isOnLoginPage() {
        loginButton.shouldBe(visible, Duration.ofSeconds(10));
        usernameField.shouldBe(visible, Duration.ofSeconds(10));
        passwordField.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }

    public void enterUsername(String username) {
        usernameField.setValue(username);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loginAs(String username, String password) {
        assertTrue(isOnLoginPage(),
                "На странице авторизации");
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        new MainPage();
    }
}