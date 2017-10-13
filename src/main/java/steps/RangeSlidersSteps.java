package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import task3.init_classes.TestUI;
import task3.page_objects.DatesPage;
import task3.page_objects.Header;

import static com.codeborne.selenide.Selenide.page;
import static task3.enums.Options.DATES;

public class RangeSlidersSteps extends TestUI {
    private Header header = page(Header.class);
    private DatesPage datesPage = page(DatesPage.class);

    @Given("^Open Dates Page$")
    public void openDatesPage() throws Throwable {
        header.openOptionPage(DATES);
    }

    @When("^Set left slider to (\\d+) and right slider to (\\d+)$")
    public void setLeftSliderToAndRightSliderTo(int arg0, int arg1) throws Throwable {
        datesPage.setSliders(arg0, arg1);
    }

    @Then("^Left slider should be set to (\\d+) and right slider should be set to (\\d+)$")
    public void leftSliderShouldBeSetToAndRightSliderShouldBeSetTo(int arg0, int arg1) throws Throwable {
        datesPage.checkSliders(arg0, arg1);

    }
}
