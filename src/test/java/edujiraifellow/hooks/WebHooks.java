package edujiraifellow.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import edujiraifellow.utils.CustomProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.Configuration.webdriverLogsEnabled;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static edujiraifellow.utils.BrowserManager.*;

public class WebHooks {

    @BeforeAll
    public static void loadConfig() {
        CustomProperties.loadProperties();
        webdriverLogsEnabled = false;
        Configuration.browser = applyConfigurationBrowser();
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        Configuration.headless = false;
        addBrowserDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).
                savePageSource(false).includeSelenideSteps(false));
    }

    @BeforeEach
    public void initBrowser() {
        openMainPage();
        maximizeWindow();
    }

    @AfterEach
    public void afterTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
