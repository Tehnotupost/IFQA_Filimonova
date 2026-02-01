package utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:localhost.properties",
        "classpath:randm.properties"
})
@Config.HotReload(type = Config.HotReloadType.ASYNC, value = 5)
public interface CustomProperties extends Config {
    static CustomProperties getInstance() {
        return ConfigFactory.create(CustomProperties.class);
    }

    @Key("randm.url")
    @DefaultValue("https://rickandmortyapi.com/api")
    String randmUrl();

    @Key("character.path")
    String characterPath();

    @Key("episode.path")
    String episodePath();

    @Key("port")
    @DefaultValue("8080")
    int port();

    @Key("my.url")
    String myUrl();

    @Key("file.path")
    String filePath();

    @Key("register.path")
    String registerPath();

    @Key("login.path")
    String loginPath();

    @Key("logout.path")
    String logoutPath();

    @Key("wrong.token")
    String wrongToken();

    @Key("status.code.ok")
    int statusCodeOk();

    String getProperty(String key);
}
