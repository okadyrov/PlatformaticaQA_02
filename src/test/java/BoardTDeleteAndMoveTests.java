import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ProjectUtils;

import java.util.UUID;

public class BoardTDeleteAndMoveTests extends BaseTest {

    private final String TEXT_VALUE = UUID.randomUUID().toString();
    private final String INTEGER_VALUE = "" + (int) Math.random();
    private final String DECIMAL_VALUE = "" + Math.random();

    @Test
    public void boardDeleteTest() throws InterruptedException {

        getDriver().get("https://ref2.eteam.work/");
        getDriver().manage().window().maximize();

        ProjectUtils.login(getDriver());

        Thread.sleep(4000);

        WebElement deleteRecentRecord = getDriver().findElement(By.xpath("//a[@id = 'navbarDropdownProfile']"));
        deleteRecentRecord.click();

        WebElement pushDelete = getDriver().findElement(By.xpath("//a[text() ='!!! Reset all for my user !!!']"));
        pushDelete.click();

        Thread.sleep(2000);

        WebElement elementForMouse = getDriver().findElement(By.xpath("//*[@id=\"menu-list-parent\"]/ul/li[10]/a/p"));

        Actions action = new Actions(getDriver());
        Action mouseOverHome = action.moveToElement(elementForMouse).build();
        mouseOverHome.perform();
        elementForMouse.click();

        WebElement boardIcon = getDriver().findElement(By.xpath("//i[contains(text(), 'create_new_folder')]"));
        boardIcon.click();

        WebElement textField = getDriver().findElement(By.xpath("//textarea[@name = 'entity_form_data[text]']"));
        textField.sendKeys(TEXT_VALUE);

        WebElement integerField = getDriver().findElement(By.xpath("//input[@name = 'entity_form_data[int]']"));
        integerField.sendKeys(INTEGER_VALUE);

        WebElement decimalField = getDriver().findElement(By.xpath("//input[@name = 'entity_form_data[decimal]']"));
        decimalField.sendKeys(DECIMAL_VALUE);

        WebElement datetimeField = getDriver().findElement(By.xpath("//input[@id = 'datetime']"));
        datetimeField.click();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement saveButtonClick = getDriver().findElement(By.xpath("//button[@id = 'pa-entity-form-save-btn']"));
        js.executeScript("arguments[0].scrollIntoView();", saveButtonClick);
        saveButtonClick.click();

        WebElement listButton = getDriver().findElement(By.xpath("//a[@href = 'index.php?action=action_list&list_type=table&entity_id=31']"));
        listButton.click();

        WebElement actionsButton = getDriver().findElement(By.xpath("//button[@class = 'btn btn-round btn-sm btn-primary dropdown-toggle']"));
        actionsButton.click();

        Thread.sleep(2000);

        WebElement deleteRecord = getDriver().findElement(By.xpath("//*[@id=\"pa-all-entities-table\"]/tbody/tr/td[10]/div/ul/li[2]/a"));
        deleteRecord.click();
    }

    @Test
    public void boardRestoreDeletedTest() throws InterruptedException {

        getDriver().get("https://ref2.eteam.work/");
        getDriver().manage().window().maximize();

        ProjectUtils.login(getDriver());

        Thread.sleep(4000);

        WebElement deleteRecentRecord = getDriver().findElement(By.xpath("//a[@id = 'navbarDropdownProfile']"));
        deleteRecentRecord.click();

        Thread.sleep(2000);

        WebElement pushDelete = getDriver().findElement(By.xpath("//a[text() ='!!! Reset all for my user !!!']"));
        pushDelete.click();

        Thread.sleep(2000);

        WebElement elementForMouse = getDriver().findElement(By.xpath("//*[@id=\"menu-list-parent\"]/ul/li[10]/a/p"));

        Actions action = new Actions(getDriver());
        Action mouseOverHome = action.moveToElement(elementForMouse).build();
        mouseOverHome.perform();
        elementForMouse.click();

        WebElement boardIcon = getDriver().findElement(By.xpath("//i[contains(text(), 'create_new_folder')]"));
        boardIcon.click();

        WebElement textField = getDriver().findElement(By.xpath("//textarea[@name = 'entity_form_data[text]']"));
        textField.sendKeys(TEXT_VALUE);

        WebElement integerField = getDriver().findElement(By.xpath("//input[@name = 'entity_form_data[int]']"));
        integerField.sendKeys(INTEGER_VALUE);

        WebElement decimalField = getDriver().findElement(By.xpath("//input[@name = 'entity_form_data[decimal]']"));
        decimalField.sendKeys(DECIMAL_VALUE);

        WebElement datetimeField = getDriver().findElement(By.xpath("//input[@id = 'datetime']"));
        datetimeField.click();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement saveButtonClick = getDriver().findElement(By.xpath("//button[@id = 'pa-entity-form-save-btn']"));
        js.executeScript("arguments[0].scrollIntoView();", saveButtonClick);
        saveButtonClick.click();

        WebElement listButton = getDriver().findElement(By.xpath("//a[@href = 'index.php?action=action_list&list_type=table&entity_id=31']"));
        listButton.click();

        WebElement actionsButton = getDriver().findElement(By.xpath("//button[@class = 'btn btn-round btn-sm btn-primary dropdown-toggle']"));
        actionsButton.click();

        Thread.sleep(2000);

        WebElement deleteRecord = getDriver().findElement(By.xpath("//*[@id=\"pa-all-entities-table\"]/tbody/tr/td[10]/div/ul/li[3]/a"));
        deleteRecord.click();

        Thread.sleep(4000);

        WebElement deleteOutline = getDriver().findElement(By.xpath("//i[text() = 'delete_outline']"));
        deleteOutline.click();

        Thread.sleep(2000);

        WebElement restoreDraft = getDriver().findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[4]/a"));
        restoreDraft.click();
    }
}