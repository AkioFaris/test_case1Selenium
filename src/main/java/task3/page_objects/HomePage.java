package task3.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import task3.init_classes.PageObject;

public class HomePage implements PageObject {
    @FindBy(css = ".benefit-icon")
    private ElementsCollection pictures;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection picLabels;

    @FindBy(css = ".main-title")
    private SelenideElement title;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    public void checkInterface() {
        pictures.shouldHaveSize(4);
        picLabels.shouldHaveSize(4);
        for (SelenideElement pic :
                pictures) {
            pic.shouldBe(Condition.visible);
        }
        for (SelenideElement label :
                picLabels) {
            label.shouldBe(Condition.visible);
        }
        title.shouldBe(Condition.visible);
        mainText.shouldBe(Condition.visible);
    }
}
