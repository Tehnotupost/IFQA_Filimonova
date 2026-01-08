package edujiraifellow.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import java.util.Map;

public class BrowserManager {
    public static void openMainPage() {
        Selenide.open(CustomProperties.getProps().getProperty("main.url"));
    }

    public static void maximizeWindow() {
        WebDriverRunner.getWebDriver()
                .manage()
                .window()
                .maximize();
    }

    public static String applyConfigurationBrowser() {
        return CustomProperties.getProps().getProperty("browser.name");
    }

    public static void isBrowserLogsEnabled(String value) {
        Configuration.browserCapabilities.setCapability(
                "goog:loggingPrefs",
                Map.of("browser", CustomProperties.getProps().getProperty(value),
                        "driver", CustomProperties.getProps().getProperty(value)));
    }
}
