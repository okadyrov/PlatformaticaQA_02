package old;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Ignore
public class OlgaKTest extends BaseTest {

    @Test
    public void testOlgaKovtun() {

        getDriver().get("https://www.codewars.com/");

        WebElement logInButton = getDriver().findElement(
                By.xpath("//section[@id='header_section']/ul/li/a[contains(text(),'Log In')]"));
        logInButton.click();

        WebElement emailField = getDriver().findElement(By.id("user_email"));
        emailField.sendKeys("tester1");

        WebElement passwordField = getDriver().findElement(By.id("user_password"));
        passwordField.sendKeys("12345");

        WebElement signInButton = getDriver().findElement(
                By.xpath("//form[@id='new_user']/button[contains(text(), 'Sign in')]"));
        signInButton.click();

        String errorText = getDriver().findElement(
                By.cssSelector("div.alert-box.error.flash-msg.error")).getText();

        Assert.assertEquals(errorText, "Invalid Email or password.");
    }
}
