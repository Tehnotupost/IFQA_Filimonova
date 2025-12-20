package localhostapi;

import LocalHost.api.localhostTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static LocalHost.api.constForCall.EnvLocalhostConst.filePath;
import static org.hamcrest.core.StringContains.containsString;


public class localhostapiTests extends WebHooksLocal {
    private static final String newUsername = "notNeededUser";
    private static final String newPassword = "notNeededPassword";
    private static final String WrongToken = "272a6006-f5ba-0b00-0ce0-0ba11aaba454";

    @Test
    @DisplayName("Регистрация")
    public void testRegistrationFromJsonFile() {
        registerPageApi.registrationUser(localhostTestUtils.getJsonBody(filePath)).statusCode(200);
    }

    @Test
    @DisplayName("Авторизация")
    public void testLoginFromJsonFile() {
        loginPageApi.loginUser(localhostTestUtils.changeDataInJson(filePath, "username", newUsername)).statusCode(401);
        loginPageApi.loginUser(localhostTestUtils.changeDataInJson(filePath, "password", newPassword)).statusCode(401);
        loginPageApi.loginUser(localhostTestUtils.getJsonBody(filePath)).statusCode(200);
    }

    @Test
    @DisplayName("Выход из учетки")
    public void testLogout() {
        logoutPageApi.logoutUser(WrongToken).statusCode(401).body(containsString("not found"));
        logoutPageApi.logoutUser(authToken).statusCode(200).body(containsString("success logout"));
    }
}
