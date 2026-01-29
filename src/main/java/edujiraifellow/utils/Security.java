package edujiraifellow.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Security {
    public static void setPassword(SelenideElement element, String password) {
        Selenide.executeJavaScript("""
                arguments[0].value = arguments[1];
                arguments[0].dispatchEvent(new Event('input', { bubbles: true }));
                arguments[0].dispatchEvent(new Event('change', { bubbles: true }));
                """, element, password);
    }

    public static void clear(SelenideElement element) {
        Selenide.executeJavaScript(
                "arguments[0].value='';", element
        );
    }
}
