package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;
import edujiraifellow.utils.CustomProperties;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameField = $x("//input[@id='login-form-username']").as("Строка ввода логина");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Строка ввода пароля");
    private final SelenideElement loginButton = $x("//input[@value='Войти']").as("Кнопка Войти");

    public void isOnLoginPage() {
        if (loginButton.exists() && usernameField.exists()) {
            passwordField.exists();
        }
    }

    public void enterUsername(String username) {
        usernameField.setValue(CustomProperties.getProps().getProperty("login"));
    }

    public void enterPassword(String password) {
        passwordField.setValue(CustomProperties.getProps().getProperty("password"));
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        new MainPage();
    }
}