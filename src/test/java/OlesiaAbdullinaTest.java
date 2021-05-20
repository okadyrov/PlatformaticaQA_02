import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OlesiaAbdullinaTest {

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void testOlesiaAbdullina() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");

        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("russian songs");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search-icon-legacy']"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.id("contents"));
        Assert.assertTrue(searchResult != null);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
