package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class ValidLoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        if (username == null || password == null) {
            throw new SkipException("Set username and password system properties to run the authenticated Salesforce test");
        }
        loginPage.login(username, password, true);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should succeed for valid credentials");
    }
}
