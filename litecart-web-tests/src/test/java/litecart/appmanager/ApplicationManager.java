package litecart.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ApplicationManager {

    ChromeDriver driver;
    WebDriverWait wait;
    private NavigationHelper navigationHelper;
    private ProductHelper productHelper;
    private SessionHelper sessionHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        productHelper = new ProductHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "df4Tu75nk8lf2w");
    }


    public void checkAdminMainPageIsTrue() {
        wait.until(urlContains("http://localhost:8080/litecart/public_html/admin/"));
    }

    public void stop() {
        driver.quit();
    }

    public ProductHelper getProductHelper() {
        return productHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

}
