package edujiraifellow.motion;

import edujiraifellow.pages.OpenTaskTestPage;

public class SearchTask {
    private final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();

    public void searchTask(String searchingName) {
        openTaskTestPage.enterInputTaskSearch(searchingName);
        openTaskTestPage.clickSearchButton();
    }
}
