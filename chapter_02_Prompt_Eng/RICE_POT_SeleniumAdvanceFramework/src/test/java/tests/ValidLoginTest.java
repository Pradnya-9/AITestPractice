package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class ValidLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/?locale=in");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        if (username == null || password == null) {
            throw new IllegalArgumentException("username and password system properties are required");
        }
        loginPage.login(username, password, true);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should succeed for valid credentials");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
