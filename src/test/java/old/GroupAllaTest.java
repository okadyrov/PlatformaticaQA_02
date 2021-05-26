package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;



@Ignore
public class GroupAllaTest  extends BaseTest {

    @Test
    public void poptsovRomanTest() throws InterruptedException {

        getDriver().get("https://10mail.org/");
        Thread.sleep(3000); //awaiting the issuance of the address

        WebElement mailArea = getDriver().findElement(By.className("address"));
        String currentString = mailArea.getText();
        System.out.println("Received mail: " + currentString);

        boolean checkMail = !currentString.equals("");

        Assert.assertTrue(checkMail, "email not received");

    }

    @Ignore
    @Test
    public void testGunchenkoAlex() {

        getDriver().get("https://www.google.com/");
        WebElement input = getDriver().findElement(By.className("gLFyf"));
        input.sendKeys("gismeteo\n");

        WebElement GismeteoButton = getDriver().findElement(By.xpath("//h3[contains(text(),'GISMETEO:')]"));
        GismeteoButton.click();

        WebElement searchField = getDriver().findElement(By.id("js-search"));
        searchField.sendKeys("Харьков\n");
        getDriver().findElement(By.linkText("Харьков")).click();
        getDriver().findElement(By.xpath("/html/body/section/nav/div/ul/li[6]/a")).click();
        getDriver().findElement(By.xpath("/html/body/section/nav/div/ul/li[7]/a")).click();

        WebElement pageTitile = getDriver().findElement(By.tagName("h1"));
        String pageTitleName = pageTitile.getText();
        Assert.assertEquals(pageTitleName, "Погода в аэропорту Харьков на месяц");
    }

    @Ignore
    @Test
    public void testSherstnevaHanna() {
        getDriver().get("https://www.tut.by/");
        getDriver().findElement(By.xpath("//a[@class=\'enter\']")).click();
        Boolean result = getDriver().findElement(By.xpath("//div[@class='b-auth-form__inner']//div[2]/input")).isEnabled();
        Assert.assertFalse(result);
    }

    @Ignore
    @Test
    public void testIgorChupin() throws InterruptedException {

        getDriver().get("https://www.tut.by/");
        WebElement input = getDriver().findElement(By.className("enter"));
        input.click();

        WebElement username = getDriver().findElement(By.name("login"));
        username.sendKeys("unexistingmail@mail.com");

        WebElement password = getDriver().findElement(By.name("password"));
        password.sendKeys("password");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//input[@value=\'Войти\']"));
        buttonEnter.click();

        Thread.sleep(1000); //без этого ответ не всегда успевает появиться
        Assert.assertEquals(getDriver().findElement(By.className("error-msg")).getText(),
                "Неверное имя пользователя или пароль");
    }

    @Ignore
    @Test
    public void vladimirMiskoTest() {

        getDriver().get("https://www.google.com/");

        WebElement input = getDriver().findElement(By.className("gLFyf"));

        input.sendKeys("tut.by\n");

        WebElement result = getDriver().findElement(
                By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));

        Assert.assertEquals(result.getText(), "Белорусский портал TUT.BY. Новости Беларуси и мира");
    }

    @Test
    public  void testJuliaKnyazeva() {

        getDriver().get("https://software-testing.ru/");

        WebElement input = getDriver().findElement(By.xpath("//a[@href='/library']"));
        input.click();

        WebElement result = getDriver().findElement(By.xpath("//a[@href='/library/testing/" +
                "testing-for-beginners?layout=default']"));
        Assert.assertEquals(result.getText(), "Начинающему тестировщику");
    }

}
