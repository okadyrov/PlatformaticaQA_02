import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GroupLetsDoItTest extends BaseTest {

    @Ignore
    @Test
    public void viktoriiaMarushevskaTargetTest() {
        getDriver().manage().deleteAllCookies();
        getDriver().get("https://www.target.com/");

        getDriver().findElement(By.id("search")).sendKeys("band aids");
        getDriver().findElement(By.xpath("//button[text()='go']")).click();
        getDriver().findElement(By.linkText("Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™")).click();

        String searchResultText = getDriver().findElement(By.xpath("//span[contains(text(), 'Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™')]")).getText();
        Assert.assertEquals(searchResultText, "Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™");
    }
}
