package edujiraifellow.motion;

import edujiraifellow.pages.OpenTaskTestPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeCounter {
        private static final OpenTaskTestPage openTaskTestPage = new OpenTaskTestPage();

        public int changeCounter(){
            int lastNumberBefore = openTaskTestPage.getCounterValue();
            CreateTask CreateTask = new CreateTask();
            CreateTask.fastCreate();
            assertTrue(openTaskTestPage.waitCounterValueChange(), "каунтер сменился");
            int lastNumberAfter = openTaskTestPage.getCounterValue();
            return lastNumberAfter-lastNumberBefore;
        }
    }
