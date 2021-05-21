import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GalinaKTest extends BaseTest {

    @Test
    public void testGalinaK() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);

        getDriver().get("https://www.cabq.gov/parksandrecreation/recreation/swimming/indoor-pools");

        getDriver().findElement(
                By.xpath("//div[@id='parent-fieldname-text']/div/div/p/a[@data-val='e8f7542fb4e0de27b3ea4a0e73a708a5']")
        ).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div [@id = 'parent-fieldname-text']/div/div/p[9]/strong")));
        String address = getDriver().findElement(By.xpath("//div [@id = 'parent-fieldname-text']/div/div/p[9]")).getText();

        Assert.assertEquals(address, "Location:\n" +
                "6705 Fortuna NW\n" + "Albuquerque, NM 87121\n" + "Map");
    }
}
