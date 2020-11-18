package litecart.appmanager;

import litecart.model.ProductData;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ApplicationManager {
    public WebDriverWait wait;
    ChromeDriver driver;
    private boolean acceptNextAlert = true;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        login("admin", "df4Tu75nk8lf2w");
    }

    private void login(String username, String password) {
        driver.get("http://admin:df4Tu75nk8lf2w@localhost:8080/litecart/public_html/admin/login.php");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    public void saveProduct() {
        driver.findElement(By.name("save")).click();
    }

    public void fillProductForm(ProductData productData) {
        driver.findElement(By.name("name[en]")).click();
        driver.findElement(By.name("name[en]")).clear();
        driver.findElement(By.name("name[en]")).sendKeys(productData.getDuckName());
        driver.findElement(By.linkText("Information")).click();
        driver.findElement(By.name("short_description[en]")).click();
        driver.findElement(By.name("short_description[en]")).clear();
        driver.findElement(By.name("short_description[en]")).sendKeys(productData.getShortDescription());
        driver.findElement(By.xpath("//div[@id='en']/div[2]/div/div/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='en']/div[2]/div/div/div[2]")).clear();
        driver.findElement(By.xpath("//div[@id='en']/div[2]/div/div/div[2]")).sendKeys(productData.getDescription());
        driver.findElement(By.name("technical_data[en]")).click();
        driver.findElement(By.name("technical_data[en]")).clear();
        driver.findElement(By.name("technical_data[en]")).sendKeys(productData.getTechnicalData());
    }

    public void initProductCreation() {
        driver.findElement(By.xpath("//a[contains(.,' Add New Product')]")).click();
    }

    public void goToCatalog() {
        driver.findElement(By.xpath("//span[contains(.,'Catalog')]")).click();
    }

    public void checkAdminMainPageIsTrue() {
        wait.until(
                urlContains("http://localhost:8080/litecart/public_html/admin/"));
    }

    public void checkProductToBeDeletedSuccessfully() {
        WebElement modalText = driver.findElement(By.xpath("//div[@id='notices']"));
        Assert.assertEquals("Deleted 1 products",
                modalText.getText().substring(2));
    }

    public void acceptDeletion() {
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
    }

    public void deleteProduct() {
        driver.findElement(By.name("delete")).click();
    }

    public void checkProductToBeDeleted() {
        driver.findElement(By.name("products[70]")).click();
    }

    public void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
