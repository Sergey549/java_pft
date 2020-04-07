package litecart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    protected boolean acceptNextAlert = true;
    ChromeDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://admin:admin@localhost/litecart/public_html/admin/login.php");
      login("admin", "admin");
    }

    private void login(String username, String password) {
      driver.findElement(By.name("username")).click();
      driver.findElement(By.name("username")).clear();
      driver.findElement(By.name("username")).sendKeys(username);
      driver.findElement(By.name("password")).clear();
      driver.findElement(By.name("password")).sendKeys(password);
      driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    protected void fillProductForm(ProductData productData) {
      driver.findElement(By.name("name[en]")).click();
      driver.findElement(By.name("name[en]")).clear();
      driver.findElement(By.name("name[en]")).sendKeys(productData.getName());
      driver.findElement(By.linkText("Information")).click();
      driver.findElement(By.name("short_description[en]")).click();
      driver.findElement(By.name("short_description[en]")).clear();
      driver.findElement(By.name("short_description[en]")).sendKeys(productData.getShortDescription());
    }

    protected void gotoProductCreation() {
      driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[2]/a/span[2]")).click();
    }

    protected void initProductCreation() {
      driver.findElement(By.linkText("Add New Product")).click();
    }

    protected void saveProductForm() {
      driver.findElement(By.name("save")).click();
    }

    @After
    public void stop() {
      driver.quit();
      driver = null;
    }


    protected void DeleteProduct() {
      driver.findElement(By.name("delete")).click();
    }

    protected void FindProduct() {
      driver.findElement(By.name("products[25]")).click();
    }

    @After
    public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
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

    protected String closeAlertAndGetItsText() {
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
