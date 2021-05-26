package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class GroupJavaBearsTest extends BaseTest {

    @Test
    public void testMariaMorozova() {
        getDriver().get("https://www.duckduckgo.com");

        WebElement input = getDriver().findElement(By.className("search__input--adv"));
        input.sendKeys("panda\n");

        WebElement res = getDriver().findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]"));
        Assert.assertEquals(res.getText(), "Panda Express | A Fast Casual Chinese Restaurant | Panda ...");
    }

    @Test
    public void testSergeyKuznetsov() {
        getDriver().get("https://elibrary.unatlib.ru/");
        WebElement input = getDriver().findElement(By.className("prompt"));
        input.sendKeys("Пушкин\n");
        WebElement result = getDriver().findElement(By.className("search-stats"));
        Assert.assertNotEquals(result.getText(), "No Results!");
    }

    @Ignore
    @Test
    public void testAnastasiiaPotapenko() {
        getDriver().get("https://www.nps.gov/findapark/index.htm");

        WebElement searchIconButton = getDriver().findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']"));
        searchIconButton.click();
        WebElement searchField = getDriver().findElement(By.xpath("//input[@class = 'form-control multiselect-search']"));
        searchField.sendKeys("Yellowstone National Park\n");
        WebElement searchResult = getDriver().findElement(By.xpath("//li//label[text() = ' Yellowstone National Park']"));
        searchResult.click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//a[text() = 'Yellowstone' and @class = 'Hero-title ']")).isDisplayed());
    }

    @Test
    public void testAlexMack() {
        getDriver().get("https://www.fandango.com/");

        WebElement searchField = getDriver().findElement(By.className("fan-input"));
        searchField.sendKeys("nobody\n");
        WebElement movie = getDriver().findElement(By.className("results-thumb"));
        movie.click();
        Assert.assertTrue(getDriver().findElement(By.className("js-movie-video-link")).isDisplayed());
    }

    @Ignore
    @Test
    public  void testNataliaGrebeniuk() throws InterruptedException {
        getDriver().get("https://google.com/");
        WebElement input = getDriver().findElement(By.className("gLFyf"));
        input.sendKeys("123\n");
        WebElement result = getDriver().findElement(By.className("MMgsKf"));
        Assert.assertEquals(result.getText(), "Jess Glynne - 123 [Official Live Video] - YouTube");
    }

    @Test
    public void testYaraGrats() {
        getDriver().get("https://keepcalling.com/");
        WebElement countryInput = getDriver().findElement(By.xpath("//input[@id = 'destination']"));
        countryInput.sendKeys("Russia\n");
        WebElement countryRate = getDriver().findElement(By
                .xpath("//p[contains(@class,'h3 rate-top text-left')and contains(text(),'Russia')]"));
        Assert.assertEquals(countryRate.getText(),"Russia");
    }
}
