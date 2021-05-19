import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KorikUmanTest extends BaseTest {

    @Test
    public void testOneVkorenevskyy() throws InterruptedException {

        getDriver().get("https://ultimateqa.com/");

        WebElement input = getDriver().findElement(By.xpath("//*[@href='https://ultimateqa.com/selenium-webdriver-java-course/']"));
        input.click();

        boolean result = getDriver().findElement(By.className("et_pb_video_overlay_hover")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void testTwoVkorenevskyy() throws InterruptedException {

        WebElement searchField = getDriver().findElement(By.xpath("//*[@name='s'][@class='et_pb_s']"));

        searchField.sendKeys("Selenium Java\n");

        WebElement result = getDriver().findElement(By.className("jetpack-instant-search__search-results-title"));

        String expected = "Found 10 results";
        String actual = result.getText();

        Assert.assertEquals(actual, expected);
    }
}

