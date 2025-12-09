package edujiraifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement activityFeedWelcomeText = $x("//h2[text()='Your Company Jira']").as("Текст в ленте активности");
    private final SelenideElement menuProject = $x("//a[@title='Просмотр недавних проектов или списка всех проектов']").as("Кнопка Проекты в меню");
    private final SelenideElement projectTest = $x("//a[text()='Test (TEST)']").as("Проект Тест в выпадающем меню");

    public void isOnMainPage() {
        if (activityFeedWelcomeText.exists()) {
            menuProject.exists();
        }
    }

    public void goToTestPage(){
        menuProject.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        projectTest.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        Selenide.page(TestPage.class);
    }
}