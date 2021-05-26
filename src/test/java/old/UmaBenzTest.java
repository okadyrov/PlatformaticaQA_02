package old;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class UmaBenzTest {

    @BeforeClass
    public void before() {WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Ignore
    @Test
    public void testUmaBenz() throws InterruptedException {

        driver.get("https://www.bmcc.cuny.edu");
        driver.findElement(By.id("menu-item-259")).click();
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.id("menu-item-21636"));
        text.click();
        WebElement pageTitleWE = driver.findElement(By.tagName("h1"));
        String pageTitle = pageTitleWE.getText();
        Assert.assertEquals(pageTitle, "Evening/Weekend Programs");
    }

    @AfterMethod
    public void afterTest() { driver.quit();
    }
}
