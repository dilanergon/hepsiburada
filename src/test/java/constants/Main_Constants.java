package constants;

import base.BasePageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main_Constants extends BasePageUtil {

    public Main_Constants(WebDriver driver) {
        super(driver);
    }


    public By LOGINHOVER = By.id("myAccount");
    public By ACCOUNTLOGINBUTTON = By.id("login");
    public By EMAIL = By.id("txtUserName");
    public By PASSWORD = By.id("txtPassword");
    public By LOGINBUTTON = By.id("btnLogin");
    public By SEARCHAREA = By.cssSelector("div[role='combobox'] > .desktopOldAutosuggestTheme-input");
    public By SEARCHBUTTON = By.xpath("/html//div[@id='SearchBoxOld']//div[@class='SearchBoxOld-buttonContainer']");
    public By CHECKRESULTTEXT = By.className(".totalCount");

}
