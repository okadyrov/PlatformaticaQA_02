package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class KorikUmanTest extends BaseTest {

    @Test
    public void testOneVkorenevskyy() {

        getDriver().get("https://ultimateqa.com/");

        WebElement input = getDriver().findElement(By.xpath("//*[@href='https://ultimateqa.com/selenium-webdriver-java-course/']"));
        input.click();

        boolean result = getDriver().findElement(By.className("et_pb_video_overlay_hover")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void testTwoVkorenevskyy() {

        getDriver().get("https://ultimateqa.com/");

        WebElement searchField = getDriver().findElement(By.xpath("//*[@name='s'][@class='et_pb_s']"));

        searchField.sendKeys("Selenium Java\n");

        WebElement result = getDriver().findElement(By.className("jetpack-instant-search__search-results-title"));

        String expected = "Found 10 results";
        String actual = result.getText();

        Assert.assertEquals(actual, expected);
    }
}

