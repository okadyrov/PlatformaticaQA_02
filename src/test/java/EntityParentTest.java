import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.ProjectUtils;

public class EntityParentTest extends BaseTest {

    @Test
    public void testCreateNewRecord() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);

        getDriver().get("https://ref2.eteam.work/");

        ProjectUtils.login(getDriver());
        ProjectUtils.reset(getDriver());

        getDriver().get("https://ref2.eteam.work/index.php?action=action_list&entity_id=57&mod=2");

        wait.until(ExpectedConditions.elementToBeClickable(getDriver()
        .findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/div/div[1]/a/div/i"))))
                .click();

    }
}