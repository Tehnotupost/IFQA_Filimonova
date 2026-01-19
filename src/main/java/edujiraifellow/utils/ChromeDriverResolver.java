package edujiraifellow.utils;

import java.io.File;

public class ChromeDriverResolver {
    public static File resolve() {
        String chromeVersion = CustomProperties.getProps().getProperty("chrome.version");
        String os = System.getProperty("os.name").toLowerCase();
        String platform;
        String ext = "";
        if (os.contains("win")) {
            platform = "win";
            ext = ".exe";
        } else if (os.contains("mac")) {
            platform = "mac";
        } else {
            platform = "linux";
        }
        String resourcePath = String.format(
                "drivers/chrome/%s/%s/chromedriver%s",
                chromeVersion, platform, ext
        );
        try {
            return DriverExtractor.extractDriver(resourcePath);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
