package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelTestWithDataProvider {
    @DataProvider(parallel = true)
    public Object[][] correctData() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM projec"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};
    }

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    }

    @Test(dataProvider = "correctData")
    public void verifyTextsUnderPictures(int index, String correctText) {
        String apiUrl = "https://jdi-framework.github.io/tests";

        /* Open test site by URL */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(apiUrl);

        /* Find element and check text */
        WebElement element = driver.findElements(By.cssSelector(".benefit-txt")).get(index);
        String elText = element.getText();
        Assert.assertEquals(elText, correctText);

        /* Close Browser */
        driver.close();
    }
}
