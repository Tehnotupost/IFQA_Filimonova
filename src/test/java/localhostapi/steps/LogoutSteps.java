package localhostapi.steps;

import io.cucumber.java.ru.Когда;
import localhostapi.context.Context;

import static localhostapi.hooks.WebHooksLocal.config;

public class LogoutSteps {
    private Context context;

    public LogoutSteps(Context context) {
        this.context = context;
    }

    @Когда("разлогиниваемся с {string} токеном")
    public void testLogoutWithWrongToken(String typeOfToken) {
        String usedToken = switch (typeOfToken.toLowerCase()) {
            case "right" -> context.getAuthToken();
            case "wrong" -> config.wrongToken();
            default -> throw new IllegalArgumentException("Неверный тип токена: " + typeOfToken +
                    ". Допустимые значения: right, wrong");
        };
        context.setResponse(context.logoutPageApi.logoutUser(usedToken));
    }
}
