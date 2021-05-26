package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Random;

@Ignore
public class GroupStepInJavaTeamTest extends BaseTest {

    @Test
    public void testKirillRazzhigaev() {

        getDriver().get("https://www.selenium.dev/");
        getDriver().findElement(By.xpath("//nav/a[3]")).click();
        getDriver().findElement(By.id("search-by")).sendKeys("element");
        getDriver().findElement(By.xpath("//div[@data-title=\"Web element\"]")).click();
        Assert.assertEquals(getDriver().findElement(By.tagName("h1")).getText(), "Web element");
    }

    @Test
    public void testMarianaLuchynets() {

        getDriver().get("https://www.cvs.com/");
        WebElement checkTestingOptionsButton = getDriver().findElement(By.xpath("//a[contains(text(),'Check testing options')]"));
        checkTestingOptionsButton.click();
        WebElement updatesFromCdcArrow = getDriver().findElement(By.xpath("//strong[contains(text(),'Get COVID-19 vaccine updates from the CDC')]"));
        updatesFromCdcArrow.click();
        WebElement possibleSideEffectsListItem = getDriver().findElement(By.xpath("//a[contains(text(),'Possible side effects')]"));
        possibleSideEffectsListItem.click();
        WebElement possibleSideEffectsText = getDriver().findElement(By.xpath("//h3[contains(text(),'To reduce pain and discomfort where you got the shot')]"));
        Assert.assertEquals(possibleSideEffectsText.getText(), "To reduce pain and discomfort where you got the shot");
    }

    @Ignore
    @Test
    public void testVitalyZverev() {

        final String value = "Selenium";

        getDriver().get("https://ya.ru/");
        getDriver().findElement(By.xpath("//span[@class='input__box']/input")).sendKeys(value + "\n");
        WebElement result = getDriver().findElement(By.xpath("//div[contains(@class, 'serp-title_font')]"));

        Assert.assertEquals(result.getText(), value);
    }

    @Ignore
    @Test
    public void testAleksAn() {
        getDriver().get("http://automationpractice.com/index.php");
        getDriver().manage().window().maximize();
        getDriver().findElement(By.id("search_query_top")).sendKeys("dresses");
        getDriver().findElement(By.name("submit_search")).click();
        List<WebElement> elementList = getDriver().findElements(By.xpath("//ul[contains(@class, 'product_list')]/li"));
        Assert.assertEquals(elementList.size(), 7);
    }

    @Test
    public void testVladVysotski() {

        getDriver().get("https://www.paypal.com/");
        getDriver().manage().window().maximize();

        WebElement button = getDriver().findElement(By.xpath("//*[@id='signup-button']"));
        button.click();

        String text = getDriver().findElement(By.xpath("//*[@id=\"main\"]/section/div/div/h1")).getText();
        Assert.assertEquals(text, "PayPal is a secure, easy way to pay and get paid - sign up for free");
    }

    @Ignore
    @Test
    public void testHaidukLibrary() {
        getDriver().get("https://www.merriam-webster.com/");
        getDriver().findElement(By.id("s-term")).sendKeys("anything");
        getDriver().findElement(By.className("search-icon")).click();
        Assert.assertEquals(getDriver().findElement(By.className("learn-more-header")).getText(),
                "Learn More about anything");
    }

    @Test
    public void testLarisaMalushkina() {

        getDriver().get("https://marshalls.com/");
        WebElement modalClose = getDriver().findElement(By.xpath("//*[@id='modal-close']"));
        modalClose.click();
        WebElement inputField = getDriver().findElement(By.xpath("//input[@id='search-text-input']"));
        inputField.sendKeys("dress");
        WebElement searchButton = getDriver().findElement(By.xpath("//input[@id='search-submit-button']"));
        searchButton.click();
        WebElement result = getDriver().findElement(By.xpath("//h1[contains(text(),'Dresses')]"));
        Assert.assertEquals(result.getText(), "Dresses");
    }

    @Test
    public void testEvgeniyaPiskunova() {
        getDriver().get("https://www.teamunify.com/team/recccvscdhost/page/home");
        getDriver().findElement(By.xpath("//div[@id='menuBar']//a")).click();
        WebElement searchResult = getDriver().findElement(By.xpath("//h1[contains(text(),'Welcome Back Otters!')]"));
        String searchResultText = searchResult.getText();
        Assert.assertEquals(searchResultText, "Welcome Back Otters!");
    }

