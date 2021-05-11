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

public class GroupAllaTest {

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
    public void gunchenkoAlexTest() throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement input = driver.findElement(By.className("gLFyf"));

        input.sendKeys("gismeteo\n");

        //    WebElement result = driver.findElement(By.xpath("//h3[text() =  '222 год — Википедия']"));
        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));
        Assert.assertEquals(result1.getText(), "GISMETEO: Погода в Украине, прогноз погоды на сегодня ...");
        WebElement GismeteoButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));

        GismeteoButton.click();
        // find field search
        WebElement searchField = driver.findElement(By.id("js-search"));

        //  write name region
        searchField.sendKeys("Харьков\n");


        // click on region

        driver.findElement(By.xpath("/html/body/section/div[2]/div/section[2]/div/div/div[1]/a[1]")).click();

        driver.findElement(By.xpath("/html/body/section/nav/div/ul/li[6]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/section/nav/div/ul/li[7]/a")).click();
        WebElement pageTitile = driver.findElement(By.tagName("h1"));
        String pageTitleName = pageTitile.getText();
        Assert.assertEquals(pageTitleName, "Погода в Харькове на месяц");
        Thread.sleep(4000);
    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}


