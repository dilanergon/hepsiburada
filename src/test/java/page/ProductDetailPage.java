package page;

import constants.ProductDetail_Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.WaitTool;

public class ProductDetailPage extends ProductDetail_Constants {

    public ProductDetailPage(WebDriver driver) { super(driver); }

    String checkMessage;

    public ProductDetailPage checkToBasket() throws Exception {

        String actualUrl="https://checkout.hepsiburada.com/sepetim";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        WaitTool.waitForElementClickable(driver,CHECKADDEDPRODUCT,5);
        checkMessage = driver.findElement(CHECKADDEDPRODUCT).getText();
        Assert.assertEquals("2 ürün",checkMessage);
        this.takeSnapShot(driver, "C:\\Users\\Dilan\\IdeaProjects\\web\\src\\test\\resources\\test.png") ;

        return this;
    }
}