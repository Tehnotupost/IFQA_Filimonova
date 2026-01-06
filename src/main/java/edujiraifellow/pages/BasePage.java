package edujiraifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public abstract class BasePage {
    protected void clickButton(SelenideElement button) {
        button.shouldBe(visible, Duration.ofSeconds(20))
                .click();
    }

    protected String getAnyText(SelenideElement anyText) {
        anyText.shouldBe(visible, Duration.ofSeconds(30));
        return anyText.getText();
    }

    public void deleteTextAndSetNewValue(SelenideElement anyInput, String newValue) {
        anyInput.click();
        anyInput.sendKeys(Keys.DELETE);
        anyInput.setValue(newValue);
        anyInput.sendKeys(Keys.ENTER);
    }
}
