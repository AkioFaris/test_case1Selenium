package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelTestWithDataProvider {
    @DataProvider(parallel = true)
    public Object[][] correctData() {
        return new Object[][]{
                {"(//SPAN[@class='benefit-txt'])[1]", "To include good practices\nand ideas from successful\nEPAM projec"},
                {"(//SPAN[@class='benefit-txt'])[2]", "To be flexible and\ncustomizable"},
                {"(//SPAN[@class='benefit-txt'])[3]", "To be multiplatform"},
                {"(//SPAN[@class='benefit-txt'])[4]",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};
    }

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    }

    @Test(dataProvider = "correctData")
    public void verifyTextsUnderPictures(String xpath, String correctText) {
        String TESTS_API_URI = "https://jdi-framework.github.io/tests";

        /* Open test site by URL */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(TESTS_API_URI);

        /* Find element and check text */
        WebElement element = driver.findElement(By.xpath(xpath));
        String elText = element.getText();
        Assert.assertEquals(elText, correctText);

        /* Close Browser */
        driver.close();
    }
}
