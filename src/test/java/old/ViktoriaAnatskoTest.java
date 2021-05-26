package old;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class ViktoriaAnatskoTest extends BaseTest {

    @Test
    public void testViktoriaAnatsko() {
        getDriver().get("https://oz.by/");
        WebElement input = getDriver().findElement(By.id("top-s"));
        input.sendKeys("карандаш\n");
        WebElement result = getDriver().findElement(By
                .xpath("//*[@id=\"goods-table\"]/li[1]/div/div/div/div/a/p[1]"));
        Assert.assertEquals(result.getText(), "Карандаш чернографитный с ластиком \"Party Blackline\" (HB)");
    }
}
