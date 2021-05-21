import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupSquirrelsTest extends BaseTest {

    @Test
    public void testNYerlan() {
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
    public void testSergeiKhatskevitch() {
        getDriver().get("https://en.wikipedia.org/wiki/Website");
        WebElement result = getDriver().findElement(
                By.xpath("//*[@class='firstHeading']"));
        Assert.assertEquals(result.getText(), "Website");
    }

    @Ignore
    @Test
    public void testRichardGobal() {
        getDriver().get("https://www.iherb.com/");
        getDriver().findElement(By.className("iherb-header-search-input")).sendKeys("blueberry juice\n");
        getDriver().findElement(By.xpath("//*[@id=\"pid_7091\"]/div[2]/div[1]/a")).click();
        WebElement isItInStock = getDriver().findElement(By.xpath("//*[@id='stock-status']/strong"));
        Assert.assertEquals(isItInStock.getText(), "In Stock");
    }
}
