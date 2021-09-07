package test;

import base.BaseTest;
import org.junit.Test;
import page.MainPage;
import util.ReadProperties;

public class ResultsTest extends BaseTest {

    @Test
    public void productTests() throws Exception {
        new MainPage(driver)
                .login(ReadProperties.getTrueEmail(), ReadProperties.getTruePassword())
                .getResults()
                .checkResults()
                .goToProductDetail()
                .addToBasket()
                .goToBasket()
                .checkToBasket();
    }
}


