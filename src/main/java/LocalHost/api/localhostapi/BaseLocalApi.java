package LocalHost.api.localhostapi;

import io.restassured.RestAssured;
import utils.CustomProperties;
import utils.Specifications;

public abstract class BaseLocalApi {
    public BaseLocalApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(CustomProperties.getProps().getProperty("MY_URL"));
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
