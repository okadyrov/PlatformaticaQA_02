package old;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class YakovGTest {
    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Ignore
    @Test
    public void test() {
        driver.get("https://www.sportsmans.com/");

        WebElement input = driver.findElement(By.id("js-site-search-input"));
        input.sendKeys("FN Five SeveN Pistol\n");

        WebElement result = driver.findElement(By.xpath("//h2/a[@data-product-id=\"p41796\"]"));

        Assert.assertEquals(result.getText(), "FN Five SeveN Pistol");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
