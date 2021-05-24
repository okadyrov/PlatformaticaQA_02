import base.BaseTest;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.ProjectUtils;

public class CreateAndSaveNewRecordTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        getDriver().get("https://ref2.eteam.work/");

        ProjectUtils.login(getDriver());
        ProjectUtils.reset(getDriver());
        getDriver().get("https://ref2.eteam.work/index.php?action=action_list&entity_id=32&mod=2");
        wait.until(ExpectedConditions.elementToBeClickable(getDriver()
                .findElement(By.xpath("//i[contains(text(),'create_new_folder')]"))))
                .click();

       // todo simple test
    }
}

