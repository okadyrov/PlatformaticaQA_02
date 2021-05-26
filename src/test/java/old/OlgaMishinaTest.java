package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class OlgaMishinaTest extends BaseTest {

    @Ignore
    @Test
    public void testOlgaMishina() {
        getDriver().get("https://www.zippershipper.com/");

        WebElement input = getDriver().findElement(By.xpath("//input[@id='txtRedirectSearchBox']"));
        input.sendKeys("Dress Zippers\n");

        WebElement linkZippersByUse = getDriver().findElement(By.cssSelector("[id='dlCategories_ctl01_hlCategory']"));

        Assert.assertTrue(linkZippersByUse.isDisplayed());
        linkZippersByUse.click();

        WebElement image = getDriver().findElement(By.xpath("(//img[@class ='CategoryProductThumbnail']) [1]"));

        Assert.assertTrue(image.isDisplayed());
    }
}
