import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.SQLException;


public class OlgaMishinaTest extends BaseTest {

  @Test
  public void test() throws InterruptedException, SQLException {
      getDriver().get("https://www.zippershipper.com/");

        WebElement input = getDriver().findElement(By.xpath("//input[@id='txtRedirectSearchBox']"));
        input.sendKeys("Dress Zippers\n");

        WebElement linkZippersByUse = getDriver().findElement(By.cssSelector("[id='dlCategories_ctl01_hlCategory']"));

        Assert.assertTrue(linkZippersByUse.isDisplayed());
        linkZippersByUse.click();

        WebElement image = getDriver().findElement(By.xpath("(//img[@class ='CategoryProductThumbnail']) [1]"));

        Assert.assertTrue(image.isDisplayed());
      }
  }

