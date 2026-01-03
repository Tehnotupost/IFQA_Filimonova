package localhostapi;

import LocalHost.api.localhostTestUtils;
import LocalHost.api.localhostapi.LoginPageApi;
import LocalHost.api.localhostapi.LogoutPageApi;
import LocalHost.api.localhostapi.RegisterPageApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.CustomProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHooksLocal {
    protected String authToken;
    protected static RegisterPageApi registerPageApi;
    protected static LoginPageApi loginPageApi;
    protected static LogoutPageApi logoutPageApi;

    @BeforeAll
    static void setup() {
        CustomProperties.loadProperties();
        RestAssured.port = Integer.parseInt(CustomProperties.getProps().getProperty("port"));
        registerPageApi = new RegisterPageApi();
        loginPageApi = new LoginPageApi();
        logoutPageApi= new LogoutPageApi();
    }

    @BeforeEach
    void continuosUp() {
        registerPageApi
                .registrationUser(localhostTestUtils.getJsonBody(CustomProperties.getProps().getProperty("filePath")))
                .statusCode(200);

        Response response =
                loginPageApi
                        .loginUser(localhostTestUtils.getJsonBody(CustomProperties.getProps().getProperty("filePath")))
                        .statusCode(200)
                        .extract()
                        .response();

        authToken = localhostTestUtils.saveToken(response.getBody().asString());
    }

    @AfterEach
    void preclose() {
        if (authToken != null) {
            logoutPageApi
                    .logoutUser(authToken);
        }
    }
}
