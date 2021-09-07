package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    public static String baseUrl = "https://www.hepsiburada.com/";


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    } // chromedriver

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(baseUrl);
        driver.get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
       driver.quit();
    }
}
