package LocalHost.api.localhostapi;

import utils.CustomProperties;
import io.restassured.response.ValidatableResponse;
import static utils.metods.PostCall.callPost;

public class LoginPageApi extends BaseLocalApi {
    public ValidatableResponse loginUser(String credentials) {
        return callPost(CustomProperties.getProps().getProperty("LOGIN_PATH"), credentials);
    }
}