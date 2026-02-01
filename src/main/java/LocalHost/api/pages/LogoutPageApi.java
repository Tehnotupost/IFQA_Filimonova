package LocalHost.api.pages;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static utils.metods.GetCall.callGet;

public class LogoutPageApi extends BaseLocalApi {
    @Step("Отправка GET запроса на выход с токеном в теле")
    public ValidatableResponse logoutUser(String authToken) {
        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalStateException("Токен не найден");
        }
        Map<String, String> headers = Map.of("Authorization", authToken);
        return callGet(config.logoutPath(), headers);
    }
}
