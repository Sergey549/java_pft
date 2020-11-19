package litecart.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ApplicationManager {

    WebDriver driver;
    WebDriverWait wait;
    private String browser;
    private NavigationHelper navigationHelper;
    private ProductHelper productHelper;
    private SessionHelper sessionHelper;
    private CategoryHelper categoryHelper;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
        wait = new WebDriverWait(driver, 5);
        productHelper = new ProductHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        categoryHelper = new CategoryHelper(driver);
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

    public CategoryHelper getCategoryHelper() {
    return categoryHelper;
    }
}
