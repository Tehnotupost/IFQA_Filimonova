package edujiraifellow.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

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
}
