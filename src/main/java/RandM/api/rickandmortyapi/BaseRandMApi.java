package RandM.api.rickandmortyapi;

import io.restassured.RestAssured;
import utils.CustomProperties;
import utils.Specifications;

public abstract class BaseRandMApi {
    protected static CustomProperties config;

    public BaseRandMApi() {
        config = CustomProperties.getInstance();
        RestAssured.requestSpecification = Specifications.baseRequestSpec(config.randmUrl());
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
