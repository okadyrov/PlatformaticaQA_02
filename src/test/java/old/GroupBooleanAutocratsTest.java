package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class GroupBooleanAutocratsTest extends BaseTest {
    @Ignore
    @Test
    public void UlianaShutaTest() {

        String expected = "Computer Science";

        getDriver().get("https://www.uchicago.edu/");

        WebElement search = getDriver().findElement(By.id("search-trigger"));
        search.click();

        WebElement inputSearch = getDriver().findElement(By.id("searchtext"));
        inputSearch.sendKeys("Computer Science");

        WebElement searchButton = getDriver().findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();

        WebElement result = getDriver().findElement(By.xpath("//div[@class='col12']/h1/strong"));

        Assert.assertEquals(expected, result.getText());
    }

    @Test
    public void testVictoriaRus() {

        final String result = "FILTERS";

        getDriver().get("https://www.zara.com/us/");

        getDriver().findElement(By.xpath("//*[@id=\"theme-app\"]/div/div/header/div/div[2]/div/div/a/span[1]/span")).click();

        WebElement searchField = getDriver().findElement(By.id("search-products-form-combo-input"));
        searchField.click();
        searchField.sendKeys("Black Dress",Keys.ENTER);

        WebElement outcome = getDriver().findElement(By.xpath("//*[@id=\"main\"]/article/div/div/div[1]/div[2]/div[2]/button/span"));

        Assert.assertEquals(result, outcome.getText());
    }

    @Test
    public void testPonomid() throws InterruptedException {
        String email = "opiijohno@gmail.com";
        getDriver().get("https://earnon.social");

        WebElement signInButton = getDriver().findElement(By.xpath("/html/body/div[1]/menu/div/div[2]/a[1]"));
        signInButton.click();

        getDriver().findElement(By.id("username")).sendKeys(email);
        getDriver().findElement(By.id("password")).sendKeys("Smmtool88");

        WebElement continueButton = getDriver().findElement(By.xpath("/html/body/div/main/section/div/div/div/form/div[2]/button"));
        continueButton.click();
        Thread.sleep(4000);

        WebElement closeButton = getDriver().findElement(By.xpath("/html/body/div[2]/div[3]/div/button"));
        closeButton.click();

        WebElement profileOnHeaderButton = getDriver().findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div[1]/div/div/button[3]"));
        profileOnHeaderButton.click();

        WebElement fieldEmailWeb = getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/header/div[2]/p"));
        String fieldEmail = fieldEmailWeb.getText();

        Assert.assertEquals(fieldEmail, email);
    }

    @Test
    public void testAlekseiMaslo() {

        final String expResultText = "desk";

        getDriver().get("https://www.ikea.com/us/en/");

        WebElement inputField = getDriver().findElement(By.name("q"));
        inputField.sendKeys("desk");

        WebElement searchButton = getDriver().findElement(By.id("search-box__searchbutton"));
        searchButton.click();

        WebElement surveyText = getDriver().findElement(By.xpath("//section/fieldset/legend"));

        Assert.assertTrue(surveyText.getText().contains(expResultText));
    }
}
