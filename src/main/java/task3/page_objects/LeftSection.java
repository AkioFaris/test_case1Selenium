package task3.page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static task3.enums.Options.*;

public class LeftSection {
    @FindBy(css = "[class='fa fa-caret-down arrow']")
    private SelenideElement serviceCaret;

    @FindBy(css = "ul.sub a")
    private ElementsCollection serviceOptions;

    @Step("Check that Service subcategory dropdown from Left Section contains options.")
    public void checkServiceOptions() {
        serviceCaret.click();
        for (SelenideElement option :
                serviceOptions) {
            option.shouldBe(Condition.visible);
        }
        serviceOptions.shouldHave(CollectionCondition.texts(SUPPORT.text, DATES.text,
                COMPL_TBL.text, SIMP_TBL.text, PAGES_TBL.text, DIFF_EL.text));
    }

}
