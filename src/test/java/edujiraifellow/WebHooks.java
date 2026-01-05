package edujiraifellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import edujiraifellow.utils.ChromeDriverResolver;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import java.io.File;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class WebHooks {

    @BeforeAll
    public static void loadConfig() {
        CustomProperties.loadProperties();
        webdriverLogsEnabled = false;
        Configuration.browser = CustomProperties.getProps().getProperty("browser.name");
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        File driver = ChromeDriverResolver.resolve();
        System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
    }

    @BeforeEach
    public void initBrowser() {
        Selenide.open(CustomProperties.getProps().getProperty("main.url"));
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        webDriver.manage().window().maximize();
        System.out.println(Configuration.pageLoadStrategy);
    }

    @AfterEach
    public void afterTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
