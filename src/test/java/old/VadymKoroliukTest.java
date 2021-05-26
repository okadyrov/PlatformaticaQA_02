package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class VadymKoroliukTest extends BaseTest {

    @Test
    public void testVadymKoroliuk() {
        getDriver().get("https://www.newegg.com/");

        WebElement input = getDriver().findElement(By.xpath("//*[@id=\"app\"]/header/div[1]/div[3]/div[1]/form/div/div[1]/input"));
        input.sendKeys("ssd");
        WebElement button = getDriver().findElement(By.cssSelector("#app > header > div.header2020-inner > div.header2020-search >" +
                " div.header2020-search-bar > form > div > div.header2020-search-button > button"));
        button.click();
        WebElement title = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/h1"));

        Assert.assertEquals("\"SSD\"", title.getText());

    }
}
