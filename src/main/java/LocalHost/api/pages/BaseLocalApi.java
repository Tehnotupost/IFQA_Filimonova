package LocalHost.api.pages;

import io.restassured.RestAssured;
import utils.CustomProperties;
import utils.Specifications;

public abstract class BaseLocalApi {
    protected static CustomProperties config;

    public BaseLocalApi() {
        config = CustomProperties.getInstance();
        RestAssured.requestSpecification = Specifications.baseRequestSpec(config.myUrl());
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
