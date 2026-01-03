package LocalHost.api.localhostapi;

import io.restassured.response.ValidatableResponse;
import utils.CustomProperties;
import static utils.metods.PostCall.callPost;

public class RegisterPageApi extends BaseLocalApi {
    public ValidatableResponse registrationUser(String credentials) {
       return callPost(CustomProperties.getProps().getProperty("REGISTER_PATH"), credentials);
    }
}
