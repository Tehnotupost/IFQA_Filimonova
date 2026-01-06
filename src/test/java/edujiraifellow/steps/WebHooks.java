package edujiraifellow.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import edujiraifellow.utils.ChromeDriverResolver;
import edujiraifellow.utils.CustomProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Configuration.webdriverLogsEnabled;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static edujiraifellow.utils.BrowserManager.maximizeWindow;
import static edujiraifellow.utils.BrowserManager.openMainPage;

public class WebHooks {

    @Before
    public void loadConfig() {
        CustomProperties.loadProperties();
        webdriverLogsEnabled = false;
        Configuration.browserCapabilities.setCapability(
                "goog:loggingPrefs",
                Map.of("browser", "OFF", "driver", "OFF"));
        Configuration.browser = CustomProperties.getProps().getProperty("browser.name");
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        File driver = ChromeDriverResolver.resolve();
        System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
        openMainPage();
        maximizeWindow();
    }

    @After
    public void afterTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
