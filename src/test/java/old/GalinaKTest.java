package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class GalinaKTest extends BaseTest {

    @Ignore
    @Test
    public void testGalinaK() {

        getDriver().get("https://www.cabq.gov/parksandrecreation/recreation/swimming/indoor-pools");

        getDriver().findElement(
                By.xpath("//div[@id='parent-fieldname-text']/div/div/p/a[@data-val='e8f7542fb4e0de27b3ea4a0e73a708a5']")
        ).click();

        WebElement address = getDriver().findElement(
                By.xpath("//p[text() = '6705 Fortuna NW']"));

        Assert.assertEquals(address.getText(), "Location:\n" +
                "6705 Fortuna NW\n" +
                "Albuquerque, NM 87121\n" +
                "Map");
    }
}