    @Test
    public void testVitaliiDmitrenko() {

        getDriver().get("https://www.gismeteo.ua/weather-kharkiv-5053/");
        WebElement tenDaysButton = getDriver().findElement(By.xpath("//a[@href='/weather-kharkiv-5053/10-days/']"));
        tenDaysButton.click();

        WebElement tenDaysTitle = getDriver().findElement(By.xpath("//div[@class='pageinfo_title index-h1']//h1"));
        Assert.assertEquals(tenDaysTitle.getText(), "Погода в Харькове на 10 дней");

        WebElement monthButton = getDriver().findElement(By.xpath("//a[@href='/weather-kharkiv-5053/month/']"));
        monthButton.click();

        WebElement monthTitle = getDriver().findElement(By.xpath("//div[@class='pageinfo_title index-h1']//h1"));
        Assert.assertEquals(monthTitle.getText(), "Погода в Харькове на месяц");
    }

    @Test
    public void testNettMax() {
        getDriver().get("https://www.keyfood.com/");
        WebElement input = getDriver().findElement(By.className("js-site-search-input"));
        input.sendKeys("meat\n");
        WebElement result = getDriver().findElement(By.xpath("//h1"));
        Assert.assertEquals(result.getText(), "You Searched for \"MEAT\"");
    }

    @Ignore
    @Test
    public void testNataliaBoiko() throws InterruptedException {
        getDriver().get("https://akniga.org/");
        List<WebElement> listOfAllLinks = getDriver().findElements(By.xpath("/html/body/main/div[3]/div[1]/div/a"));
        Random random = new Random();
        int NumberOfrandomCategory = random.nextInt(listOfAllLinks.size());
        String NameOfCategory = listOfAllLinks.get(NumberOfrandomCategory).getText().toLowerCase();
        listOfAllLinks.get(NumberOfrandomCategory).click();
        if (getDriver().getCurrentUrl().contains("google")) {
            getDriver().get(listOfAllLinks.get(NumberOfrandomCategory).getAttribute("href"));
            Thread.sleep(500);
        }
        Assert.assertTrue(getDriver().findElement(By.tagName("h1")).getText().toLowerCase().contains(NameOfCategory));
        getDriver().findElement(By.xpath("/html/body/main/div[1]/div[4]/div[1]/div/a[2]")).click();
        Thread.sleep(1000);
        List<WebElement> listOfResult = getDriver().findElements(By.className("content__main__articles--item"));
        int Counter = 0;
        for (WebElement el : listOfResult) {
            int CurrentScore = 0;
            try {
                CurrentScore = Integer.parseInt(el.findElement(By.className("ls-vote-item-up")).getText());
            } catch (Exception e) {
            }
            try {
                CurrentScore -= Integer.parseInt(el.findElement(By.className("ls-vote-item-down")).getText());
            } catch (Exception e) {
            }
            if (Counter == 0) Counter = CurrentScore;
            try {
                Assert.assertTrue(Counter >= CurrentScore);
            } catch (AssertionError e) {
                System.out.println("Error: " + el.findElement(By.className("caption__article-main")).getText());
            }
            Counter = CurrentScore;
        }
        getDriver().findElement(By.xpath("/html/body/main/div[1]/div[4]/div[1]/div/a[3]")).click();
        Thread.sleep(1000);
        listOfResult = getDriver().findElements(By.className("content__main__articles--item"));
        Counter = 0;
        for (WebElement el : listOfResult) {
            String textComments = el.findElement(By.className("link__action--comment")).getText();
            int CurrentScore = 0;
            try {
                CurrentScore = Integer.parseInt(textComments.substring(0, textComments.indexOf(" ")));
            } catch (Exception e) {
            }
            if (Counter == 0) Counter = CurrentScore;
            try {
                Assert.assertTrue(Counter >= CurrentScore);
            } catch (AssertionError e) {
                System.out.println("Error: " + el.findElement(By.className("caption__article-main")).getText());
            }
            Counter = CurrentScore;
        }
    }
}
