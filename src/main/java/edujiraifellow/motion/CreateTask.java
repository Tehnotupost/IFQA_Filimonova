package edujiraifellow.motion;

import edujiraifellow.pages.CreateTaskTestPage;
import edujiraifellow.pages.OpenTaskTestPage;
import edujiraifellow.utils.CustomProperties;

public class CreateTask {
    private static final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();
    private static final CreateTaskTestPage createTaskTestPage = new CreateTaskTestPage();

    public void fastCreate() {
        openTaskTestPage.clickFastCreateTaskButton();
        openTaskTestPage.fastCreateTask(CustomProperties.getProps().getProperty("REGULAR_TASK_NAME"));
    }

    public void longCreate() {
        openTaskTestPage.clickCreateButton();
        createTaskTestPage.checkAndEnableButton();
        createTaskTestPage.selectProjectName(CustomProperties.getProps().getProperty("NAME_OF_PROJECT"));
        createTaskTestPage.selectTypeOfTask(CustomProperties.getProps().getProperty("TYPE_OF_TASK"));
        createTaskTestPage.enterNameOfTopic(CustomProperties.getProps().getProperty("BUG_TASK_NAME"));
        createTaskTestPage.enterHeadInput(CustomProperties.getProps().getProperty("BUG_DESCRIPTION"));
        createTaskTestPage.clickFixInVersion2p0();
        createTaskTestPage.setPriorityDropDown();
        createTaskTestPage.putLabelsOfTask(CustomProperties.getProps().getProperty("LABELS_oF_TASK_VALUE"));
        createTaskTestPage.clickCreateButtonMini();
    }
}
