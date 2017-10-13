package listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AllureAttachmentListener extends TestListenerAdapter {

    @Step("Make a screenshot")
    @Attachment(value = "Attachment: {0}", type = "image/png")
    private byte[] makeScreenshot() {

        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenshot();
    }

}
