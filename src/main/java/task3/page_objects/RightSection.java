package task3.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import task3.init_classes.IPageObject;

import static com.codeborne.selenide.Condition.*;

class RightSection implements IPageObject {
    @FindBy(css = ".panel-body-list.logs li")
    public ElementsCollection logs;

    @FindBy(css = ".info-panel-section")
    public SelenideElement section;

    public void checkInterface() {
        section.shouldBe(visible);
    }
}
