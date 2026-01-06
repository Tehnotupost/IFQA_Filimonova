package edujiraifellow.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import edujiraifellow.utils.ChromeDriverResolver;
import edujiraifellow.utils.CustomProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Configuration.webdriverLogsEnabled;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class WebHooks {

    @Before
    public static void loadConfig() {
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
        Selenide.open(CustomProperties.getProps().getProperty("main.url"));
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        webDriver.manage().window().maximize();
        System.out.println(Configuration.pageLoadStrategy);
    }

    @After
    public void afterTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
