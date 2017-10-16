package task3.init_classes;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;

public abstract class TestUI {
    protected TestUI() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "CHROME";
        Configuration.startMaximized = true;
    }

    protected void checkText(SelenideElement elem, String text) {
        elem.shouldHave(exactText(text));
    }
}
