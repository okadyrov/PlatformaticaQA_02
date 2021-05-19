import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WedReviewIZTest extends BaseTest {

//    Thread.sleep();
//    Implicit
//    Explicit
//    Fluent

    @Test
    public void reviewTest() throws InterruptedException{

        getDriver().get("https://www.cnn.com/");
        getDriver().findElement(By.xpath("//article[@data-vr-contentbox = " +
                "'https://www.cnn.comt/world/live-news/coronavirus-pandemic-vaccine-updates-05-19-21/h_da'")).click();


        String text = getDriver().findElement(By.id("unpinned_div")).getText();
        Assert.assertEquals(text, "Tokyo 2020: High ranking Japanese official does not rule out cancellation of Olympics ");

    }
}
