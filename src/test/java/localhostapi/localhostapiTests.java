package localhostapi;

import LocalHost.api.localhostTestUtils;
import utils.CustomProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.core.StringContains.containsString;

public class localhostapiTests extends WebHooksLocal {

    @Test
    @DisplayName("Регистрация")
    public void testRegistrationFromJsonFile() {
        registerPageApi.registrationUser(localhostTestUtils.getJsonBody(CustomProperties.getProps().getProperty("filePath"))).statusCode(200);
    }

    @Test
    @DisplayName("Авторизация")
    public void testLoginFromJsonFile() {
        loginPageApi.loginUser(localhostTestUtils.changeDataInJson(CustomProperties.getProps().getProperty("filePath"), "username", CustomProperties.getProps().getProperty("newUsername"))).statusCode(401);
        loginPageApi.loginUser(localhostTestUtils.changeDataInJson(CustomProperties.getProps().getProperty("filePath"), "password", CustomProperties.getProps().getProperty("newPassword"))).statusCode(401);
        loginPageApi.loginUser(localhostTestUtils.getJsonBody(CustomProperties.getProps().getProperty("filePath"))).statusCode(200);
    }

    @Test
    @DisplayName("Выход из учетки")
    public void testLogout() {
        logoutPageApi.logoutUser(CustomProperties.getProps().getProperty("WrongToken")).statusCode(401).body(containsString("not found"));
        logoutPageApi.logoutUser(authToken).statusCode(200).body(containsString("success logout"));
    }
}
