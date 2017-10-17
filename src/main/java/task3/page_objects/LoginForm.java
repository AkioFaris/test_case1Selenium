package task3.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;


public class LoginForm {
    @FindBy(css = ".fa-user")
    private SelenideElement caret;

    @FindBy(css = "#Login")
    private SelenideElement userLogin;

    @FindBy(css = "#Password")
    private SelenideElement password;

    @FindBy(css = ".fa-sign-in")
    private SelenideElement submit;

    @FindBy(css = ".profile-photo span")
    private SelenideElement profile;

    @Step("Login as {0} with password: {1}.")
    public void login(String user, String pass) {
        caret.click();
        userLogin.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }

    @Step
    public void verifyUserName(String username) {
        profile.shouldHave(exactText(username));
    }
}
