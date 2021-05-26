package old;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class StasChampionTest extends BaseTest {

    @Test
    public void test1StasChampion() throws InterruptedException {
        getDriver().get("https://google.com/");

        WebElement input = getDriver().findElement(By.className("gLFyf"));
        input.sendKeys("123\n");

        WebElement result = getDriver().findElement(
                By.xpath("//*[@id=\"wp-tabs-container\"]/div[1]/div/div/div/div/div/div/div[2]/h3/a/h3"));

        Assert.assertEquals(result.getText(), "Jess Glynne - 123 [Official Live Video] - YouTube");
    }

    @Test
    public void test2StasChampion() throws InterruptedException {
        getDriver().get("https://bukovel.com/en/");

        WebElement readMoreButton = getDriver().findElement(
                By.xpath("//div[@id='scaleContainer']/div/div/a[contains(text(), 'Read more')]"));
        readMoreButton.click();
        WebElement text = getDriver().findElement(By.xpath("//div[@class='inner-info-text ']"));
        Assert.assertEquals(text.getText(), "«ARTEK-BUKOVEL»: CAMP BOOKING HAS STARTED!");
    }
}
