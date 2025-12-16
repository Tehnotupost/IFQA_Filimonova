package api.rickandmortyapi;

import api.Specifications;
import constsnts.EnvConstants;
import constsnts.Info;
import io.restassured.RestAssured;
import lombok.Data;
import java.util.List;
@Data

public abstract class BaseRandMApi {

    public BaseRandMApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.RANDM_URL);
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }

    public class ExampleJson2KtPOJO {
        String characters;
        String locations;
        String episodes;
        Info info;
        List<String> results;
    }
}
