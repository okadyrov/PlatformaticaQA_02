package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class GroupRunSuccessTest extends BaseTest {

    @Ignore
    @Test
    public void testDimaStepanenko() throws InterruptedException {
        getDriver().get("http://demowebshop.tricentis.com/");

        WebElement buttonBooks = getDriver().findElement(By.xpath("//div[@class=\"listbox\"]/ul/li/a[@href=\"/books\"]"));
        buttonBooks.click();
        WebElement clickScienceBook = getDriver().findElement(By.xpath("//h2/a[@href=\"/fiction\"]"));
        clickScienceBook.click();
        WebElement qtyField = getDriver().findElement(By.id("addtocart_45_EnteredQuantity"));
        qtyField.clear();
        qtyField.sendKeys("2");
        WebElement pushAddToCartButton = getDriver().findElement(By.id("add-to-cart-button-45"));
        pushAddToCartButton.click();
        WebElement clickShoppingCartLink = getDriver().findElement(
                By.xpath("//li/a[@href=\"/cart\"]/span[@class=\"cart-label\"]"));
        clickShoppingCartLink.click();
        Thread.sleep(2000);
        WebElement total = getDriver().findElement(
                By.xpath("//td[@class=\"subtotal nobr end\"]/span[@class=\"product-subtotal\"]"));
        Assert.assertEquals(total.getText(), String.format("%.2f", 48.0));
    }
}
