package edujiraifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import edujiraifellow.utils.CustomProperties;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenTaskTestPage extends BasePage {

    private final SelenideElement filterDropdownMenu = $x("//button[@id='subnav-trigger']").as("Меню Переключить фильтр");
    private final SelenideElement filterAllProjects = $x("//li[@original-title]/child::a[contains(text(),'Все задачи')]").as("Фильтр Все задачи в выпадающем меню");
    private final SelenideElement counterProjects = $x("//div[@class='showing']/child::span[contains(text(),'из')]").as("Счетчик");
    private final SelenideElement fastCreateTaskButton = $x("//button[contains(text(),'задачу')]").as("Быстрое создание задачи");
    private final SelenideElement fastCreateTextArea = $x("//textarea[@name='summary']").as("Строка ввода быстрого создания");
    private final SelenideElement createButton = $x("//li[@id='create-menu']/child::a[@id='create_link']").as("Кнопка Создать");
    private final SelenideElement chekAllTaskAndFilters = $x("//div[@id='full-issue-navigator']/child::a[@href='/issues/']").as("Посмотреть все задачи и фильтры");
    public final SelenideElement inputTaskSearch = $x("//input[@id='searcher-query']").as("Строка поиска по всем задачам");
    private final SelenideElement searchButton = $x("//button[@original-title='Поиск задач']").as("Кнопка Поиск по всем задачам");
    private final SelenideElement statusOfTask = $x("//span[@id='status-val']/child::span[@class]").as("Статус задачи");
    private final SelenideElement statusOfFixVersion = $x("//span[@id='fixVersions-field']/child::a[@title]").as("Исправить в версиях");
    private final SelenideElement processDropDown = $x("//span[contains(text(),'Бизнес-процесс')]").as("<Бизнес-процесс>");
    private final SelenideElement processCloseBug = $x("//span[contains(text(),'Выполнено')]").as("Выполнено");
    private final SelenideElement taskNameInTable = $x("//h1[@id='summary-val']").as("Название бага");

    public boolean isOnTestPage() {
        filterDropdownMenu.shouldBe(visible, Duration.ofSeconds(10));
        return true;
    }

    public void applyFilterAllProjects() {
        clickButton(filterDropdownMenu);
        clickButton(filterAllProjects);
    }

    public int getCounterValue() {
        String counterText = getAnyText(counterProjects);
        return Integer.parseInt(counterText.substring(counterText.lastIndexOf(" ") + 1));
    }

    public boolean waitCounterValueChange() {
        counterProjects.shouldNotHave(Condition.text(String.valueOf(getCounterValue())), Duration.ofSeconds(30));
        return true;
    }

    public int changeCounter() {
        int lastNumberBefore = getCounterValue();
        fastCreate();
        assertTrue(waitCounterValueChange(), "каунтер сменился");
        int lastNumberAfter = getCounterValue();
        return lastNumberAfter - lastNumberBefore;
    }

    public void clickFastCreateTaskButton() {
        clickButton(fastCreateTaskButton);
    }

    public void fastCreateTask(String name) {
        fastCreateTextArea.shouldBe(visible, Duration.ofSeconds(10)).setValue(name);
        fastCreateTextArea.sendKeys(Keys.ENTER);
    }

    public void fastCreate() {
        clickFastCreateTaskButton();
        fastCreateTask(CustomProperties.getProps().getProperty("REGULAR_TASK_NAME"));
    }

    public void clickCreateButton() {
        clickButton(createButton);
    }

    public void initChekAllTaskAndFilters() {
        clickButton(chekAllTaskAndFilters);
    }

    public void enterInputTaskSearch(String searchText) {
        inputTaskSearch.shouldBe(visible, Duration.ofSeconds(20)).setValue("").setValue(searchText);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }

    public String getStatusOfTaskValue() {
        return getAnyText(statusOfTask);
    }

    public boolean waitStatusOfTaskValueChange() {
        statusOfTask.shouldNotHave(Condition.text(getStatusOfTaskValue()), Duration.ofSeconds(30));
        return true;
    }

    public String getStatusOfFixVersion() {
        return getAnyText(statusOfFixVersion);
    }

    public void selectTypeOfBug() {
        clickButton(processDropDown);
        clickButton(processCloseBug);
    }

    public String getTaskNameInTable() {
        return getAnyText(taskNameInTable);
    }

    public boolean waitTaskNameInTableChange() {
        taskNameInTable.shouldNotHave(Condition.text(getTaskNameInTable()), Duration.ofSeconds(30));
        return true;
    }

    public void searchTask(String searchingName) {
        enterInputTaskSearch(searchingName);
        clickSearchButton();
    }
}