package litecart.appmanager;

import litecart.model.ProductData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class ProductHelper {

   private ChromeDriver driver;

    private boolean acceptNextAlert = true;

    public ProductHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void SaveNewProduct() {
      driver.findElement(By.name("save")).click();
    }

    public void fillProductForm(ProductData productData) {
      driver.findElement(By.name("name[en]")).click();
      driver.findElement(By.name("name[en]")).clear();
      driver.findElement(By.name("name[en]")).sendKeys(productData.getProductName());
      driver.findElement(By.linkText("Information")).click();
      driver.findElement(By.name("short_description[en]")).click();
      driver.findElement(By.name("short_description[en]")).clear();
      driver.findElement(By.name("short_description[en]")).sendKeys(productData.getProductDescription());
    }

    public void AddNewProduct() {
      driver.findElement(By.linkText("Add New Product")).click();
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

    public void DeleteProduct() {
      acceptNextAlert = true;
      driver.findElement(By.name("delete")).click();
      assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
    }

    public void FindProductToBeDeleted() {
      driver.findElement(By.name("products[34]")).click();
    }
}
