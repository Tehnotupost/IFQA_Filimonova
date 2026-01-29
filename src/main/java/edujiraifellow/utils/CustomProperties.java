package edujiraifellow.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import java.util.Properties;

@Config.Sources({
        "classpath:config.properties"
})
@Config.HotReload(type = Config.HotReloadType.ASYNC, value = 5)
public interface CustomProperties extends Config {

    static CustomProperties getInstance() {
        return ConfigFactory.create(CustomProperties.class);
    }

    @Key("main.url")
    @DefaultValue("https://edujira.ifellow.ru/")
    String mainUrl();

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("chrome.version")
    @DefaultValue("143")
    String chromeVersion();

    @Key("page.load.strategy")
    @DefaultValue("eager")
    String pageLoadStrategy();

    @Key("timeout")
    @DefaultValue("15000")
    long timeout();

    @Key("headless.enabled")
    @DefaultValue("false")
    boolean headlessEnabled();

    @Key("allure.screenshots.enabled")
    @DefaultValue("false")
    boolean allureScreenshotsEnabled();

    @Key("save.page.source")
    @DefaultValue("false")
    boolean savePageSource();

    @Key("include.selenide.steps")
    @DefaultValue("false")
    boolean includeSelenideSteps();

    @Key("login")
    String login();

    @Key("password")
    String myPassword();

    @Key("test.task.name")
    String testTaskName();

    @Key("status.of.task")
    String statusOfTask();

    @Key("status.done")
    String statusDone();

    @Key("fix.version")
    String fixVersion();

    @Key("name.of.project")
    String nameOfProject();

    @Key("type.of.task")
    String typeOfTask();

    @Key("bug.task.name")
    String bugTaskName();

    @Key("regular.task.name")
    String regularTaskName();

    @Key("bug.description")
    String bugDescription();

    @Key("labels.of.task")
    String labelsOfTask();

    @DisableFeature(DisableableFeature.PARAMETER_FORMATTING)
    Properties getProperties();
}
