package localhostapi.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import localhostapi.context.Context;
import localhostapi.filters.LogHelper;
import utils.CustomProperties;

public class WebHooksLocal {
    private Context context;
    public static CustomProperties config;

    public WebHooksLocal(Context context) {
        this.context = context;
    }

    @Before
    public void setup() {
        config = CustomProperties.getInstance();
        RestAssured.filters(new LogHelper());
        RestAssured.port = config.port();
    }

    @After
    public void preclose() {
        if (context.getAuthToken() != null) {
            context.logoutPageApi
                    .logoutUser(context.getAuthToken());
        }
    }
}
