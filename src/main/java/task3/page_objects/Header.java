package task3.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import task3.enums.Options;
import task3.init_classes.IMenu;

public class Header implements IMenu {
    @FindBy(css = "a.dropdown-toggle span")
    private SelenideElement serviceCaret;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceOptions;

    @Step("Open {0} page.")
    public void openOptionPage(Options option) {
        serviceCaret.click();
        serviceOptions.findBy(Condition.text(option.text)).click();
    }

    @Step("Check that Service subcategory dropdown from Header  contains options.")
    public void checkServiceOptions() {
        serviceCaret.click();
        for (SelenideElement option :
                serviceOptions) {
            option.shouldBe(Condition.visible);
        }

        for (Options option : Options.values()) {
            serviceOptions.find(Condition.text(option.text)).shouldBe(Condition.visible);
        }
    }
}
