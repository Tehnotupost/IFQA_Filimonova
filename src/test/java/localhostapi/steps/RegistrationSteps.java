package localhostapi.steps;

import LocalHost.api.pageutils.localhostTestUtils;
import io.cucumber.java.ru.Когда;
import localhostapi.context.Context;

import static localhostapi.hooks.WebHooksLocal.config;

public class RegistrationSteps {
    private Context context;

    public RegistrationSteps(Context context) {
        this.context = context;
    }

    @Когда("регистрируемся")
    public void testRegistrationFromJsonFile() {
        context.setResponse(context.registerPageApi.registrationUser(localhostTestUtils.getJsonBody(config.filePath())));
    }
}
