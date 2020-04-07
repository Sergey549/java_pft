package litecart.appmanager;

import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManage {

    ChromeDriver driver;

    private ProductHelper productHelper;
    private SessionHelper sessionHelper;

    public boolean acceptNextAlert = true;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://admin:admin@localhost/litecart/public_html/admin/login.php");
        sessionHelper.login("admin", "admin");
        productHelper = new ProductHelper(driver);
        sessionHelper = new SessionHelper(driver);
    }


    public void testEnd() {
        driver.quit();
        driver = null;
    }

    @After
    public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }

    public String closeAlertAndGetItsText() {
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

    public ProductHelper getProductHelper() {
        return productHelper;
    }
}
