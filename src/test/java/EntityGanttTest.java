import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ProjectUtils;
import utils.TestUtils;

public class EntityGanttTest extends BaseTest {

    @Test
    public void testCreateaNewRecordAndSave() {

        ProjectUtils.start(getDriver());

        WebElement ganttTab = getDriver().findElement(By.xpath("//p[contains (text(), 'Gantt')]"));
        TestUtils.scrollClick(getDriver(), ganttTab);

        getDriver().findElement(By.xpath("//div/i[.='create_new_folder']")).click();
        getDriver().findElement(By.id("string")).sendKeys("Test");
        getDriver().findElement(By.id("text")).sendKeys("Text");
        getDriver().findElement(By.id("int")).sendKeys("100");
        getDriver().findElement(By.id("decimal")).sendKeys("0.1");
        getDriver().findElement(By.id("date")).click();
        getDriver().findElement(By.id("datetime")).click();
        getDriver().findElement(By.id("pa-entity-form-save-btn")).click();

        WebElement checkRecord = getDriver().findElement(By.className("e-treecolumn-container"));
        Assert.assertEquals(checkRecord.getText(), "1");
    }
}
