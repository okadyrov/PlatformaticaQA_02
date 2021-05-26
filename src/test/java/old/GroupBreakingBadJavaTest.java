package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestUtils;

@Ignore
public class GroupBreakingBadJavaTest extends BaseTest {

    public static void flash(WebElement element, WebDriver driver) {
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 5; i++) {
            changColor("#000000", element, driver);
            changColor(bgcolor, element, driver);
        }
    }

    public static void changColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor= '" + color + "' ", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong.");
        }
    }

    @Test
    public void testDudeAlexSoccer() {
        getDriver().get("https://services.smartbear.com/samples/TestComplete14/smartstore/");
        WebElement elemSoccer = getDriver().findElement(By.xpath("//*[@title='Soccer']"));
        flash(elemSoccer, getDriver());
        getDriver().findElement(By.xpath("//*[@title='Soccer']")).click();

        WebElement elem = getDriver().findElement(By.id("content-center"))
                                .findElement(By.tagName("h1"));
        flash(elem, getDriver());
        Assert.assertEquals(elem.getText(), "Soccer");
    }

    @Test
    public void testDudeAlexSoccerFlash() {
        getDriver().get("https://services.smartbear.com/samples/TestComplete14/smartstore/");
        WebElement elemSoccer = getDriver().findElement(By.xpath("//*[@title='Soccer']"));
        flash(elemSoccer, getDriver());
        elemSoccer.click();

        WebElement elem = getDriver().findElement(By.id("content-center"))
                                .findElement(By.tagName("h1"));
        flash(elem, getDriver());
        Assert.assertEquals(elem.getText(), "Soccer");
    }

    @Test
    public void testDariaRazzhigaeva(){
        getDriver().get("https://arc.losrios.edu/");
        getDriver().findElement(By.linkText("About Us")).click();

        WebElement element = getDriver().findElement(By.linkText("Contact Us"));
        TestUtils.scroll(getDriver(), element);

        WebElement address = getDriver().findElement(By.className("address_link"));
        Assert.assertTrue(address.getText().contains("4700 College Oak Drive"));
    }

    @Test
    public void testVitaliiArtemenkoFood() {
        getDriver().get("https://lightlife.com/");
        getDriver().findElement(By.xpath("//a[text()='Our Food'][1]")).click();
        WebElement food = getDriver().findElement(By.tagName("h1"));
        Assert.assertEquals(food.getText(), "Our Food");
    }

    @Test
    public void testEvgeniyTMainGitCommand() {
        getDriver().get("https://use-web.ru/news.php?id=138&tid=3");
        WebElement result = getDriver().findElement(By.xpath("//h2[text()= 'Основные Git команды. ']"));

        Assert.assertEquals(result.getText(), "Основные Git команды.");
    }
    @Ignore
    @Test
    public void testLenaDik(){

        getDriver().get("https://lafitness.com/Pages/Default.aspx#");

        WebElement element = getDriver().findElement(By.id("ctl00_GlobalHeader_txtZip"));
        element.sendKeys("20878\n");
        WebElement clubName = getDriver().findElement(By.id("ctl00_MainContent_repClubInfo_ctl01_lblClubDisplayName"));

        Assert.assertEquals(clubName.getText(), "Gaithersburg - Copley Place");
    }

    @Ignore
    @Test
    public void testAntonBrutTrip() {
        getDriver().get("https://www.nationalgeographic.com/");

        getDriver().findElement(By.xpath("//button[@aria-label='Menu']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(), 'Book A Trip')]")).click();

        getDriver().findElement(By.xpath("//div/span[contains(text(), 'Destination')]")).click();
        WebElement northAmerica = getDriver().findElement(By.id("react-select-2--option-9"));
        northAmerica.click();

        getDriver().findElement(By.xpath("//div/span[contains(text(), 'Trip Type')]")).click();
        WebElement train = getDriver().findElement(By.id("react-select-3--option-6"));
        train.click();

        getDriver().findElement(By.xpath("//div/span[contains(text(), 'Departure Month')]")).click();
        WebElement august2021 = getDriver().findElement(By.id("react-select-4--option-1"));
        august2021.click();

        getDriver().findElement(By.xpath("//span[contains(text(), 'Search Trips')]")).click();

        WebElement tripTitle = getDriver().findElement(By.className("ngs-exp-search--facet-header"));
        Assert.assertEquals(tripTitle.getText(), "Find a Trip");
    }

    @Ignore
    @Test
    public void vadymKarpychTest() {
        getDriver().get("https://www.wholefoodsmarket.com/");

        WebElement input = getDriver().findElement(By.xpath("//span[contains(text(),'Find a Store')]"));
        input.click();

        WebElement input2 = getDriver().findElement(By.id("store-finder-search-bar"));
        input2.sendKeys("Sacramento");
        input2.click();

        WebElement output = getDriver().findElement(By.xpath("//a[contains(text(),'Sacramento')]"));

        Assert.assertEquals(output.getText(), "Sacramento");
    }

    @Ignore
    @Test
    public void testViktoriaKPark() {
        getDriver().get("https://www.nps.gov/index.htm");
        WebElement input = getDriver().findElement(By.className("js-toggle"));
        input.sendKeys("\n haleakala \n");
        getDriver().get("https://www.nps.gov/hale/index.htm");
        WebElement moreButton = getDriver().findElement(By.id("anch_20"));
        moreButton.click();
        WebElement planVisit = getDriver().findElement(By
                .xpath("/html/body/div[11]/div[3]/div/div[2]/div[1]/h1"));
        Assert.assertEquals(planVisit.getText(), "Plan Your Visit");
    }
}
