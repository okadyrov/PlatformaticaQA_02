package old;

import base.BaseTest;
import org.apache.hc.core5.annotation.Internal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

@Ignore
public class KarinaSarukhanovaTest extends BaseTest {

    @Test
    public void test() {

        getDriver().get("https://www.gamestop.com/");

        WebElement input = getDriver().findElement(By.name("q"));
        input.sendKeys("motherboard\n");

        List<WebElement> result = getDriver().findElements(By.cssSelector("div.less-tile-info .link-name"));
        for (int i = 0; i < result.size(); i++) {
            String text = result.get(i).getText();
            Assert.assertTrue(text.contains("Motherboard"));
        }
    }
}
