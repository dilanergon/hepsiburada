package test;

import base.BaseTest;
import org.junit.Test;
import page.MainPage;

public class ResultTestWithoutSignIn extends BaseTest {

    @Test
    public void productTests() throws Exception {
        new MainPage(driver)
                .getResults()
                .checkResults()
                .goToProductDetail()
                .addToBasket()
                .goToBasket()
                .checkToBasket();
    }
}
