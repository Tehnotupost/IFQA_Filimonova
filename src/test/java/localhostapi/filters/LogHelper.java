package localhostapi.filters;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LogHelper implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        Object body = requestSpec.getBody();

        if (body != null) {
            String bodyForReport = body.toString().replaceAll(
                    "(\"password\"\\s*:\\s*\").*?(\")",
                    "$1******$2"
            );
            Allure.addAttachment("Request Body (Masked)", "application/json", bodyForReport);
        }
        return ctx.next(requestSpec, responseSpec);
    }

}
