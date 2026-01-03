package RandM.api.rickandmortyapi;

import utils.Specifications;
import io.restassured.RestAssured;
import lombok.Data;
import utils.CustomProperties;

@Data
public abstract class BaseRandMApi {

    public BaseRandMApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(CustomProperties.getProps().getProperty("RandM_URL"));
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
