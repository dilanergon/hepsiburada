package constants;

import base.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail_Constants extends BasePageUtil {

    public ProductDetail_Constants(WebDriver driver) {
        super(driver);
    }

    public By CHECKADDEDPRODUCT = By.cssSelector(".basket_itemCount_54lDX");

}

