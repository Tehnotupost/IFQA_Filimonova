package LocalHost.api.localhostapi;

import LocalHost.api.constForCall.EnvLocalhostConst;
import LocalHost.api.localhostSpec;
import io.restassured.RestAssured;

public abstract class BaseLocalApi {
    public BaseLocalApi() {
        RestAssured.requestSpecification = localhostSpec.baseRequestSpec(EnvLocalhostConst.MY_URL);
        RestAssured.responseSpecification = localhostSpec.baseResponseSpecSuccess();
    }
}
