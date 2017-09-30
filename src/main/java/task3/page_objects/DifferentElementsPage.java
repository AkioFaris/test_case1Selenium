package task3.page_objects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import task3.enums.CheckboxValues;
import task3.enums.DropdownValues;
import task3.enums.RadioValues;
import task3.init_classes.PageObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPage implements PageObject {

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioBtns;

    @FindBy(css = "div.colors")
    private SelenideElement dropdown;

    @FindBy(css = ".uui-form-element option")
    private ElementsCollection dropdownElements;

    @FindBy(css = "[name=\"Default Button\"]")
    private SelenideElement defaultBtn;

    @FindBy(css = "input.uui-button")
    private SelenideElement button;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection logs;

    @FindBy(css = ".info-panel-section")
    private SelenideElement rightSection;

    public void checkInterface() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement checkbox :
                checkboxes) {
            checkbox.shouldBe(visible);
        }

        radioBtns.shouldHaveSize(4);
        for (SelenideElement radioBtn :
                radioBtns) {
            radioBtn.shouldBe(visible);
        }

        dropdown.shouldBe(visible);

        defaultBtn.shouldBe(visible);

        button.shouldBe(visible);

        leftSection.shouldBe(visible);

        rightSection.shouldBe(visible);
    }

    public void selectCheckbox(CheckboxValues checkboxLabel) {
        SelenideElement checkbox = checkboxes.get(checkboxLabel.ordinal());
        checkbox.setSelected(true);
    }

    public void deselectCheckbox(CheckboxValues checkboxLabel) {
        SelenideElement checkbox = checkboxes.get(checkboxLabel.ordinal());
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        checkbox.setSelected(false);
    }

    public void checkCheckbox(CheckboxValues checkboxLabel, Boolean isSelected) {
        SelenideElement checkbox = checkboxes.get(checkboxLabel.ordinal());
        Assert.assertTrue(checkbox.isSelected() == isSelected);
    }

    public void selectRadio(RadioValues radioLabel) {
        SelenideElement radio = radioBtns.findBy(text(radioLabel.text));
        radio.setSelected(true);
    }

    public void selectInDropdown(DropdownValues dropdownLabel) {
        dropdown.click();
        SelenideElement dropdownElem = dropdownElements.findBy(text(dropdownLabel.text));
        dropdownElem.setSelected(true);
    }

    public void checkValueChanged(String subStr) {
        logs.findBy(text(subStr)).shouldBe(visible);
    }

    public void checkConditionChanged(String subStr, Boolean status) {
        logs.findBy(text(subStr)).shouldHave(text(status.toString()));
    }
}
