package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {
    private final SelenideElement menuProject = $x("//a[@title='Просмотр недавних проектов или списка всех проектов']").as("Кнопка Проекты в меню");
    private final SelenideElement projectTest = $x("//a[text()='Test (TEST)']").as("Проект Тест в выпадающем меню");

    @Step("Проверяем, что находимся на главной странице")
    public void isOnMainPage() {
        menuProject.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Переходим на страницу 'Тест'")
    public OpenTaskTestPage goToTestPage() {
        clickButton(menuProject);
        clickButton(projectTest);
        return new OpenTaskTestPage();
    }
}