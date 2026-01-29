package edujiraifellow.hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import edujiraifellow.utils.CustomProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static edujiraifellow.utils.BrowserManager.*;

public class WebHooks {
    protected static CustomProperties config;

    @BeforeAll
    public static void loadConfig() {
        config = CustomProperties.getInstance();
        setupBrowser(config);
        SelenideLogger.removeListener("AllureSelenide");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(config.allureScreenshotsEnabled()).
                savePageSource(config.savePageSource()).includeSelenideSteps(config.includeSelenideSteps()));
    }

    @BeforeEach
    public void initBrowser() {
        openMainPage(config);
        maximizeWindow();
    }

    @AfterEach
    public void afterTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @AfterAll
    public static void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
