package task3.page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import task3.enums.Options;
import task3.init_classes.Menu;

import static task3.enums.Options.*;

public class Header implements Menu {
    @FindBy(css = "a.dropdown-toggle span")
    private SelenideElement serviceCaret;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceOptions;

    public void openOptionPage(Options option)
    {
        serviceCaret.click();
        serviceOptions.findBy(Condition.text(option.text)).click();
    }

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
