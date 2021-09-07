package page;

import constants.Main_Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.WaitTool;

public class MainPage extends Main_Constants {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String email,String password) {
        sleep(5000);
        Assert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi"));
        hoverRegisterMenu();
        clickObjectBy(ACCOUNTLOGINBUTTON);
        WaitTool.waitForElementClickable(driver, EMAIL, 5);
        setObjectBy(EMAIL, email);
        setObjectBy(PASSWORD, password);
        clickObjectBy(LOGINBUTTON);
        return new MainPage(driver);
    }

    public MainPage getResults(){
        WaitTool.waitForElementClickable(driver,SEARCHAREA, 8);
        clickObjectBy(SEARCHAREA);
        setObjectBy(SEARCHAREA, "Huawei");
        clickObjectBy(SEARCHBUTTON);
        return this;
    }

    public void hoverRegisterMenu(){
        Actions actions = new Actions(driver);
        WebElement hoverElement = driver.findElement(LOGINHOVER);
        actions.moveToElement(hoverElement).perform();
        WaitTool.waitForElementClickable(driver,ACCOUNTLOGINBUTTON,5);
    }

    public ResultsPage checkResults(){
        isElementPresent(CHECKRESULTTEXT);
        return new ResultsPage(driver);
    }

}
