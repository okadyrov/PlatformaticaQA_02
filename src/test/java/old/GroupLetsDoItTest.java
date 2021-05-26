package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class GroupLetsDoItTest extends BaseTest {

    @Test
    public void viktoriiaMarushevskaTargetTest() {
        getDriver().manage().deleteAllCookies();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        getDriver().get("https://www.target.com/");

        getDriver().findElement(By.id("search")).sendKeys("band aids");
        getDriver().findElement(By.xpath("//button[text()='go']")).click();
        getDriver().findElement(By.id("minPriceValue")).sendKeys("1");
        getDriver().findElement(By.id("maxPriceValue")).sendKeys("2");
        getDriver().findElement(By.xpath("//div[@class='Row-uds8za-0 fdXLni h-margin-v-tight']")).click();

        wait.until(ExpectedConditions.visibilityOf((getDriver()
                .findElement((By.linkText("Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™"))))))
                .click();

        String searchResultText = wait.until(ExpectedConditions.elementToBeClickable(getDriver()
                .findElement((By.xpath("//span[contains(text(), 'Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™')]")))))
                .getText();
        Assert.assertEquals(searchResultText, "Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™");
    }
}
