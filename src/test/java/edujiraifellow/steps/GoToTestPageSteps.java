package edujiraifellow.steps;

import edujiraifellow.pages.MainPage;
import edujiraifellow.pages.OpenTaskTestPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoToTestPageSteps {
    private final MainPage MainPage = new MainPage();
    private final OpenTaskTestPage OpenTaskTestPage = new OpenTaskTestPage();

    @When("пользователь переходит на страницу Тест")
    public void goToTestPage() {
        MainPage.goToTestPage();
    }

    @Then("открыта тестовая страница")
    public void testPageIsOpen() {
        assertTrue(OpenTaskTestPage.isOnTestPage());
    }
}
