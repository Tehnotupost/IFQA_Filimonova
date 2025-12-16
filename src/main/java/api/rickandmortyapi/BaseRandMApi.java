package api.rickandmortyapi;

import api.Specifications;
import constants.EnvConstants;
import io.restassured.RestAssured;
import lombok.Data;
@Data

public abstract class BaseRandMApi {

    public BaseRandMApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.RANDM_URL);
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
