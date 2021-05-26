import base.BaseTest;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.ProjectUtils;

public class OKadyrovTest extends BaseTest {
    @Test
    public void testOkadyr(){
        getDriver().get("https://ref2.eteam.work/");
        ProjectUtils.login(getDriver());
        ProjectUtils.reset(getDriver());
        getDriver().manage().window().maximize();
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("window.scrollBy(0, 10000)");

        WebElement aprove =  getDriver().findElement(By.id("pa-menu-item-47"));
        aprove.click();

    }

}
