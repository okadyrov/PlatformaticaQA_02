package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class IrinaBTest extends BaseTest {

    @Test
    public void testIrinaB() {
        getDriver().get("http://www.99-bottles-of-beer.net/");

        WebElement actualResult = getDriver().findElement(By.xpath("//div[@id='main']/h2"));

        Assert.assertEquals(actualResult.getText(), "Welcome to 99 Bottles of Beer");
    }

    @Ignore
    @Test
    public void testIrinaB2() {
        getDriver().get("https://us.etrade.com/home");

        WebElement tradingMenuLink = getDriver().findElement(By.xpath("//ul[@id='menu']/li/a/span[text()='Trading']"));      
        tradingMenuLink.click();

        WebElement openAccountLinkText = getDriver().findElement(By.linkText("Open an account"));
        openAccountLinkText.click();

        WebElement chooseYourOption = getDriver().findElement(By.xpath("//input[@id='BROKERAGE']"));

        Assert.assertTrue(chooseYourOption.isSelected());

        getDriver().findElement(By.xpath("//div/button[text()='Continue']")).click();

        WebElement chooseBrokerageAccountTypeText = getDriver().findElement(By.xpath("//div/h1"));

        Assert.assertEquals(chooseBrokerageAccountTypeText.getText(), "Choose account type");
    }
}
