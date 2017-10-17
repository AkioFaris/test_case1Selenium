package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import task3.init_classes.TestUI;
import task3.page_objects.DatesPage;
import task3.page_objects.Header;
import task3.page_objects.LoginForm;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static task3.enums.TestConstants.API_URI;
import static task3.enums.UserData.USER;

public class LoginSteps extends TestUI {
    private final LoginForm loginForm = page(LoginForm.class);
    private Header header = page(Header.class);
    private DatesPage datesPage = page(DatesPage.class);

    @Given("^Open browser$")
    public void openBrowser() throws Throwable {
        open(API_URI.text);
    }

    @When("^Open login form and perform login$")
    public void openLoginFormAndPerformLogin() throws Throwable {
        loginForm.login(USER.login, USER.password);
    }

    @Then("^I should be on the user home page and check username$")
    public void iShouldBeOnTheUserHomePageAndCheckUsername() throws Throwable {
        loginForm.verifyUserName(USER.name);
    }
}
