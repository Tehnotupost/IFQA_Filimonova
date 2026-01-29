package edujiraifellow.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import java.io.File;

public class BrowserManager {
    public static void openMainPage(CustomProperties config) {
        Selenide.open(config.mainUrl());
    }

    public static void maximizeWindow() {
        WebDriverRunner.getWebDriver()
                .manage()
                .window()
                .maximize();
    }

    public static void setupBrowser(CustomProperties config) {
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.chromeVersion();
        Configuration.headless = config.headlessEnabled();
        Configuration.timeout = config.timeout();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();
        File driver = ChromeDriverResolver.resolve(config);
        if (driver != null && driver.exists()) {
            System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
        }
    }
}
