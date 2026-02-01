package localhostapi.steps;

import LocalHost.api.pageutils.localhostTestUtils;
import io.cucumber.java.ru.Когда;
import localhostapi.context.Context;

import static localhostapi.hooks.WebHooksLocal.config;

public class AuthorizationSteps {
    private Context context;

    public AuthorizationSteps(Context context) {
        this.context = context;
    }

    @Когда("авторизуемся с измененным {string}")
    public void testRegistrationWithChangeData(String typeOfUserData) {
        context.setResponse(context.loginPageApi
                .loginUser(localhostTestUtils.changeDataInJson(config.filePath(), typeOfUserData,
                        config.getProperty("new." + typeOfUserData))));
    }

    @Когда("авторизуемся с валидными данными")
    public void testRegistrationFromJsonFile() {
        context.setResponse(context.loginPageApi.loginUser(localhostTestUtils.getJsonBody(config.filePath())));
    }
}
