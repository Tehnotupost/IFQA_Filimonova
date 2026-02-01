package localhostapi.steps;

import LocalHost.api.pageutils.localhostTestUtils;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import localhostapi.context.Context;

import static localhostapi.hooks.WebHooksLocal.config;
import static org.hamcrest.core.StringContains.containsString;

public class CommonSteps {
    private Context context;

    public CommonSteps(Context context) {
        this.context = context;
    }

    @Дано("сохраняем токен")
    public void saveToken() {
        Response response =
                context.loginPageApi
                        .loginUser(localhostTestUtils.getJsonBody(config.filePath()))
                        .statusCode(config.statusCodeOk())
                        .extract()
                        .response();
        context.setAuthToken(localhostTestUtils.saveToken(response.getBody().asString()));
    }

    @Тогда("статускод {string}")
    public void statusCodeSuccess(String status) {
        context.getResponse().statusCode(Integer.parseInt(config.getProperty("status.code." + status)));
    }

    @Тогда("сообщение {string}")
    public void notifSuccess(String notifKey) {
        String expectedValue = config.getProperty("notif." + notifKey);
        context.getResponse().body(containsString(expectedValue));
    }
}
