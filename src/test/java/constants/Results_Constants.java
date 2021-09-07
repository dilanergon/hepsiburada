package constants;

import base.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results_Constants extends BasePageUtil {
    public Results_Constants(WebDriver driver) {
        super(driver);
    }

    public By ADDEDPRODUCTNAME1 = By.cssSelector("h1#product-name");
    public By ADDEDPRODUCT = By.cssSelector("[data-bind] [data-index='1']:nth-child(4) a");
    public By ADDEDPRODUCTNAME2 = By.cssSelector("li:nth-of-type(2) .product_name_3Lh3t > a");
    public By ADDTOBASKET = By.cssSelector("button#addToCart");
    public By CLOSEPOPUP = By.cssSelector(".checkoutui-Modal-2iZXl");
    public By ADDTOBASKETOTHERSELLER = By.cssSelector("tr:nth-of-type(1) > .form-area > .addToCart > form[method='post'] > .add-to-basket.button.small");
    public By CLOSEPOPUP2 = By.cssSelector("[data-bind='css\\: \\{\\'preLoader\\'\\: lineItemForm\\.isLoading\\(\\)\\}'] .close");
    public By MYBASKET = By.cssSelector("span#shoppingCart");
    public By CLOSEPOPUP3 = By.cssSelector(".checkoutui-Modal-2iZXl > svg");

}
