package localhostapi;

import LocalHost.api.localhostTestUtils;
import LocalHost.api.localhostapi.LoginPageApi;
import LocalHost.api.localhostapi.LogoutPageApi;
import LocalHost.api.localhostapi.RegisterPageApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static LocalHost.api.constForCall.EnvLocalhostConst.filePath;


public class WebHooksLocal {
    protected String authToken;
    protected static final RegisterPageApi registerPageApi = new RegisterPageApi();
    protected static final LoginPageApi loginPageApi = new LoginPageApi();
    protected static final LogoutPageApi logoutPageApi= new LogoutPageApi();

    @BeforeAll
    static void setup() {
        RestAssured.port = 8080;
    }
    @BeforeEach
    void continuosUp() {
        registerPageApi
                .registrationUser(localhostTestUtils.getJsonBody(filePath))
                .statusCode(200);

        Response response =
                loginPageApi
                        .loginUser(localhostTestUtils.getJsonBody(filePath))
                        .statusCode(200)
                        .extract()
                        .response();

        authToken = localhostTestUtils.saveToken(response.getBody().asString());
        System.out.println("Записали" + authToken);
    }

    @AfterEach
    void preclose() {
        if (authToken != null) {
            logoutPageApi
                    .logoutUser(authToken);
        }
    }

    @AfterAll
    static void closeAll() {

    }
}
