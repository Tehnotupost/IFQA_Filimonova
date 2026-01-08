package edujiraifellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import edujiraifellow.utils.ChromeDriverResolver;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import java.io.File;

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
        File driver = ChromeDriverResolver.resolve();
        System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
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
