package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class AlexFranchukTest extends BaseTest {

    @Test
    public void testAliakseiFranchuk() {

        getDriver().get("https://belaruspartisan.by/");
        getDriver().manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,10000)");

        WebElement approve = getDriver().findElement(By.xpath("//tr/td[2]/span/a[1]"));

        Assert.assertEquals(approve.getText(), "belpartisan@gmail.com");
    }
}