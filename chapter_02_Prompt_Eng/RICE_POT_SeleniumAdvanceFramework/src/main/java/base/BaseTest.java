package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final String SALESFORCE_URL = "https://login.salesforce.com/?locale=in";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.get(SALESFORCE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null) {
            if (result != null && !result.isSuccess()) {
                captureScreenshot(result.getName());
            }
            driver.quit();
            driver = null;
        }
    }

    protected void captureScreenshot(String testName) {
        try {
            Path screenshotDir = Path.of("target", "screenshots");
            Files.createDirectories(screenshotDir);

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = screenshotDir.resolve(testName + ".png").toFile();
            Files.copy(screenshot.toPath(), destination.toPath());
        } catch (IOException e) {
            System.err.println("Unable to save screenshot for failed test: " + testName);
            e.printStackTrace();
        }
    }
}
