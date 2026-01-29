package edujiraifellow.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import edujiraifellow.utils.CustomProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateTaskTestPage extends BasePage {
    private final SelenideElement typeOfTaskComboBox = $x("//input[@id='issuetype-field']").as("Тип задачи");
    private final SelenideElement topicInput = $x("//input[@id='summary']").as("Строка Тема");
    private final SelenideElement createButtonMini = $x("//input[@id='create-issue-submit']").as("Кнопка Создать в попапе создания задачи");
    private final SelenideElement projectName = $x("//input[@id='project-field']").as("Кнопка Проект");
    private final SelenideElement typeButtonVisible = $x("//button[text()='Визуальный']").as("Кнопка Визуальный");
    private final SelenideElement headInput = $x("//html[@style='height: auto;']/descendant::p").as("Описание");
    private final SelenideElement fixInVersion2p0 = $x("//select[@id='fixVersions']/descendant::option[contains(text(),'Version 2.0')]").as("Исправить в версии 2.0");
    private final SelenideElement priorityDropDown = $x("//input[@id='priority-field']").as("Приоритет");
    private final SelenideElement labelsOfTask = $x("//textarea[@id='labels-textarea']").as("Метки");

    @Step("Нажимаем кнопку 'Создать' в попапе")
    public void clickCreateButtonMini() {
        clickButton(createButtonMini);
    }

    @Step("Вводим тему '{topicName}'")
    public void enterNameOfTopic(String topicName) {
        topicInput.shouldBe(visible, Duration.ofSeconds(10))
                .setValue(topicName);
    }

    @Step("Нажимаем кнопку 'Визуальный'")
    public void clickTypeButtonVisible() {
        clickButton(typeButtonVisible);
    }

    @Step("Проверяем, что кнопка 'Визуальный' нажата")
    public void checkAndEnableButton() {
        typeButtonVisible.shouldBe(visible, Duration.ofSeconds(30));
        String ariaPressedValue = typeButtonVisible.getAttribute("aria-pressed");
        if (!"true".equals(ariaPressedValue)) {
            clickTypeButtonVisible();
        } else {
            System.out.println("Кнопка уже в нажатом состоянии");
        }
    }

    @Step("Выбираем проект '{nameOfProject}'")
    public void selectProjectName(String nameOfProject) {
        deleteTextAndSetNewValue(projectName, nameOfProject);
    }

    @Step("Выбираем тип задачи '{typeOfTask}'")
    public void selectTypeOfTask(String typeOfTask) {
        deleteTextAndSetNewValue(typeOfTaskComboBox, typeOfTask);
    }

    @Step("Добавляем описание '{bugDescription}'")
    public void enterHeadInput(String bugDescription) {
        Selenide.switchTo().frame($("iframe"));
        try {
            deleteTextAndSetNewValue(headInput, bugDescription);
        } finally {
            Selenide.switchTo().defaultContent();
        }
    }

    @Step("Выбираем 'Исправить в версиях 2.0'")
    public void clickFixInVersion2p0() {
        clickButton(fixInVersion2p0);
    }

    @Step("Выбираем приоритет")
    public void setPriorityDropDown() {
        priorityDropDown.click();
        priorityDropDown.sendKeys(Keys.ARROW_DOWN);
        priorityDropDown.sendKeys(Keys.ENTER);
    }

    @Step("Добавляем метку '{labelOfTaskValue}'")
    public void putLabelsOfTask(String labelsOfTaskValue) {
        deleteTextAndSetNewValue(labelsOfTask, labelsOfTaskValue);
    }

    @Step("Создаем баг-репорт")
    public void longCreate() {
        checkAndEnableButton();
        selectProjectName(CustomProperties.getInstance().nameOfProject());
        selectTypeOfTask(CustomProperties.getInstance().typeOfTask());
        enterNameOfTopic(CustomProperties.getInstance().bugTaskName());
        enterHeadInput(CustomProperties.getInstance().bugDescription());
        clickFixInVersion2p0();
        setPriorityDropDown();
        putLabelsOfTask(CustomProperties.getInstance().labelsOfTask());
        clickCreateButtonMini();
    }
}