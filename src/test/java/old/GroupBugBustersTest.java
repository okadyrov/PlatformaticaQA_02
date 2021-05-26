package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Ignore
public class GroupBugBustersTest extends BaseTest {

    @Test
    public void testMK() {
        getDriver().get("https://www.dillards.com/");
        getDriver().findElement(By.id("topcat_Kids")).click();
        WebElement result = getDriver().findElement(By.linkText("Girls"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Ignore
    @Test
    public void testLudaPetkel() {
        getDriver().get("https://www.flooringliquidators.ca/");
        getDriver().findElement(By.linkText("About")).click();
        WebElement result = getDriver().findElement(By.xpath("//strong[.='About Us']"));
        Assert.assertTrue(result.isDisplayed());
        WebElement phone = getDriver().findElement(By.className("show-phones"));
        Assert.assertEquals(phone.getText(), "1 (866) 473-7222");
    }

    @Ignore
    @Test
    public void testAndreyTeterin() {
        getDriver().get("https://www.btcsatoshi.com/");
        WebElement price = getDriver().findElement(By.xpath("//label[@id='oneBitcoin']"));
        Assert.assertEquals(price.getText(), getDriver().getTitle().substring(1, 9));
    }

    @Test
    public void testMikhailMir() {
        getDriver().get("https://www.wasserstrom.com/");
        String parentHandle = getDriver().getWindowHandle();
        getDriver().findElement(By.id("Header_GlobalLogin_signInQuickLink")).click();

        for (String childHandle : getDriver().getWindowHandles()) {
            if (!childHandle.equals(parentHandle)) {
                getDriver().switchTo().window(childHandle);
                break;
            }
        }

        WebElement loginField = getDriver().findElement(By.id(
                "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
        loginField.sendKeys("userWasserStrom");

        WebElement passwordField = getDriver().findElement(By.id(
                "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));
        passwordField.sendKeys("WasserStrom4321!");

        WebElement checkbox = getDriver().findElement(By.id(
                "Header_GlobalLogin_WC_AccountDisplay_FormInput_rememberMe_In_Logon_1_img"));
        checkbox.click();

        WebElement buttonSignIn = getDriver().findElement(By.id(
                "Header_GlobalLogin_WC_AccountDisplay_links_2"));
        buttonSignIn.click();

        WebElement iconUser = getDriver().findElement(By.id(
                "Header_GlobalLogin_signOutQuickLink"));
        Assert.assertTrue(iconUser.isDisplayed());
    }

    @Test
    public void testStanislavKaplanYandexlogoPresence() {
        getDriver().get("http://yandex.com");
        getDriver().manage().window().maximize();
        boolean result;
        result = getDriver().findElements(By.xpath("//div[@class = 'logo__image_bg']")).size() > 0;
        Assert.assertTrue(result, "Logo is here");
    }

    @Ignore
    @Test
    public void testRomanB() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get("https://www.homedepot.com/");

        WebElement input = getDriver().findElement(By.id("headerSearch"));
        input.sendKeys("aluminum angle\n");

        WebElement finder = getDriver().findElement(By.xpath("//span[@class ='product-pod__title__product']"));

        Assert.assertTrue(finder.getText().toLowerCase().contains("aluminum angle"));
        }
    
  @Ignore
        @Test
    public void testEdwardNasdaq(){
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get("https://www.nasdaq.com/");

        getDriver().findElement(By.className("primary-nav__anchor-text")).click();
        getDriver().findElement(By.id("find-symbol-input-dark")).sendKeys("AAPL");
        getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        getDriver().findElement(By.className("find-symbol__suggestion")).click();

        WebElement AppleStock = getDriver().findElement(By.className("symbol-page-header__name"));
        Assert.assertEquals(AppleStock.getText(), "Apple Inc. Common Stock (AAPL)");
    }

    @Test
    public void testTimYoshi() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get("https://www.lamborghini.com/en-en");
        getDriver().findElement(By.linkText("MODELS")).click();
        WebElement lambo = getDriver().findElement(By.xpath("/html/body/div/div[1]/div/section[2]/div[2]/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div[3]/a/span"));
        Assert.assertEquals(lambo.getText(),"AVENTADOR SVJ");

    }

    @Test
    public void testYevgeniyaRudenko() {
        getDriver().get("https://demoqa.com/automation-practice-form");

        WebElement firstName = getDriver().findElement(By.id("firstName"));
        firstName.sendKeys("Yevgeniya");
        WebElement lastName = getDriver().findElement(By.id("lastName"));
        lastName.sendKeys("Rudenko");

        WebElement genderFemale = getDriver().findElement(By.xpath("//input[@name='gender'][@value='Female']"));
        TestUtils.jsClick(getDriver(), genderFemale);

        WebElement mobilePhone = getDriver().findElement(By.xpath("//input[@id='userNumber']"));
        mobilePhone.sendKeys("0123456789");

        WebElement checkBoxValue1 = getDriver().findElement(By.xpath("//input[@type='checkbox'][@value=1]"));
        TestUtils.jsClick(getDriver(), checkBoxValue1);

        WebElement address = getDriver().findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("11 Washington St., Seattle, WA, 56043");

        TestUtils.jsClick(getDriver(), getDriver().findElement(By.id("submit")));


        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("example-modal-sizes-title-lg"),
                "Thanks for submitting the form"));


        WebElement formHeader = getDriver().findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(formHeader.getText(),"Thanks for submitting the form");

        WebElement firstNameLastName = getDriver().findElement(By.xpath("//tr[td='Student Name']/td[2]"));
        Assert.assertEquals(firstNameLastName.getText(),"Yevgeniya Rudenko");

        WebElement gender = getDriver().findElement(By.xpath("//tr[td='Gender']/td[2]"));
        Assert.assertEquals(gender.getText(),"Female");

        WebElement mobile = getDriver().findElement(By.xpath("//tr[td='Mobile']/td[2]"));
        Assert.assertEquals(mobile.getText(), "0123456789");

        WebElement hobby = getDriver().findElement(By.xpath("//tr[td='Hobbies']/td[2]"));
        Assert.assertEquals(hobby.getText(), "Sports");

        WebElement addressFull = getDriver().findElement(By.xpath("//tr[td='Address']/td[2]"));
        Assert.assertEquals(addressFull.getText(), "11 Washington St., Seattle, WA, 56043");
    }

    @Test
    public void testBzhumanova() {
        getDriver().get("https://www.verywellhealth.com/");

        getDriver().findElement(By.id("header-search-button_1-0")).click();
        WebElement searchInput = getDriver().findElement(By.id("search-input"));
        searchInput.sendKeys("acne\n");

        WebElement featureBlockFinder = getDriver().findElement(By.xpath("/html/body/main/div[1]/section/div[2]/ul/li[1]"));
        WebElement featureTitleFinder = featureBlockFinder.findElement(By.className("block__title"));
        Assert.assertEquals(featureTitleFinder.getText(), "Tweens - Growth and Development");
    }

    @Test
    public void testValeriiSarukhanov1() {

        getDriver().get("http://www.vlp.com/");

        WebElement input = getDriver().findElement(By.xpath("//li//*[text()='Contact Us']"));
        input.click();

        WebElement information = getDriver().findElement(By.id("contactUsNoticeContent"));

        Assert.assertTrue(information.getText().contains("Contact Us"));
    }
}