package task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestWithAnnotations {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        String driverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void beforeTest() {
        if (driver.toString().contains("null"))
            driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void afterTest() {
       System.out.println(System.currentTimeMillis());
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }


    @Test
    public void verifyTitle1() {
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }
}
