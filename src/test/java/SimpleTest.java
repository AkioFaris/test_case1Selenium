import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static core.TestsConstants.*;


public class SimpleTest {
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        /* Close Browser */
        driver.close();
    }

    @Test
    public void submitContactTest() {
        /* Open test site by URL */
        driver.navigate().to(TESTS_API_URI);

         /* Assert Browser title */
        Assert.assertEquals(driver.getTitle(), TITLE_INDEX_PAGE);

        /* Perform login */
        WebElement elCaret = driver.findElement(By.xpath("html/body/div[1]/header/div/nav/ul[2]/li/a"));
        elCaret.click();
        WebElement elLogin = driver.findElement(By.xpath(".//*[@id='Login']"));
        elLogin.sendKeys(PARAM_LOGIN);
        WebElement elPassword = driver.findElement(By.xpath(".//*[@id='Password']"));
        elPassword.sendKeys(PARAM_PASSWORD);
        WebElement submitBtn = driver.findElement(By.xpath("html/body/div[1]/header/div/nav/ul[2]/li/div/form/button"));
        submitBtn.click();

       /* Assert User name in the left-top side of screen that user is loggined */
        WebElement elUserName = driver.findElement(By.xpath("html/body/div[1]/header/div/nav/ul[2]/li/a/div/span"));
        Assert.assertTrue(elUserName.isDisplayed());
        Assert.assertEquals(elUserName.getAttribute("textContent"), USER_NAME);

        /* Open Contact form */
        WebElement elContactFrmBtn = driver.findElement(
                By.xpath("//*[@class = 'uui-navigation nav navbar-nav m-l8']//*[@href='page1.htm']"));
        elContactFrmBtn.click();

        /* Assert Browser title */
        Assert.assertEquals(driver.getTitle(), TITLE_CONTACT_FORM);

        /* Input first and last name in text fields and click submit button */
        WebElement elName = driver.findElement(By.xpath("//*[@id='Name']"));
        elName.sendKeys(PARAM_FIRST_NAME);
        WebElement elLastName = driver.findElement(By.xpath(".//*[@id='LastName']"));
        elLastName.sendKeys(PARAM_LAST_NAME);
        WebElement submitContactBtn = driver.findElement(By.xpath("html/body/div[1]/div/main/div[2]/div/form/div[3]/div[2]/button"));
        submitContactBtn.click();

        /* Assert that in the log section a new raw has displayed which contains text "submit" */
        WebElement elLog = driver.findElement(By.xpath("//ul[contains(@class, 'panel-body-list logs')]/li[1]\n"));
        Assert.assertTrue(elLog.isDisplayed());
        Assert.assertTrue(elLog.getAttribute("textContent").contains(LOG_TEXT));
    }
}
