package edujiraifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

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
    private static final SelenideElement saveKey = $x("//div[@id='issuetype-single-select']/child::span[@class='icon aui-ss-icon noloading drop-menu']").as("Стрелка");

    public static void applyFilterAllProjects(){
        filterDropdownMenu.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        filterAllProjects.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
    public static int getCounterValue() {
        exportButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String counterText = counterProjects.getText();
        System.out.println("Число задач: " + counterText);
        return Integer.parseInt(counterText.substring(counterText.lastIndexOf(" ") + 1));
    }
    public static void clickCreateButton() {
        createButton.click();
    }
    public static void isOnCreateTaskPopAp() {
        titleCreateTaskPopAp.exists();
    }
    public static void clickCreateButtonMini() {
        createButtonMini.click();
    }
    public static void enterNameOfTopic(String username) {
        topicInput.setValue("Задача Задач1");
    }
    public static void initChekAllTaskAndFilters(){
        chekAllTaskAndFilters.shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
    public static void enterInputTaskSearch(String username) {
        inputTaskSearch.setValue("TestSeleniumATHomework");
    }
    public static void clickSearchButton() {
        searchButton.click();
    }
    public static String getStatusOfTaskValue() {
        statusOfTask.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String counterText1 = statusOfTask.getText();
        System.out.println("Статус задачи: " + counterText1);
        return counterText1;
    }
    public static String getStatusOfFixVersion() {
        statusOfFixVersion.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String counterText2 = statusOfFixVersion.getText();
        System.out.println("Исправить в версиях: " + counterText2);
        return counterText2;
    }
    public static void clickTypeButtonVisible() {
        typeButtonVisible.click();
    }
    public static void checkAndEnableButton() {
        typeButtonVisible.shouldBe(Condition.visible, Duration.ofSeconds(30));
        String ariaPressedValue = typeButtonVisible.getAttribute("aria-pressed");
        if (!"true".equals(ariaPressedValue)) {
            clickTypeButtonVisible();
        } else {
            System.out.println("Кнопка уже в нажатом состоянии");
        }
    }
    public static void selectTypeOfTask(){
        typeOfTaskComboBox.click();
        typeOfTaskComboBox.sendKeys(Keys.DELETE);
        typeOfTaskComboBox.setValue("Ошибка");
        typeOfTaskComboBox.sendKeys(Keys.ENTER);
    }
    public static void enterHeadInput(String username) {
        headInput.click();
        headInput.setValue("Здесь была ошибка");
    }
}
