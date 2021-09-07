package test;

import base.BaseTest;
import org.junit.Test;
import page.MainPage;
import util.ReadProperties;

public class LoginTest extends BaseTest {

    @Test
    public void succesLogin() {
        new MainPage(driver)
                .login(ReadProperties.getTrueEmail(), ReadProperties.getTruePassword())
                .getResults()
                .checkResults();
    }

    @Test
    public void failedLoginFalseEmail() {
        new MainPage(driver)
                .login(ReadProperties.getFalseEmail(), ReadProperties.getTruePassword());
    }


    @Test
    public void failedLoginFalsePassword() {
        new MainPage(driver)
                .login(ReadProperties.getTrueEmail(), ReadProperties.getFalsePassword());
    }

    @Test
    public void failedLoginNullPassword() {
        new MainPage(driver)
                .login(ReadProperties.getTrueEmail(), "");
    }

    @Test
    public void failedLoginNullEmail() {
        new MainPage(driver)
                .login("", ReadProperties.getTruePassword());
    }

    @Test
    public void failedLogin() {
        new MainPage(driver)
                .login(ReadProperties.getFalseEmail(), ReadProperties.getFalsePassword());
    }

}