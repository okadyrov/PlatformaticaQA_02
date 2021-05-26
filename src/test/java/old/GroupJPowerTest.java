package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

@Ignore
public class GroupJPowerTest extends BaseTest {

    @Test
    public void testOlgaKogut() {
        getDriver().get("https://www.klubok.com/");

        WebElement input = getDriver().findElement(By.className("sub-input-search"));
        input.sendKeys("fisher price\n");

        List<WebElement> listOfElement = getDriver().findElements(
                By.xpath("//ul[contains(@class, 'item-list')]/li"));

        Assert.assertNotEquals(listOfElement.size(), 0);
    }
}
