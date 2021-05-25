import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.ProjectUtils;


public class EntityEventsChain1Test extends BaseTest {

    @Test
    public void testCreateNewRecord() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);

        getDriver().get("https://ref2.eteam.work/");

        ProjectUtils.login(getDriver());
        ProjectUtils.reset(getDriver());

        getDriver().get("https://ref2.eteam.work/index.php?action=action_list&entity_id=61&mod=2");

        wait.until(ExpectedConditions.elementToBeClickable(getDriver()
                .findElement(By.xpath("//i[text() = 'create_new_folder']"))))
                .click();
    }
}
