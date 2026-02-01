package LocalHost.api.pages;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static utils.metods.PostCall.callPost;

public class RegisterPageApi extends BaseLocalApi {
    @Step("Отправка POST запроса на регистрацию с ключами логин/пароль в теле")
    public ValidatableResponse registrationUser(String credentials) {
        return callPost(config.registerPath(), credentials);
    }
}
