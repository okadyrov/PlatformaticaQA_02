import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ProjectUtils;
import utils.TestUtils;
import constants.EntityBoardConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EntityBoardTest extends BaseTest {

    public void moveToElementAction(WebDriver driver) {
        Actions builder = new Actions(driver);
        WebElement searchField = driver.findElement(By.xpath(EntityBoardConstants.LINK_BOARD_ICON));
        TestUtils.scroll(driver, searchField);
        builder.moveToElement(searchField);
        builder.click(driver.findElement(By.xpath(EntityBoardConstants.LINK_BOARD_ENTITY)));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }

    public void addEmptyCardToList(WebDriver driver) {
        WebElement searchFieldAddCard = driver.findElement(By.xpath(EntityBoardConstants.BOARD_ADD_CARD_BY_XPATH));
        searchFieldAddCard.click();
        WebElement buttonSave = driver.findElement(By.id(EntityBoardConstants.BOARD_BUTTON_SAVE_BY_ID));
        TestUtils.scroll(driver, buttonSave);
        buttonSave.click();
    }

    public void toggleActionToList (WebDriver driver) {
        WebElement toggleActionToList = driver.findElement(By.xpath(EntityBoardConstants.BOARD_TOGGLE_LIST_ACTION_BY_XPATH));
        toggleActionToList.click();
    }

    public void deleteAction(WebDriver driver) throws InterruptedException {
        WebElement buttonAction = driver.findElement(By.cssSelector(EntityBoardConstants.BOARD_ACTION_BUTTON_BY_CSS));
        buttonAction.click();
        WebElement deleteAction = driver.findElement(By.xpath(EntityBoardConstants.BOARD_ACTION_DELETE_BY_XPATH));
        Thread.sleep(500);
        deleteAction.click();
    }

    public void goToRecyclingBin(WebDriver driver) {
        WebElement recyclingBin = driver.findElement(By.xpath(EntityBoardConstants.BOARD_RECYCLING_BIN_ICON_BY_XPATH));
        recyclingBin.click();
    }

    public void recyclingBinDeletePermanently(WebDriver driver) {
        WebElement deletePermanently = driver.findElement(By.xpath(EntityBoardConstants.RECYCLING_BIN_DELETE_PERMANENTLY_BY_XPATH));
        deletePermanently.click();
    }

    public int checkCountOfRecords(WebDriver driver) {
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        return rows.size();
    }

    public int countInRecyclingBin(WebDriver driver) {
        WebElement element = driver.findElement(By.cssSelector("span.notification"));
        int count = Integer.parseInt(element.getText());
        return count;
    }

    @Test
    public void testEntityBoardDeleteRecordAt002_01() throws InterruptedException {

        ProjectUtils.start(getDriver());

        moveToElementAction(getDriver());

        addEmptyCardToList(getDriver());
        addEmptyCardToList(getDriver());
        toggleActionToList(getDriver());

        int countOfRecordsBeforeDelete = checkCountOfRecords(getDriver());

        deleteAction(getDriver());

        int countOfRecordsAfterDelete = checkCountOfRecords(getDriver());
        int count = countOfRecordsBeforeDelete - countOfRecordsAfterDelete;
        Assert.assertEquals(count, 1);

        int countInRecyclingBinBefore = countInRecyclingBin(getDriver());
        deleteAction(getDriver());
        int countInRecyclingBinAfter = countInRecyclingBin(getDriver());
        int countInRB = countInRecyclingBinBefore - countInRecyclingBinAfter;
        Assert.assertEquals(countInRB, -1);

    }

    @Test
    public void testEntityBoardDeleteRecordFromRecyclingBinAt002_02() throws InterruptedException {

        ProjectUtils.start(getDriver());

        moveToElementAction(getDriver());

        addEmptyCardToList(getDriver());
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addEmptyCardToList(getDriver());
        toggleActionToList(getDriver());

        deleteAction(getDriver());
        deleteAction(getDriver());

        goToRecyclingBin(getDriver());

        int countInRecyclingBinBefore = countInRecyclingBin(getDriver());
        int countOfRecordsInRBBeforeDelete = checkCountOfRecords(getDriver());

        recyclingBinDeletePermanently(getDriver());

        int countInRecyclingBinAfter = countInRecyclingBin(getDriver());
        int countInRB = countInRecyclingBinBefore - countInRecyclingBinAfter;
        Assert.assertEquals(countInRB, 1);

        int countOfRecordsInRBAfterDelete = checkCountOfRecords(getDriver());
        int count = countOfRecordsInRBBeforeDelete - countOfRecordsInRBAfterDelete;
        Assert.assertEquals(count, 1);

    }
}

