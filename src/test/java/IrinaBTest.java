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

public class IrinaBTest {
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
    public void testIrinaB(){
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement actualResult = driver.findElement(By.xpath("//div[@id='main']/h2"));

        Assert.assertEquals(actualResult.getText(), "Welcome to 99 Bottles of Beer");
    }

    @Test
    public void testIrinaB2() throws InterruptedException {
        driver.get("https://us.etrade.com/home");

        WebElement tradingMenuLink = driver.findElement(
                By.xpath("//ul[@id='menu']/li/a/span[text()='Trading']"));
        tradingMenuLink.click();
        Thread.sleep(2000);

        WebElement openAccountLinkText = driver.findElement(By.linkText("Open an account"));
        openAccountLinkText.click();

        Thread.sleep(2000);
        WebElement chooseYourOption = driver.findElement(By.xpath("//input[@id='BROKERAGE']"));

        Assert.assertTrue(chooseYourOption.isSelected());

        driver.findElement(By.xpath("//div/button[text()='Continue']")).click();

        WebElement chooseBrokerageAccountTypeText = driver.findElement(By.xpath("//div/h1"));

        Assert.assertEquals(chooseBrokerageAccountTypeText.getText(), "Choose account type");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
