package litecart.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        if (driver !=null) {
            return;
        }
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\System32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null;}));
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
    }
}
