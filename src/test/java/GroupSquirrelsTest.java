import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupSquirrelsTest extends BaseTest {

    @Test
    public void nYerlan() {

        getDriver().get("https://www.zoni.edu/");
        getDriver().findElement(By.xpath("//*[@id=\"menu-item-11815\"]/a")).click();
        getDriver().findElement(By.xpath("//*[@id=\"panel-10867-1-1-0\"]/div/div/a/img")).click();
        WebElement txtStandardProgram = getDriver().findElement(By.xpath("//*[@id=\"panel-19455-0-0-0\"]/div/h3"));
        Assert.assertEquals(txtStandardProgram.getText(),"Standard English Program");
    }

    @Test
    public void testOlgaVergasova() {
        getDriver().get("https://apnews.com/hub/sports");
        WebElement list = getDriver().findElement(By.xpath("//*[@data-key=\"hub-title\"]"));
        String result = list.getText();
        Assert.assertEquals(result, "SPORTS");
    }

    @Test
    public void testSergeiKhatskevitch() throws InterruptedException {
        getDriver().get("https://en.wikipedia.org/wiki/Website");
        WebElement result = getDriver().findElement(
                By.xpath("//*[@class='firstHeading']"));
        Assert.assertEquals(result.getText(), "Website");
    }

    @Test
    public void testRichardGobal() throws InterruptedException {
        getDriver().get("https://www.iherb.com/");
        getDriver().findElement(By.className("iherb-header-search-input")).sendKeys("blueberry juice\n");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@id=\"pid_7091\"]/div[2]/div[1]/a")).click();
        Thread.sleep(1000);
        WebElement isItInStock = getDriver().findElement(By.xpath("//*[@id='stock-status']/strong"));
        Thread.sleep(1000);
        Assert.assertEquals(isItInStock.getText(), "In Stock");
    }
}
