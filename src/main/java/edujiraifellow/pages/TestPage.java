package edujiraifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class TestPage {

    private static final SelenideElement filterDropdownMenu = $x("//button[@id='subnav-trigger']").as("Меню Переключить фильтр");
    private static final SelenideElement filterAllProjects = $x("//li[@original-title]/child::a[contains(text(),'Все задачи')]").as("Фильтр Все задачи в выпадающем меню");
    private static final SelenideElement counterProjects = $x("//div[@class='showing']/child::span[contains(text(),'из')]").as("Счетчик");
    private static final SelenideElement createButton = $x("//li[@id='create-menu']/child::a[@id='create_link']").as("Кнопка Создать");
    private static final SelenideElement titleCreateTaskPopAp = $x("//h2[@title='Создание задачи']").as("Окно создания задачи");
    private static final SelenideElement typeOfTaskComboBox = $x("//input[@id='issuetype-field']").as("Тип задачи");
    private static final SelenideElement chekAllTaskAndFilters = $x("//div[@id='full-issue-navigator']/child::a[@href='/issues/']").as("Посмотреть все задачи и фильтры");
    private static final SelenideElement inputTaskSearch = $x("//input[@id='searcher-query']").as("Строка поиска по всем задачам");
    private static final SelenideElement searchButton = $x("//button[@original-title='Поиск задач']").as("Кнопка Поиск по всем задачам");
    private static final SelenideElement statusOfTask = $x("//span[@id='status-val']/child::span[text()='Сделать']").as("Статус задачи");
    private static final SelenideElement statusOfFixVersion = $x("//a[text()='Version 2.0']").as("Исправить в версиях");
    private static final SelenideElement topicInput = $x("//input[@class='text long-field']").as("Строка Тема");
    private static final SelenideElement createButtonMini = $x("//input[@id='create-issue-submit']").as("Кнопка Создать в попапе создания задачи");
    private static final SelenideElement exportButton = $x("//a[@id='worklog-tabpanel']").as("Кнопка Экспорт");
    private static final SelenideElement typeButtonVisible = $x("//button[text()='Визуальный']").as("Кнопка Визуальный");
    private static final SelenideElement headInput = $x("//iframe[@id='mce_19_ifr']").as("Описание");
    private static final SelenideElement processDropDown = $x("//span[contains(text(),'Бизнес-процесс')]").as("<Бизнес-процесс>");
    private static final SelenideElement processCloseBug = $x("//span[contains(text(),'Выполнено')]").as("Выполнено");

    public void applyFilterAllProjects(){
        filterDropdownMenu.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        filterAllProjects.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
    public int getCounterValue() {
        refresh();
        exportButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String counterText = counterProjects.getText();
        return Integer.parseInt(counterText.substring(counterText.lastIndexOf(" ") + 1));
    }
    public void clickCreateButton() {
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
    }
    public boolean isOnCreateTaskPopAp() {
        titleCreateTaskPopAp.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .exists();
        return true;
    }
    public void clickCreateButtonMini() {
        createButtonMini.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
    }
    public void enterNameOfTopic(String topicName) {
        topicInput.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .setValue(topicName);
    }
    public void initChekAllTaskAndFilters(){
        chekAllTaskAndFilters.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
    public void enterInputTaskSearch(String searchText) {
        inputTaskSearch.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .setValue(searchText);
    }
    public void clickSearchButton() {
        searchButton.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
    }
    public String getStatusOfTaskValue() {
        statusOfTask.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String counterText1 = statusOfTask.getText();
        System.out.println("Статус задачи: " + counterText1);
        return counterText1;
    }
    public String getStatusOfFixVersion() {
        statusOfFixVersion.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String counterText2 = statusOfFixVersion.getText();
        System.out.println("Исправить в версиях: " + counterText2);
        return counterText2;
    }
    public void clickTypeButtonVisible() {
        typeButtonVisible.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
    public void checkAndEnableButton() {
        typeButtonVisible.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String ariaPressedValue = typeButtonVisible.getAttribute("aria-pressed");
        if (!"true".equals(ariaPressedValue)) {
            clickTypeButtonVisible();
        } else {
            System.out.println("Кнопка уже в нажатом состоянии");
        }
    }
    public void selectTypeOfTask(){
        typeOfTaskComboBox.click();
        typeOfTaskComboBox.sendKeys(Keys.DELETE);
        typeOfTaskComboBox.setValue("Ошибка");
        typeOfTaskComboBox.sendKeys(Keys.ENTER);
    }

    public void enterHeadInput(String text) {
        Selenide.switchTo().frame(headInput);
        SelenideElement editorBody = $x("//body[@id='tinymce']");
        editorBody.shouldBe(Condition.visible).click();
        editorBody.sendKeys(text);
        Selenide.switchTo().defaultContent();
    }

    public void selectTypeOfBug() {
        processDropDown.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        processCloseBug.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
}