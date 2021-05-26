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
public class GroupAlmondSkyTest extends BaseTest {

    @Test
    public void testTatianaChueva()  {

        final String expectedResultPageHeader = "CONTACT US";

        getDriver().get("https://www.loganparkapartments.com/");

        WebElement popButtonClose = getDriver().findElement(By.xpath("//a[@id='popBtnClose']"));
        popButtonClose.click();

        WebElement pushMenu = getDriver().findElement(By.xpath("//div[@id='menuHeader']"));
        pushMenu.click();

        WebElement inputContactButton = getDriver().findElement(
                By.xpath("//div[@id='mainNavHeader']/ul[@id='menuElem']/li[@class='contact']/a[@href='/Contact.aspx']"));
        inputContactButton.click();

        WebElement pageHeader = getDriver().findElement(By.xpath("//h1[@class='pageHeader']"));
        String actualResultPageHeader = pageHeader.getText();

        Assert.assertEquals(actualResultPageHeader, expectedResultPageHeader);
    }

    @Test
    public void testLizaSh() {
        getDriver().get("https://www.cactusandtropicals.com/");

        WebElement button = getDriver().findElement(By.xpath("//a[text()='View our services.']"));
        button.click();

        WebElement result = getDriver().findElement(By.className("page-title"));

        Assert.assertEquals(result.getText(), "PLANT SERVICES");
    }
}
