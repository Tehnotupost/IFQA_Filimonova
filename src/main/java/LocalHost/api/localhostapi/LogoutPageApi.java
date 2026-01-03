package LocalHost.api.localhostapi;

import io.restassured.response.ValidatableResponse;
import utils.CustomProperties;
import java.util.Map;
import static utils.metods.GetCall.callGet;

public class LogoutPageApi extends BaseLocalApi {
    public ValidatableResponse logoutUser(String authToken) {
        if (authToken == null || authToken.isEmpty()) {
            throw new IllegalStateException("Токен не найден");
        }
    Map<String, String> headers = Map.of("Authorization", authToken);
    return callGet(CustomProperties.getProps().getProperty("LOGOUT_PATH"), headers);
    }
}
