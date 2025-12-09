package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;
import edujiraifellow.utils.CustomProperties;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']").as("Строка ввода логина");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Строка ввода пароля");
    private final SelenideElement loginButton = $x("//input[@value='Войти']").as("Кнопка Войти");
    private final SelenideElement welcomeMessage = $x("#userName-value");

    public boolean isOnLoginPage() {
        return loginButton.exists() &&
                usernameField.exists() &&
                passwordField.exists();
    }

    public LoginPage enterUsername(String username) {
        usernameField.setValue(CustomProperties.getProps().getProperty("login"));
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.setValue(CustomProperties.getProps().getProperty("password"));
        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

    public MainPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new MainPage();
    }

    public boolean isLoginSuccessful() {
        return welcomeMessage.exists() &&
                welcomeMessage.isDisplayed() &&
                !welcomeMessage.getText().isEmpty();
    }
}