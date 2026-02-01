package LocalHost.api.pages;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static utils.metods.PostCall.callPost;

public class LoginPageApi extends BaseLocalApi {

    @Step("Отправка POST запроса авторизациии с ключами логин/пароль в теле")
    public ValidatableResponse loginUser(String credentials) {
        return callPost(config.loginPath(), credentials);
    }
}