package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class OlgaElleTest extends BaseTest {

    @Ignore
    @Test
    public void test() throws InterruptedException {
        getDriver().get("https://www.yahoo.com/");

        WebElement input = getDriver().findElement(By.className("_yb_2e5c7"));
        input.sendKeys("flower duet from lakme\n");

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='web']/ol/li[3]/div/div[1]/h3/a")));
        //WebElement result = getDriver().findElement(By.className("MMgsKf"));

        Assert.assertEquals(result.getText(), "The Flower Duet (from \"Lakmé)[Lyric Video] - YouTube");
    }
}
