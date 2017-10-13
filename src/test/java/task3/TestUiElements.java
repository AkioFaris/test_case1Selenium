package task3;

import listener.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import task3.init_classes.TestUI;
import task3.page_objects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static task3.enums.Conditions.WATER;
import static task3.enums.Conditions.WIND;
import static task3.enums.Colors.YELLOW;
import static task3.enums.Options.*;
import static task3.enums.Metals.SELEN;
import static task3.enums.TestConstants.API_URI;
import static task3.enums.UserData.USER;

@Listeners(AllureAttachmentListener.class)
public class TestUiElements extends TestUI {
    private LoginForm loginForm;
    private Header header;
    private HomePage homePage;
    private LeftSection leftSection;
    private DifferentElementsPage diffElementsPage;

    @BeforeClass
    public void before() {
        loginForm = page(LoginForm.class);
        header = page(Header.class);
        homePage = page(HomePage.class);
        leftSection = page(LeftSection.class);
        diffElementsPage = page(DifferentElementsPage.class);
    }

    @Title("Test UI elements on Different Element Page")
    @Description("This test verifies the existence of elements and " +
            "checks work of checkboxes, of radio buttons and of the dropdown.")
    @Test
    public void checkUIWithPageObjects() {
        //1 Open test site by URL
        open(API_URI.text);

        //2 Perform login
        loginForm.login(USER.login, USER.password);

        //3 Assert User name in the left-top side of screen that user is loggined
        checkText(loginForm.getProfile(), USER.name);

        //4 Check interface on Home page, it contains all needed elements.
        homePage.checkInterface();

        //5 Click on "Service" subcategory in the header and check that dropdown contains options
        header.checkServiceOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        leftSection.checkServiceOptions();

        //7 Open through the header menu Service -> Different Elements IPageObject
        header.openOptionPage(DIFF_EL);

        //8 Check interface on Different Element Page, it contains all needed elements.
        diffElementsPage.checkInterface();

        //9 Select and assert checkboxes
        diffElementsPage.selectCheckbox(WATER);
        diffElementsPage.checkCheckbox(WATER, true);
        diffElementsPage.selectCheckbox(WIND);
        diffElementsPage.checkCheckbox(WIND, true);

        //10 Select radio
        diffElementsPage.selectRadio(SELEN);

        //11 Select in dropdown
        diffElementsPage.selectInDropdown(YELLOW);

        //12 Check in logs section selected values and statuses (true|false)
        diffElementsPage.checkConditionChanged(WATER.text, true);
        diffElementsPage.checkConditionChanged(WIND.text, true);
        diffElementsPage.checkValueChanged(SELEN.text);
        diffElementsPage.checkValueChanged(YELLOW.text);

        //13 Deselect and assert checkboxes
        diffElementsPage.deselectCheckbox(WATER);
        diffElementsPage.checkCheckbox(WATER, false);
        diffElementsPage.deselectCheckbox(WIND);
        diffElementsPage.checkCheckbox(WIND, false);

        //14 Check in logs section unselected values and statuses (true|false)
        diffElementsPage.checkConditionChanged(WATER.text, false);
        diffElementsPage.checkConditionChanged(WIND.text, false);
    }
}
