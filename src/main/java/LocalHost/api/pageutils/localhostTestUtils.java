package LocalHost.api.pageutils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.qameta.allure.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class localhostTestUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Step("Парсинг файла с кредами")
    public static String getJsonBody(String pathOfUsingFile) {
        Path path = Paths.get(pathOfUsingFile);
        assertTrue(Files.exists(path), "Файла нет");
        try {
            return Files.readString(path);
        } catch (IOException e) {
            fail("Ошибка: " + e.getMessage());
            return null;
        }
    }

    @Step("Изменение данных в файле по ключу {typeOfUserData}")
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

    @Step("Проверка, что {fieldName} существует в файле")
    private static void requireFieldExists(ObjectNode node, String fieldName) {
        if (!node.has(fieldName)) {
            throw new IllegalArgumentException("Поле '" + fieldName + "' не найдено");
        }
    }

    @Step("Парсинг и сохранение токена из ответа")
    public static String saveToken(String responseBody) {
        return responseBody.replace("token : ", "").trim();
    }

}