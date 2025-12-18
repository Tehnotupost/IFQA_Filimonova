package LocalHost.api;

import LocalHost.api.localhostapi.LoginPageApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class localhostTestUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final LoginPageApi loginPageApi = new LoginPageApi();

    public static String getJsonBody(String pathOfUsingFile) {
        Path path = Paths.get(pathOfUsingFile);
        assertTrue(Files.exists(path), "Файл есть");
        try {
            return Files.readString(path);
        } catch (IOException e) {
            fail("Ошибка: " + e.getMessage());
            return null;
        }
    }

    public static String changeDataInJson(String pathOfChangedFile, String typeOfUserData, String changedValue) {
        try {
            String jsonContent = getJsonBody(pathOfChangedFile);
            ObjectNode root = (ObjectNode) MAPPER.readTree(jsonContent);

            requireFieldExists(root, typeOfUserData);
            root.put(typeOfUserData, changedValue);

            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(root);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка обработки JSON: " + pathOfChangedFile, e);
        }
    }

    private static void requireFieldExists(ObjectNode node, String fieldName) {
        if (!node.has(fieldName)) {
            throw new IllegalArgumentException("Поле '" + fieldName + "' не найдено");
        }
    }

    public static String saveToken(String responseBody) {
        return responseBody.replace("token : ", "").trim();
    }

}