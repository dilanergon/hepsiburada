package page;

import constants.Results_Constants;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.WaitTool;

public class ResultsPage extends Results_Constants {

    public String name1 = null;
    public String name2 = null;

    public ResultsPage(WebDriver driver) {super(driver);}

    public ResultsPage goToProductDetail(){

        String actualUrl="https://www.hepsiburada.com/ara?q=Huawei";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        WaitTool.waitForElementClickable(driver,ADDEDPRODUCT, 1);
        clickObjectBy(ADDEDPRODUCT);
        return this;
    }


    public ResultsPage addToBasket(){

        WaitTool.waitForElementClickable(driver, ADDEDPRODUCTNAME1, 7);
        name1 = driver.findElement(ADDEDPRODUCTNAME1).getText();
        System.out.println(name1);

        WaitTool.waitForElementClickable(driver, ADDTOBASKET, 7);
        clickObjectBy(ADDTOBASKET);
        clickObjectBy(CLOSEPOPUP);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        WaitTool.waitForElementClickable(driver,ADDTOBASKETOTHERSELLER, 7);
        clickObjectBy(ADDTOBASKETOTHERSELLER);
        clickObjectBy(CLOSEPOPUP2);
        clickObjectBy(CLOSEPOPUP3);

        WaitTool.waitForElementClickable(driver,MYBASKET, 7);
        clickObjectBy(MYBASKET);

        return this;
    }

     public ProductDetailPage goToBasket(){

        WaitTool.waitForElementClickable(driver, ADDEDPRODUCTNAME2, 7);
        name2 = driver.findElement(ADDEDPRODUCTNAME2).getText();
        System.out.println(name2);
        Assert.assertEquals(name1, name2);

        return new ProductDetailPage(driver);
    }

}
