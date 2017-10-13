package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import task3.init_classes.TestUI;
import task3.page_objects.DifferentElementsPage;
import task3.page_objects.Header;
import task3.page_objects.HomePage;
import task3.page_objects.LeftSection;

import static com.codeborne.selenide.Selenide.page;
import static task3.enums.Colors.YELLOW;
import static task3.enums.Conditions.WATER;
import static task3.enums.Conditions.WIND;
import static task3.enums.Metals.SELEN;
import static task3.enums.Options.DIFF_EL;

public class DifferentElementsSteps extends TestUI {
    private Header header = page(Header.class);
    private HomePage homePage = page(HomePage.class);
    private LeftSection leftSection = page(LeftSection.class);
    private DifferentElementsPage diffElementsPage = page(DifferentElementsPage.class);

    @Given("^Open Different Element Page$")
    public void openDatesPage(){
        header.openOptionPage(DIFF_EL);
    }

    @Given("^Check interface on Home page$")
    public void checkInterfaceOnHomePage(){
        homePage.checkInterface();
    }

    @Then("^Check service options in Header$")
    public void checkServiceOptionsInHeader(){
        header.checkServiceOptions();

    }

    @And("^Check service options in Left Section$")
    public void checkServiceOptionsInLeftSection(){
        leftSection.checkServiceOptions();
    }

    @And("^Check existence of elements$")
    public void checkExistenceOfElements(){
        diffElementsPage.checkInterface();
    }

    @When("^Select and assert checkboxes$")
    public void selectAndAssertCheckboxes(){
        diffElementsPage.selectCheckbox(WATER);
        diffElementsPage.checkCheckbox(WATER, true);
        diffElementsPage.selectCheckbox(WIND);
        diffElementsPage.checkCheckbox(WIND, true);
    }

    @And("^Select radio$")
    public void selectRadio(){
        diffElementsPage.selectRadio(SELEN);
    }

    @And("^Select in dropdown$")
    public void selectInDropdown(){
        diffElementsPage.selectInDropdown(YELLOW);
    }

    @Then("^Check in log selected values and statuses$")
    public void checkInLogSelectedValuesAndStatuses(){
        diffElementsPage.checkConditionChanged(WATER.text, true);
        diffElementsPage.checkConditionChanged(WIND.text, true);
        diffElementsPage.checkValueChanged(SELEN.text);
        diffElementsPage.checkValueChanged(YELLOW.text);
    }

    @When("^Deselect and assert checkboxes$")
    public void deselectAndAssertCheckboxes(){
        diffElementsPage.deselectCheckbox(WATER);
        diffElementsPage.checkCheckbox(WATER, false);
        diffElementsPage.deselectCheckbox(WIND);
        diffElementsPage.checkCheckbox(WIND, false);
    }

    @Then("^Check in log unselected values and statuses$")
    public void checkInLogUnselectedValuesAndStatuses(){
        diffElementsPage.checkConditionChanged(WATER.text, false);
        diffElementsPage.checkConditionChanged(WIND.text, false);
    }
}
