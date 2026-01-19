package edujiraifellow.utils;

import java.io.*;
import java.nio.file.Files;

public class DriverExtractor {
    public static File extractDriver(String resourcePath) {
        try (InputStream is = DriverExtractor.class
                .getClassLoader()
                .getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new RuntimeException("Driver not found in resources: " + resourcePath);
            }
            File tempFile = Files.createTempFile("chromedriver", "").toFile();
            tempFile.deleteOnExit();

            try (OutputStream os = new FileOutputStream(tempFile)) {
                is.transferTo(os);
            }
            tempFile.setExecutable(true);
            return tempFile;
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract chromedriver", e);
        }
    }
}
