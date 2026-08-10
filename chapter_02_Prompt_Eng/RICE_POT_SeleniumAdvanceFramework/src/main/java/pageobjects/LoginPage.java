package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[contains(@id,'error')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String value) {
        try {
            wait.until(ExpectedConditions.visibilityOf(username));
            username.clear();
            username.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username", e);
        }
    }

    public void enterPassword(String value) {
        try {
            wait.until(ExpectedConditions.visibilityOf(password));
            password.clear();
            password.sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password", e);
        }
    }

    public void clickRememberMe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to click remember me", e);
        }
    }

    public void clickLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login", e);
        }
    }

    public void login(String user, String pass, boolean remember) {
        enterUsername(user);
        enterPassword(pass);
        if (remember) {
            clickRememberMe();
        }
        clickLogin();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginSuccessful() {
        try {
            return wait.until(ExpectedConditions.urlContains("/lightning"));
        } catch (Exception e) {
            return false;
        }
    }
}
