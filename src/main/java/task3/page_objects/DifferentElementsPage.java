package task3.page_objects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import task3.enums.Conditions;
import task3.enums.Colors;
import task3.enums.Metals;
import task3.init_classes.IPageObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPage implements IPageObject {

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioBtns;

    @FindBy(css = "div.colors")
    private SelenideElement dropdown;

    @FindBy(css = ".uui-form-element option")
    private ElementsCollection dropdownElements;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultBtn;

    @FindBy(css = "input.uui-button")
    private SelenideElement button;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    private RightSection rightSection = page(RightSection.class);

    @Step("Check existence of elements on Different Element Page")
    public void checkInterface() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }

        radioBtns.shouldHaveSize(4);
        for (SelenideElement radioBtn : radioBtns) {
            radioBtn.shouldBe(visible);
        }

        dropdown.shouldBe(visible);
        defaultBtn.shouldBe(visible);
        button.shouldBe(visible);
        leftSection.shouldBe(visible);
        rightSection.checkInterface();
    }

    @Step("Select condition {0}")
    public void selectCheckbox(Conditions checkboxLabel) {
        SelenideElement checkbox = checkboxes.get(checkboxLabel.ordinal());
        checkbox.setSelected(true);
    }

    @Step("Deselect condition {0}")
    public void deselectCheckbox(Conditions checkboxLabel) {
        SelenideElement checkbox = checkboxes.get(checkboxLabel.ordinal());
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        checkbox.setSelected(false);
    }

    @Step("Check if {0} condition is {1}")
    public void checkCheckbox(Conditions checkboxLabel, Boolean isSelected) {
        SelenideElement checkbox = checkboxes.get(checkboxLabel.ordinal());
        Assert.assertTrue(checkbox.isSelected() == isSelected);
    }

    @Step("Select metal {0}")
    public void selectRadio(Metals radioLabel) {
        SelenideElement radio = radioBtns.findBy(text(radioLabel.text));
        radio.setSelected(true);
    }

    @Step("Select color {0}")
    public void selectInDropdown(Colors dropdownLabel) {
        dropdown.click();
        SelenideElement dropdownElem = dropdownElements.findBy(text(dropdownLabel.text));
        dropdownElem.setSelected(true);
    }

    @Step("Verify that log section contains {0}")
    public void checkValueChanged(String subStr) {
        rightSection.logs.findBy(text(subStr)).shouldBe(visible);
    }

    @Step("Verify in log section that the condition {0} is {1} ")
    public void checkConditionChanged(String subStr, Boolean status) {
       rightSection.logs.findBy(text(subStr)).shouldHave(text(status.toString()));
    }
}
