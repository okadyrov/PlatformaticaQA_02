package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class IlyaVTest extends BaseTest {

    @Ignore
    @Test
    public void test() {
        getDriver().get("https://www.gismeteo.ru");

        WebElement input = getDriver().findElement(By.className("search_input"));
        input.sendKeys("Екатеринбург");
        input.sendKeys(Keys.ENTER);

        WebElement link = getDriver().findElement(By.linkText("Екатеринбург"));
        link.click();

        WebElement twoWeeks = getDriver().findElement(By.xpath("/html/body/section/nav/div/ul/li[6]/a"));
        twoWeeks.click();

        WebElement heading = getDriver().findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div/div[1]/div/h1"));
        Assert.assertEquals(heading.getText(), "Погода в Екатеринбурге на две недели");
    }
}
