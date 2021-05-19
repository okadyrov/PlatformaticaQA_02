import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class SergeiDTest extends BaseTest {

	@Test
	public void test() throws InterruptedException {
		getDriver().get("https://google.com/");

		WebElement input = getDriver().findElement(By.className("gLFyf"));
		input.sendKeys("123\n");

		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("MMgsKf")));
		//WebElement result = getDriver().findElement(By.className("MMgsKf"));

		Assert.assertEquals(result.getText(), "Jess Glynne - 123 [Official Live Video] - YouTube");
	}
}
