package old;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Ignore
public class OlesiaAbdullinaTest extends BaseTest {

    @Ignore
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
}
