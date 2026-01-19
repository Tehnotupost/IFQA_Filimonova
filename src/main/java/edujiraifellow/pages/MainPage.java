package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage{
    private final SelenideElement menuProject = $x("//a[@title='Просмотр недавних проектов или списка всех проектов']").as("Кнопка Проекты в меню");
    private final SelenideElement projectTest = $x("//a[text()='Test (TEST)']").as("Проект Тест в выпадающем меню");

    public boolean isOnMainPage() {
        menuProject.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }

    public void goToTestPage(){
        clickButton(menuProject);
        clickButton(projectTest);
        new OpenTaskTestPage();
    }
}