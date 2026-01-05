package edujiraifellow.utils;

import lombok.Getter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class CustomProperties {

    @Getter
    private static final Properties props = new Properties();

    public static void loadProperties() {
        try (InputStream is = CustomProperties.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new RuntimeException(
                        "config.properties not found"
                );
            }
            props.load(new InputStreamReader(is, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
