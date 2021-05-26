package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class SergeyIschenkoTest extends BaseTest {

    @Ignore
    @Test
    public void testSergeIschenko() {
        getDriver().get("https://www.safeway.com/");

        WebElement input = getDriver().findElement(By.id("skip-main-content"));
        input.click();
        input.sendKeys("milk\n");

        WebElement product = getDriver().findElement(By.id("pg136010121"));
        product.click();

        WebElement productName = getDriver().findElement(By.tagName("h1"));

        Assert.assertEquals(productName.getText(), "Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.");
    }
}