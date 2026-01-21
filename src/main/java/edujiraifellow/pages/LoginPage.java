package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']").as("Строка ввода логина");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Строка ввода пароля");
    private final SelenideElement loginButton = $x("//input[@value='Войти']").as("Кнопка Войти");

    @Step("Проверяем, что находимся на странице логина")
    public void isOnLoginPage() {
        loginButton.shouldBe(visible, Duration.ofSeconds(10));
        usernameField.shouldBe(visible, Duration.ofSeconds(10));
        passwordField.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Вводим логин: '{username}'")
    public void enterUsername(String username) {
        usernameField.setValue(username);
    }

    @Step("Вводим пароль *******")
    public void enterPassword(String password) {
        maskedPassword();
        passwordField.setValue(password);
    }

    @Step("Нажимаем кнопку 'Войти'")
    public void clickLogin() {
        loginButton.click();
    }

    @Step("Логинимся c логином '{username}' и паролем ******")
    public MainPage loginAs(String username, String password) {
        maskedPassword();
        isOnLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new MainPage();
    }

    public void maskedPassword() {
        Allure.getLifecycle().updateStep(stepResult -> {
            stepResult.getParameters().stream()
                    .filter(p -> "password".equals(p.getName()))
                    .forEach(p -> p.setValue("******"));
        });
    }
}