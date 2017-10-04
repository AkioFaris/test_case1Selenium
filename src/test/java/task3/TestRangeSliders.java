package task3;

import listener.AllureAttachmentListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import task3.init_classes.TestUI;
import task3.page_objects.DatesPage;
import task3.page_objects.Header;
import task3.page_objects.LoginForm;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static task3.enums.Options.DATES;
import static task3.enums.TestConstants.API_URI;
import static task3.enums.UserData.USER;

@Listeners(AllureAttachmentListener.class)
public class TestRangeSliders extends TestUI {
    private LoginForm loginForm;
    private Header header;
    private DatesPage datesPage;

    @BeforeMethod
    public void before() {
        loginForm = page(LoginForm.class);
        header = page(Header.class);
        datesPage = page(DatesPage.class);
    }

    @Title("Test range sliders")
    @Description("In this test range sliders on Dates page will be set to different positions.")
    @Test
    public void checkUIWithPageObjects() {
        /* Open test site by URL */
        open(API_URI.text);

        /* Perform login */
        loginForm.login(USER.login, USER.password);

        /* Assert User name in the left-top side of screen that user is loggined */
        checkText(loginForm.getProfile(), USER.name);

        /*Open Service -> Dates*/
        header.openOptionPage(DATES);

        /*left sliders - the most left position, right slider - the most right position*/
        datesPage.setSliders(0, 100);
        datesPage.checkSliders(0, 100);

        /*left sliders - the most left position, right slider - the most left position.*/
        datesPage.setSliders(0, 0);
        datesPage.checkSliders(0, 0);

        /*left sliders - the most right position, right slider - the most right position.*/
        datesPage.setSliders(100, 100);
        datesPage.checkSliders(100, 100);

        /*Using drag-and-drop set Range sliders.*/
        datesPage.setSliders(30, 70);
        datesPage.checkSliders(30, 70);
    }
}
