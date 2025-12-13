package edujiraifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.CssValue;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TestPage {

    private static final SelenideElement filterDropdownMenu = $x("//button[@id='subnav-trigger']").as("Меню Переключить фильтр");
    private static final SelenideElement filterAllProjects = $x("//li[@original-title]/child::a[contains(text(),'Все задачи')]").as("Фильтр Все задачи в выпадающем меню");
    private static final SelenideElement subnavigationTitle = $x("//span[@class='subnavigator-title']").as("Подсказка к меню Переключить фильтр");
    private static final SelenideElement counterProjects = $x("//div[@class='showing']/child::span[contains(text(),'из')]").as("Счетчик");
    private static final SelenideElement createButton = $x("//li[@id='create-menu']/child::a[@id='create_link']").as("Кнопка Создать");
    private static final SelenideElement titleCreateTaskPopAp = $x("//h2[@title='Создание задачи']").as("Окно создания задачи");
    private static final SelenideElement typeOfTaskComboBox = $x("//input[@id='issuetype-field']").as("Тип задачи");
    private static final SelenideElement chekAllTaskAndFilters = $x("//div[@id='full-issue-navigator']/child::a[@href='/issues/']").as("Посмотреть все задачи и фильтры");
    public static final SelenideElement inputTaskSearch = $x("//input[@id='searcher-query']").as("Строка поиска по всем задачам");
    private static final SelenideElement searchButton = $x("//button[@original-title='Поиск задач']").as("Кнопка Поиск по всем задачам");
    private static final SelenideElement statusOfTask = $x("//span[@id='status-val']/child::span[@class]").as("Статус задачи");
    private static final SelenideElement statusOfFixVersion = $x("//span[@id='fixVersions-field']/child::a[@title]").as("Исправить в версиях");
    private static final SelenideElement topicInput = $x("//input[@id='summary']").as("Строка Тема");
    private static final SelenideElement createButtonMini = $x("//input[@id='create-issue-submit']").as("Кнопка Создать в попапе создания задачи");
    private static final SelenideElement createTaskNotif = $x("//div[@class='aui-flag']/child::div[contains(normalize-space(), 'успешно создан')]").as("Нотиф Запрос успешно создан");
    private static final SelenideElement projectName = $x("//input[@id='project-field']").as("Кнопка Проект");
    private static final SelenideElement typeButtonVisible = $x("//button[text()='Визуальный']").as("Кнопка Визуальный");
    private static final SelenideElement headInput = $x("//html[@style='height: auto;']/descendant::p").as("Описание");
    private static final SelenideElement fixInVersion2p0 = $x("//select[@id='fixVersions']/descendant::option[contains(text(),'Version 2.0')]").as("Исправить в версии 2.0");
    private static final SelenideElement priorityDropDown = $x("//input[@id='priority-field']").as("Приоритет");
    private static final SelenideElement labelsOfTask = $x("//textarea[@id='labels-textarea']").as("Метки");
    private static final SelenideElement processDropDown = $x("//span[contains(text(),'Бизнес-процесс')]").as("<Бизнес-процесс>");
    private static final SelenideElement processCloseBug = $x("//span[contains(text(),'Выполнено')]").as("Выполнено");
    private static final SelenideElement taskNameInTable = $x("//h1[@id='summary-val']").as("Выполнено");

    public boolean isOnTestPage() {
        statusOfFixVersion.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }

    public void applyFilterAllProjects() {
        filterDropdownMenu.shouldBe(visible, Duration.ofSeconds(30)).click();
        filterAllProjects.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    public String checkSubnavigationTitle() {
        subnavigationTitle.shouldBe(visible, Duration.ofSeconds(30));
        return subnavigationTitle.getText();
    }

    public int getCounterValue() {
        counterProjects.shouldBe(visible, Duration.ofSeconds(30));
        String counterText = counterProjects.getText();
        return Integer.parseInt(counterText.substring(counterText.lastIndexOf(" ") + 1));
    }

    public boolean waitCounterValueChange() {
        counterProjects.shouldBe(visible, Duration.ofSeconds(30));
        String counterTextStart = counterProjects.getText();
        counterProjects.shouldNotHave(Condition.text(counterTextStart.substring(counterTextStart.lastIndexOf(" ") + 1)), Duration.ofSeconds(30));
        return true;
    }

    public void clickCreateButton() {
        createButton.shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public boolean isOnCreateTaskPopAp() {
        titleCreateTaskPopAp.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }

    public void clickCreateButtonMini() {
        createButtonMini.shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void enterNameOfTopic(String topicName) {
        topicInput.shouldBe(visible, Duration.ofSeconds(10))
                .setValue(topicName);
    }

    public boolean getEnteredTopicName(String topicName) {
        topicInput.shouldHave(Condition.value(topicName));
        return true;
    }

    public void initChekAllTaskAndFilters() {
        chekAllTaskAndFilters.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    public void enterInputTaskSearch(String searchText) {
        inputTaskSearch.shouldBe(visible, Duration.ofSeconds(10))
                .setValue(searchText);
    }

    public void clickSearchButton() {
        searchButton.shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public String getStatusOfTaskValue() {
        statusOfTask.shouldBe(visible, Duration.ofSeconds(30));
        return statusOfTask.getText();
    }

    public String getStatusOfFixVersion() {
        statusOfFixVersion.shouldBe(visible, Duration.ofSeconds(30));
        return statusOfFixVersion.getText();
    }

    public void clickTypeButtonVisible() {
        typeButtonVisible.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public void checkAndEnableButton() {
        typeButtonVisible.shouldBe(visible, Duration.ofSeconds(30));
        String ariaPressedValue = typeButtonVisible.getAttribute("aria-pressed");
        if (!"true".equals(ariaPressedValue)) {
            clickTypeButtonVisible();
        } else {
            System.out.println("Кнопка уже в нажатом состоянии");
        }
    }

    public void selectProjectName(String nameOfProject) {
        projectName.click();
        projectName.sendKeys(Keys.DELETE);
        projectName.setValue(nameOfProject);
        projectName.sendKeys(Keys.ENTER);
    }

    public boolean isProjectSelected(String nameOfProject) {
        projectName.shouldHave(Condition.value(nameOfProject));
        return true;
    }

    public void selectTypeOfTask(String typeOfTask) {
        typeOfTaskComboBox.click();
        typeOfTaskComboBox.sendKeys(Keys.DELETE);
        typeOfTaskComboBox.setValue(typeOfTask);
        typeOfTaskComboBox.sendKeys(Keys.ENTER);
    }

    public boolean getSelectedTaskType(String typeOfTask) {
        typeOfTaskComboBox.shouldHave(Condition.value(typeOfTask));
        return true;
    }

    public void enterHeadInput(String bugDescription) {
        Selenide.switchTo().frame($("iframe"));
        try {
            headInput.shouldBe(visible).click();
            headInput.sendKeys(Keys.DELETE);
            headInput.setValue(bugDescription);
            headInput.sendKeys(Keys.ENTER);

        } finally {
            Selenide.switchTo().defaultContent();
        }
    }

    public void clickFixInVersion2p0() {
        fixInVersion2p0.shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void setPriorityDropDown() {
        priorityDropDown.click();
        priorityDropDown.sendKeys(Keys.ARROW_DOWN);
        priorityDropDown.sendKeys(Keys.ENTER);
    }

    public void putLabelsOfTask(String labelsOfTaskValue) {
        labelsOfTask.click();
        labelsOfTask.sendKeys(Keys.DELETE);
        labelsOfTask.setValue(labelsOfTaskValue);
        labelsOfTask.sendKeys(Keys.ENTER);
    }
    public boolean hasLabels(String labelsOfTaskValue) {
        labelsOfTask.shouldHave(Condition.text(labelsOfTaskValue), Duration.ofSeconds(20));
        return true;
    }

    public void selectTypeOfBug() {
        processDropDown.shouldBe(visible, Duration.ofSeconds(10)).click();
        processCloseBug.shouldBe(visible, Duration.ofSeconds(30)).click();
    }


    public boolean isSuccessNotificationDisplayed() {
        createTaskNotif.shouldBe(visible, Duration.ofSeconds(30));
        return true;
    }

    public boolean inputTaskSearchExists() {
        inputTaskSearch.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }

    public String getTaskNameInTable() {
        taskNameInTable.shouldBe(visible, Duration.ofSeconds(30));
        return taskNameInTable.getText();
    }
}