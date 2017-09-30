package task3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task3.enums.Options;
import task3.init_classes.TestUI;
import task3.page_objects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static task3.enums.CheckboxValues.WATER;
import static task3.enums.CheckboxValues.WIND;
import static task3.enums.DropdownValues.YELLOW;
import static task3.enums.Options.*;
import static task3.enums.RadioValues.SELEN;
import static task3.enums.TestConstants.API_URI;
import static task3.enums.UserData.USER;

public class TestUIElements extends task3.init_classes.TestUI {
    private LoginForm loginForm;
    private Header header;
    private HomePage homePage;
    private LeftSection leftSection;
    private DifferentElementsPage diffElementsPage;

    @BeforeMethod
    public void before() {
        loginForm = page(LoginForm.class);
        header = page(Header.class);
        homePage = page(HomePage.class);
        leftSection = page(LeftSection.class);
        diffElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void checkUIWithPageObjects() {
        /* Open test site by URL */
        open(API_URI.text);

        /* Perform login */
        loginForm.login(USER.login, USER.password);

        /* Assert User name in the left-top side of screen that user is loggined */
        checkText(loginForm.getProfile(), USER.name);

        /* Check interface on Home page, it contains all needed elements. */
        homePage.checkInterface();

        /* Click on "Service" subcategory in the header and check that drop down contains options */
        header.checkServiceOptions();

        /* Click on Service subcategory in the left section and check that drop down contains options */
        leftSection.checkServiceOptions();

        /* Open through the header menu Service -> Different Elements PageObject */
        header.openOptionPage(DIFF_EL);

        /* Check interface on Service page, it contains all needed elements. */
        diffElementsPage.checkInterface();

        /* Select and assert checkboxes */
        diffElementsPage.selectCheckbox(WATER);
        diffElementsPage.checkCheckbox(WATER, true);
        diffElementsPage.selectCheckbox(WIND);
        diffElementsPage.checkCheckbox(WIND, true);

        /* Select radio */
        diffElementsPage.selectRadio(SELEN);

        /* Select in dropdown */
        diffElementsPage.selectInDropdown(YELLOW);

        /* Check in logs section selected values and status (true|false) */
        diffElementsPage.checkConditionChanged(WATER.text, true);
        diffElementsPage.checkConditionChanged(WIND.text, true);
        diffElementsPage.checkValueChanged(SELEN.text);
        diffElementsPage.checkValueChanged(YELLOW.text);

        /* Deselect and assert checkboxes */
        diffElementsPage.deselectCheckbox(WATER);
        diffElementsPage.checkCheckbox(WATER, false);
        diffElementsPage.deselectCheckbox(WIND);
        diffElementsPage.checkCheckbox(WIND, false);

        /* Check in logs section unselected values and status (true|false) */
        diffElementsPage.checkConditionChanged(WATER.text, false);
        diffElementsPage.checkConditionChanged(WIND.text, false);
    }
}
