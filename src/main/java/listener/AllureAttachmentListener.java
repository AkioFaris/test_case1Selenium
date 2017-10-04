package listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureAttachmentListener
        extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    private void makeScreenshot() {
        byte[] array = {1};
        try {
            ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenshot();
    }
    /**/
}

