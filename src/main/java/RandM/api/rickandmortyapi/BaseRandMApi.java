package RandM.api.rickandmortyapi;

import RandM.api.Specifications;
import RandM.api.constants.EnvConstants;
import io.restassured.RestAssured;
import lombok.Data;
@Data

public abstract class BaseRandMApi {

    public BaseRandMApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.RANDM_URL);
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
