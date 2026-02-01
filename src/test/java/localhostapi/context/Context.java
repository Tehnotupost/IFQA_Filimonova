package localhostapi.context;

import LocalHost.api.pages.LoginPageApi;
import LocalHost.api.pages.LogoutPageApi;
import LocalHost.api.pages.RegisterPageApi;
import io.restassured.response.ValidatableResponse;
import lombok.Data;

@Data
public class Context {
    private ValidatableResponse response;
    private String authToken;
    public RegisterPageApi registerPageApi = new RegisterPageApi();
    public LoginPageApi loginPageApi = new LoginPageApi();
    public LogoutPageApi logoutPageApi = new LogoutPageApi();
}
