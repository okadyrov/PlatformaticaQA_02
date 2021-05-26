package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class TatianaKTest extends BaseTest {

    @Test
    public void testTanyaKraskova() {
        getDriver().get("https://www.selenium.dev/");
        getDriver().findElement(By.xpath("//header/nav[@id='navbar']/div[1]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'About')]")).click();
        WebElement pageTitleWE = getDriver().findElement(By.xpath("//h1[contains(text(),'About Selenium')]"));
        String pageTitle = pageTitleWE.getText();
        Assert.assertEquals(pageTitle, "About Selenium");
    }
}
