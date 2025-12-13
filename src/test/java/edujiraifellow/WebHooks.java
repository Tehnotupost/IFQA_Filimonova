package edujiraifellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import edujiraifellow.utils.CustomProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class WebHooks {

    @BeforeAll
    public static void loadConfig() {
        CustomProperties.loadProperties();
    };

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        Selenide.open(CustomProperties.getProps().getProperty("main.url"));
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();
        System.out.println(Configuration.pageLoadStrategy);
    }

    @AfterEach
    public void afterTest() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @AfterAll
    public static void closeConfig() {
        System.out.println("Конец");
    }
}
