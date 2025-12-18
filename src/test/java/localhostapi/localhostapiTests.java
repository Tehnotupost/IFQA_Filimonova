package localhostapi;

import LocalHost.api.localhostTestUtils;
import LocalHost.api.localhostapi.LoginPageApi;
import LocalHost.api.localhostapi.LogoutPageApi;
import LocalHost.api.localhostapi.RegisterPageApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static LocalHost.api.constForCall.EnvLocalhostConst.filePath;
import static org.hamcrest.core.StringContains.containsString;


public class localhostapiTests {
    private static final RegisterPageApi registerPageApi = new RegisterPageApi();
    private static final LoginPageApi loginPageApi = new LoginPageApi();
    private static final String newUsername = "notNeededUser";
    private static final String newPassword = "notNeededPassword";
    private static final String WrongToken = "272a6006-f5ba-0b00-0ce0-0ba11aaba454";
    private static String authToken;
    private static final LogoutPageApi logoutPageApi= new LogoutPageApi();

    @Test
    @DisplayName("Регистрация")
    @Order(1)
    public void testRegistrationFromJsonFile() {
        registerPageApi.registrationUser(localhostTestUtils.getJsonBody(filePath)).statusCode(200);
    }

    @Test
    @DisplayName("Авторизация")
    @Order(2)
    public void testLoginFromJsonFile() {
        loginPageApi.loginUser(localhostTestUtils.changeDataInJson(filePath, "username", newUsername)).statusCode(401);
        loginPageApi.loginUser(localhostTestUtils.changeDataInJson(filePath, "password", newPassword)).statusCode(401);
        Response response = loginPageApi.loginUser(localhostTestUtils.getJsonBody(filePath)).statusCode(200).extract().response();
        String responseBody = response.getBody().asString();
        authToken = localhostTestUtils.saveToken(Objects.requireNonNull(String.valueOf(responseBody)));
    }

    @Test
    @DisplayName("Выход из учетки")
    @Order(3)
    public void testLogout() {
        logoutPageApi.logoutUser(WrongToken).statusCode(401).body(containsString("not found"));
        logoutPageApi.logoutUser(authToken).statusCode(200).body(containsString("success logout"));
    }
}
