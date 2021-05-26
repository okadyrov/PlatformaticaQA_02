package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class DariaAltukhovaTest extends BaseTest {

    final String mainURL = "https://www.edcast.com/";
    final String demoUrl = "https://www.edcast.com/corp/request-a-demo/";

    @Ignore
    @Test
    public void testDariaAltukhovaOpenDemoFromPage()  {
        getDriver().get(mainURL);

        WebElement productButton = getDriver().findElement(By.id("menu-item-442"));
        productButton.click();

        WebElement dropdownEdCastXP = getDriver().findElement(By.id("menu-item-46"));
        dropdownEdCastXP.click();

        WebElement requestDemoButton = getDriver().findElement(By.className("fl-button-text"));
        requestDemoButton.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), demoUrl);
    }

    @Ignore
    @Test
    public void testDariaAltukhovaOpenDemoFromMenu()  {
        getDriver().get(mainURL);
        WebElement demoHeaderButton = getDriver().findElement(By.id("menu-item-6658"));
        demoHeaderButton.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), demoUrl);
    }

    @Test
    public void testDariaAltukhovaDemoVideoButton()  {
        getDriver().get(mainURL);
        WebElement watchEdcastDemoVideoButton = getDriver().findElement(By.className("fl-button"));
        watchEdcastDemoVideoButton.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://go.edcast.com/l/139221/2021-03-31/2m9x9x");
    }
}
